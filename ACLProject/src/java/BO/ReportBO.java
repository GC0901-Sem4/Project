/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.ReportDAO;
import java.text.ParseException;
import java.util.List;
import pojo.Report;
import ulti.DateUlti;

/**
 *
 * @author hang
 */
public class ReportBO {
    //<editor-fold defaultstate="collapsed" desc="Lấy thông tin Report thông qua id">

    public static Report getReportByID(int id) {
        return ReportDAO.getReportByID(id);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Gui 1 report ve Device">
    public static String doReport(Report report) {
        return ReportDAO.doReport(report);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach Report cho Admin">
    public static List<Report> getReportByAdmin(String status, String startDate, String endDate, String labID) throws ParseException {
        if (startDate.trim().equals("") || endDate.trim().equals("")) {
            if (status.equals("All")) {
                if (labID.trim().equals("")) {
                    return ReportDAO.getReportByAdmin();
                } else {
                    return ReportDAO.getReportByAdmin(labID);
                }
            } else {
                if (labID.trim().equals("")) {
                    return ReportDAO.getReportByAdminStatus(status);
                } else {
                    return ReportDAO.getReportByAdminStatus(status, labID);
                }
            }
        } else {
            if (status.equals("All")) {
                if (labID.trim().equals("")) {
                    return ReportDAO.getReportByAdmin(DateUlti.getDatePattern(startDate), DateUlti.getDatePattern(endDate));
                } else {
                    return ReportDAO.getReportByAdmin(DateUlti.getDatePattern(startDate), DateUlti.getDatePattern(endDate), labID);
                }
            } else {
                if (labID.trim().equals("")) {
                    return ReportDAO.getReportByAdminStatus(status, DateUlti.getDatePattern(startDate), DateUlti.getDatePattern(endDate));
                } else {
                    return ReportDAO.getReportByAdminStatus(status, DateUlti.getDatePattern(startDate), DateUlti.getDatePattern(endDate), labID);
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach Report cua 1 user">
    public static List<Report> getReportByUser(String user) {
        return ReportDAO.getReportByUser(user);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach Report cua 1 Technican">
    public static List<Report> getReportByTechnican() {
        return ReportDAO.getReportByTechnican();

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lấy danh sach Report can xu ly cua 1 technican">
    public static List<Report> getWorkByTechnican(String technicanID) {
        return ReportDAO.getWorkByTechnican(technicanID);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Thay doi trang thai cua Report">
    public static String changeStatusReport(Report report) {
        return ReportDAO.changeStatusReport(report);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Kiem tra 1 Report da hoan thanh chua">
    public static boolean checkDoneReport(int reportID) {
        return ReportDAO.checkDoneReport(reportID);
    }
    //</editor-fold>

    public static int delete(String id) {
        return ReportDAO.delete(id);
    }
    

}
