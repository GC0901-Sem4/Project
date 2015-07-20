/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Permission;
import pojo.Report;
import ulti.HibernateUtil;

/**
 *
 * @author hang
 */
public class PermissionDAO {
      public static boolean save(Permission report) {
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
}
