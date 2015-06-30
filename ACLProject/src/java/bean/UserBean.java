/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import BO.UserBO;
import DAO.PermissionDAO;
import DAO.UserDAO;
import helper.ConstantKey;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
import pojo.Group;
import pojo.Permission;
import pojo.Role;
import pojo.User;


public class UserBean {
    
    private String error;
    private String userID;
    private String pass;
    private User user;
    
    private Message message;
    
    private String oldPass;
    private String newPass;
    private String newPass2;
    
    private User newUser = new User();

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }
    
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }

    
    
    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getNewPass2() {
        return newPass2;
    }

    public void setNewPass2(String newPass2) {
        this.newPass2 = newPass2;
    }

    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public User getUser() {
        return user;
    }
    public User getLoggedUser() {
         return (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(ConstantKey.USER_HANDLE);
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public  String goToUserInfo() {
        return "userInfo.xhtml";
    }
    //<editor-fold defaultstate="collapsed" desc="Chuc nang dang nhap">
    public String login() {
        String result = UserBO.login(userID, pass);
        if (result.equals("fail")) {
            this.error = "Username or Password in Incorrect!";
        } else if (result.equals("disable")) {
            this.error = "Your Account has been Disable ! Please Contact Admin !";
            result="fail";
        } 
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy thông tin User thông qua id">
    public User getUserByID(String id) {
        user = UserBO.getUserByID(id);
        return user;
    }
    //</editor-fold>    
    public String logout() {
        
//        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//        
//        return   "../login_admin.xhtml";
        
           FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//        FacesContext ctx = FacesContext.getCurrentInstance();
//        String path = ctx.getExternalContext().getRequestContextPath();
//        return   path + "/faces/login_admin.xhtml";
//        
        
        
//        FacesContext context = FacesContext.getCurrentInstance();
//            HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
//    String requestURL = request.getRequestURL().toString();
//            System.out.println("URI: " + requestURL);
//    String url = requestURL.substring(0, requestURL.lastIndexOf("/"));
//    String parentUrl = url.substring(0, requestURL.lastIndexOf("faces/"));
//            System.out.println("ParentURL:" + parentUrl); 
//            String end = parentUrl + "faces/login_admin.xhtml";
//            System.out.println("END:" + end);
//        return end;
           return "../login_admin.xhtml";
    }
    
    public List<User> getListUser() {
        return UserDAO.getUser();
    }
    
    public String create() {
          try {
              if (null == this.newUser.getId() || this.newUser.getId().isEmpty() ) {
               this.message  = new Message(Message.INFO_MESSAGE,"ID CANNOT BE EMPTY");   
               return "userList.xhtml";
              }
              if (null == this.newUser.getName() || this.newUser.getName().isEmpty() ) {
               this.message  = new Message(Message.INFO_MESSAGE,"NAME CANNOT EMPTY");   
               return "userList.xhtml";
              }
                 if (null == this.newUser.getPassword() || this.newUser.getPassword().isEmpty() ) {
               this.message  = new Message(Message.INFO_MESSAGE,"PASSWROD CANNOT EMPTY");   
               return "userList.xhtml";
              }
               newUser.setCreateDate(new Date());
               newUser.setStatus("Enable");
                       
              boolean saveUser =    UserDAO.save(newUser);
              if (saveUser) {
                   Role r = new Role();
                r.setId(newUser.getRoleName());
                Group g = new Group();
                g.setId(newUser.getGroupName());
                Permission p = new Permission();
                 p.setUser(newUser);
                 p.setGroup(g);
                 p.setRole(r);
               
                  if ( PermissionDAO.save(p)) {
                      this.message  = new Message(Message.SUCCESS_MESSAGE,"CREATE NEW USER SUCCESS :" + newUser.getName());
                  } else {
                      this.message  = new Message(Message.ERROR_MESSAGE,"CANNOT SAVE PERMISSION  !" );   
                  }
              } else {
               this.message  = new Message(Message.ERROR_MESSAGE,"CANNOT SAVE USER !" );   
              }
             

              
//             if (o) {
//                 this.message  = new Message(Message.SUCCESS_MESSAGE,"Banned User Success !");
//            } else {
//                 this.message  = new Message(Message.ERROR_MESSAGE,"Banned User Fail !");
//             }
             
        } catch (Exception e) {
            e.printStackTrace();
             this.message  = new Message(Message.ERROR_MESSAGE,"ERROR WHILE CREATE:" + e.getMessage());
        }
        return "userList.xhtml";
    }
    public String logoutOtherRole() {
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext ctx = FacesContext.getCurrentInstance();
        String path = ctx.getExternalContext().getRequestContextPath();
        return   path + "/login_admin.xhtml";
    }
    
     public String changePass() {
        User current = getLoggedUser();
        if (!this.oldPass.equals(current.getPassword())) {
            this.message = new Message(Message.ERROR_MESSAGE, "Pass cũ không đúng");
        } else if (this.newPass.isEmpty() || this.newPass.isEmpty()) {
             this.message = new Message(Message.ERROR_MESSAGE, "Không được để trống password mới ");
        } else if (!this.newPass.equals(newPass2)) {
             this.message = new Message(Message.ERROR_MESSAGE, "Hai Password mới không giống nhau !");
        } else {
            current.setPassword(newPass);
            try {
               boolean  o = UserBO.update(current);
                if (o) {
                    this.message = new Message(Message.INFO_MESSAGE, " Đổi Pass thành công  !");
                } else {
                    this.message = new Message(Message.INFO_MESSAGE, " Đổi Pass thất bại!");
                }
            } catch (Exception ex) {
               this.message = new Message(Message.ERROR_MESSAGE," Fatal Error  :" + ex.getMessage());
            }
            
        }
        return "signList.xhtml";
    }

       public String updateProfile() {
        User current = getLoggedUser();
            try {
               boolean  o = UserBO.update(current);
                if (o) {
                    this.message = new Message(Message.INFO_MESSAGE, " Update Profile thành công  !");
                } else {
                    this.message = new Message(Message.INFO_MESSAGE, " Update Profile thất bại!");
                }
               } catch (Exception ex) {
               this.message = new Message(Message.ERROR_MESSAGE," Fatal Error  :" + ex.getMessage());
            }
        return "signList.xhtml";
    }
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
     
    public void banned(String id) {
        try {
            User current = UserDAO.getUserByID(id);
            current.setStatus("Disable");
             boolean  o = UserBO.update(current);
             if (o) {
                 this.message  = new Message(Message.SUCCESS_MESSAGE,"Banned User Success !");
            } else {
                 this.message  = new Message(Message.ERROR_MESSAGE,"Banned User Fail !");
             }
            
        } catch (Exception e) {
            e.printStackTrace();
                 this.message  = new Message(Message.ERROR_MESSAGE,"ERROR WHILE BANNED:" + e.getMessage());
        }
    }
      public void unbanned(String id) {
        try {
            User current = UserDAO.getUserByID(id);
            current.setStatus("Enable");
             boolean  o = UserBO.update(current);
             if (o) {
                 this.message  = new Message(Message.SUCCESS_MESSAGE,"Enable User Success !");
            } else {
                 this.message  = new Message(Message.ERROR_MESSAGE,"Enable User Fail !");
             }
            
        } catch (Exception e) {
            e.printStackTrace();
                 this.message  = new Message(Message.ERROR_MESSAGE,"ERROR WHILE Enable:" + e.getMessage());
        }
    }
     
}
