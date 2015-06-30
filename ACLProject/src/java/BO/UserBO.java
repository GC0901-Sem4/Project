/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.UserDAO;
import helper.ConstantKey;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.context.FacesContext;
import pojo.Permission;
import pojo.Role;
import pojo.User;

/**
 *
 * @author hang
 */
public class UserBO {

    //<editor-fold defaultstate="collapsed" desc="Chuc nang dang nhap">
    public static String login(String userID, String pass) {
        User userLogin = UserDAO.getUserByID(userID);
        String viewID;
        if (userLogin == null) {
            viewID= "fail";
        } else {
            if (userLogin.getStatus().equals("Disable")) {
               viewID = "disable";
            } else {
                if (userLogin.getPassword().equals(pass)) {
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    Set<Permission> permissions = userLogin.getPermissions();
                    Role role = ((Permission) (permissions.toArray()[0])).getRole();
                    userLogin.setRoleName(role.getName());
                    if (role.getId().equals("R001")) {
                       viewID = "successAdmin";
                    } else if (role.getId().equals("R002")) {
                        viewID = "successInstructor";
                    } else {
                        viewID= "successTechnician";
                    }
                    Map session = facesContext.getExternalContext().getSessionMap();
                    session.put(ConstantKey.USER_HANDLE, userLogin);
                } else {
                    viewID = "fail";
                }
            }
        }
        return viewID;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sách user">
    public static List<User> getUser() {
        return UserDAO.getUser();
    }
    public static boolean update (User user) {
        return UserDAO.update(user);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sách user theo Group">
    public static List<User> getUserByGroup(String groupID) {
        return UserDAO.getUserByGroup(groupID);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy thông tin User thông qua id">
    public static User getUserByID(String id) {
        return UserDAO.getUserByID(id);
    }
    //</editor-fold>
}
