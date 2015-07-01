/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.SignLabDAO;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import pojo.SignLab;
import ulti.DateUlti;

/**
 *
 * @author hang
 */
public class SignLabBO {
    //<editor-fold defaultstate="collapsed" desc="Lấy danh sách SignLab">

    public static List<SignLab> getSignLabs() {
        return SignLabDAO.getSignLabs();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy thông tin SignLab thông qua id">
    public static SignLab getSignLabByID(int id) {
        return SignLabDAO.getSignLabByID(id);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach SignLab cua 1 user">
    public static List<SignLab> getSignLabByUser(String user, String useDate, String status) {
        if (useDate.trim().equals("")) {
            if (status.equals("All")) {
                return SignLabDAO.getSignLabByUser(user);
            } else {
                return SignLabDAO.getSignLabByUser(user, status);
            }
        } else {
            if (status.equals("All")) {
                return SignLabDAO.getSignLabByUser(user, new Date(useDate));
            } else {
                return SignLabDAO.getSignLabByUser(user, new Date(useDate), status);
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach SignLab cho admin">
    public static List<SignLab> getSignLabByAdmin(String useDate, String timeTableId, String status)  {
        if (useDate.trim().equals("")) {
            if (status.equals("All")) {
                if (timeTableId.equals("All")) {
                    return SignLabDAO.getSignLabByAdmin();
                } else {
                    return SignLabDAO.getSignLabByAdminTimeTable(timeTableId);
                }
            } else {
                if (timeTableId.equals("All")) {
                    return SignLabDAO.getSignLabByAdmin(status);
                } else {
                    return SignLabDAO.getSignLabByAdminTimeTable(status, timeTableId);
                }
            }
        } else {
            if (status.equals("All")) {
                if (timeTableId.equals("All")) {
                    return SignLabDAO.getSignLabByAdmin(DateUlti.getDatePattern(useDate));
                } else {
                    return SignLabDAO.getSignLabByAdminTimeTable(DateUlti.getDatePattern(useDate), timeTableId);
                }
            } else {
                if (timeTableId.equals("All")) {
                    return SignLabDAO.getSignLabByAdmin(DateUlti.getDatePattern(useDate), status);
                } else {
                    return SignLabDAO.getSignLabByAdminTimeTable(DateUlti.getDatePattern(useDate), status, timeTableId);
                }
            }
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy thông tin SignLab tai 1 thoi diem">
    public static List<SignLab> getSignLabByTime(Date useDate, String timeTableID) {
        return SignLabDAO.getSignLabByTime(useDate, timeTableID);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Dang ki su dung Lab tai 1 thoi diem">
    public static String SignLab(SignLab signLab) {
        return SignLabDAO.SignLab(signLab);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Thay doi trang thai cua SignLab">
    public static String changeStatusSignLab(SignLab signLab) {
        return SignLabDAO.changeStatusSignLab(signLab);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Kiem tra 1 Lab co free hay khong">
    public static boolean checkFreeLab(String labID, String timeTableID, Date useDate) {
        return SignLabDAO.checkFreeLab(labID, timeTableID, useDate);
    }
    //</editor-fold>
}
