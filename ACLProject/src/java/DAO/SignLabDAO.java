/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.SignLab;
import ulti.DateUlti;
import ulti.HibernateUtil;

/**
 *
 * @author hang
 */
public class SignLabDAO {
    //<editor-fold defaultstate="collapsed" desc="Lấy danh sách SignLab">

    public static List<SignLab> getSignLabs() {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab";
            Query query = session.createQuery(hql);
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLabs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy thông tin SignLab thông qua id">
    public static SignLab getSignLabByID(int id) {
        SignLab SignLab = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            SignLab = (SignLab) session.get(SignLab.class, id);
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLab;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach SignLab cho admin">
    public static List<SignLab> getSignLabByAdmin() {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab s order by s.createDate desc";
            Query query = session.createQuery(hql);
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLabs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach SignLab thong qua TimeTable cho admin">
    public static List<SignLab> getSignLabByAdminTimeTable(String timeTableId) {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab s where s.timeTable.id = :timeTableId order by s.createDate desc";
            Query query = session.createQuery(hql);
            query.setString("timeTableId", timeTableId);
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLabs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach SignLab thong qua status cho admin">
    public static List<SignLab> getSignLabByAdmin(String status) {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab s where s.status = :status order by s.createDate desc";
            Query query = session.createQuery(hql);
            query.setString("status", status);
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLabs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach SignLab thong qua TimeTable va Status cho admin">
    public static List<SignLab> getSignLabByAdminTimeTable(String status, String timeTableId) {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab s where s.timeTable.id = :timeTableId"
                    + " and s.status = :status order by s.createDate desc";
            Query query = session.createQuery(hql);
            query.setString("status", status);
            query.setString("timeTableId", timeTableId);
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLabs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach SignLab trong 1 ngay cho admin">
    public static List<SignLab> getSignLabByAdmin(Date useDate) {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab s where s.useDate >= :from  and  s.useDate < :to order by s.createDate desc";
            Query query = session.createQuery(hql);
           query.setDate("from", useDate);
           query.setDate("to", DateUlti.addDays(useDate, 1));
           
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLabs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach SignLab trong 1 ngay va TimeTable cho admin">
    public static List<SignLab> getSignLabByAdminTimeTable(Date useDate, String timeTableId) {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab s where s.useDate >= :from and s.useDate < :to "
                    + " and s.timeTable.id = :timeTableId order by s.createDate desc";
            Query query = session.createQuery(hql);
           query.setDate("from", useDate);
           query.setDate("to", DateUlti.addDays(useDate, 1));
            query.setString("timeTableId", timeTableId);
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLabs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach SignLab trong 1 ngay thong qua status cho admin">
    public static List<SignLab> getSignLabByAdmin(Date useDate, String status) {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab s where s.useDate >= :from and s.useDate < :to"
                    + " and s.status = :status order by s.createDate desc";
            Query query = session.createQuery(hql);
                       query.setDate("from", useDate);
           query.setDate("to", DateUlti.addDays(useDate, 1));
            query.setString("status", status);
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLabs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach SignLab trong 1 ngay thong qua Status va TimeTable cho admin">
    public static List<SignLab> getSignLabByAdminTimeTable(Date useDate, String status, String timeTableId) {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab s where s.useDate >= :from and s.useDate < :to"
                    + " and s.status = :status and s.timeTable.id = :timeTableId"
                    + " order by s.createDate desc";
            Query query = session.createQuery(hql);
            query.setDate("from", useDate);
            query.setDate("to", DateUlti.addDays(useDate, 1));
            query.setString("status", status);
            query.setString("timeTableId", timeTableId);
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLabs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach SignLab cua 1 user">
    public static List<SignLab> getSignLabByUser(String user) {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab s where s.user.id = :user order by s.createDate desc";
            Query query = session.createQuery(hql);
            query.setString("user", user);
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLabs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach SignLab thong qua status cua 1 user">
    public static List<SignLab> getSignLabByUser(String user, String status) {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab s where s.user.id = :user and s.status = :status order by s.createDate desc";
            Query query = session.createQuery(hql);
            query.setString("user", user);
            query.setString("status", status);
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLabs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach SignLab trong 1 ngay cua 1 user">
    public static List<SignLab> getSignLabByUser(String user, Date useDate) {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab s where s.user.id = :user and s.useDate >= :from and s.useDate < :to order by s.createDate desc";
            Query query = session.createQuery(hql);
            query.setString("user", user);
                       query.setDate("from", useDate);
           query.setDate("to", DateUlti.addDays(useDate, 1));
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLabs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach SignLab trong 1 ngay thong qua status cua 1 user">
    public static List<SignLab> getSignLabByUser(String user, Date useDate, String status) {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab s where s.user.id = :user and s.useDate >= :from and s.useDate < :to and s.status = :status order by s.createDate desc";
            Query query = session.createQuery(hql);
            query.setString("user", user);
                       query.setDate("from", useDate);
           query.setDate("to", DateUlti.addDays(useDate, 1));
            query.setString("status", status);
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLabs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy thông tin SignLab tai 1 thoi diem">
    public static List<SignLab> getSignLabByTime(Date useDate, String timeTableID) {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab s where s.useDate >= :from and s.useDate < :to and s.timeTable.id = :timeTableID";
            Query query = session.createQuery(hql);
                       query.setDate("from", useDate);
           query.setDate("to", DateUlti.addDays(useDate, 1));
            query.setString("timeTableID", timeTableID);
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        return SignLabs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Dang ki su dung Lab tai 1 thoi diem">
    public static String SignLab(SignLab signLab) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(signLab);
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
            return "fail";
        } finally {
            transaction.commit();
            session.close();
        }
        return "success";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Thay doi trang thai cua SignLab">
    public static String changeStatusSignLab(SignLab signLab) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(signLab);
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
            return "fail";
        } finally {
            transaction.commit();
            session.close();
        }
        return "success";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Kiem tra 1 Lab co free hay khong">
    public static boolean checkFreeLab(String labID, String timeTableID, Date useDate) {
        List<SignLab> SignLabs = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from SignLab s"
                    + " where s.lab.id = :labID and s.timeTable.id = :timeTableID"
                    + " and s.useDate = :useDate and s.status = 'Approve'";
            Query query = session.createQuery(hql);
            query.setString("labID", labID);
            query.setString("timeTableID", timeTableID);
            query.setDate("useDate", useDate);
            SignLabs = query.list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        }
        if (SignLabs.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
    //</editor-fold>
}
