/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Permission;
import pojo.SignLab;
import pojo.User;
import ulti.HibernateUtil;

/**
 *
 * @author hang
 */
// Chi de demo cach code
public class UserDAO {
    //<editor-fold defaultstate="collapsed" desc="Lấy danh sách user">
 public static boolean save(User report) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(report);
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
            return false;
        } finally {
            transaction.commit();
            session.close();
        }
        return true;
    }
    public static List<User> getUser() {
        List<User> User = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from User";
            Query query = session.createQuery(hql);
            User = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return User;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sách user theo Group">
    public static List<User> getUserByGroup(String groupID) {
        List<User> User = null;
        List<Permission> permissions = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Permission where GroupID = :groupID";
            Query query = session.createQuery(hql);
            query.setString(groupID, groupID);
            permissions = query.list();
            for (Permission permission : permissions) {
                User.add(permission.getUser());
            }
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return User;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy thông tin User thông qua id">
    public static User getUserByID(String id) {
        User User = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            User = (User) session.get(User.class, id);
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return User;
    }
    //</editor-fold>
    
    
    public static boolean  update(User user) {
        Session session =  null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(user);
            return true;
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
            return false;
        } finally {
            transaction.commit();
            session.close();
        }
    }
}
