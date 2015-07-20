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
import pojo.Device;
import pojo.Permission;
import pojo.Report;
import pojo.User;
import ulti.HibernateUtil;

/**
 *
 * @author hang
 */
public class DeviceDAO {
    
      public static List<Device> getAll() {
        List<Device> reports = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Device";
            Query query = session.createQuery(hql);
            reports = query.list();
        } catch (HibernateException ex) {
           ex.printStackTrace();
           
        }
        return reports;
    }
     public static List<Device> getAll(String status) {
        List<Device> reports = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from Device d where d.status=:status";
            Query query = session.createQuery(hql);
            query.setString("status", status);
            reports = query.list();
        } catch (HibernateException ex) {
           ex.printStackTrace();
           
        }
        return reports;
    }
     
      public static boolean save(Device report) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(report);
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
            return false;
        } finally {
            transaction.commit();
            session.close();
        }
        return true;
    }
     //<editor-fold defaultstate="collapsed" desc="2. Lấy thông tin Device thông qua id">
    public static Device getDeviceByID(Integer id) {
        Device device = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            device = (Device) session.get(Device.class, id);
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return device;
    }
    //</editor-fold>
    
    
public static int delete(Integer id) {
       
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
           int sr = session.createQuery("delete from Device where id = :id").setInteger("id",id).executeUpdate();
          return sr;
           
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }          
        return 0;
       
    }

    public static boolean  update(Device user) {
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
