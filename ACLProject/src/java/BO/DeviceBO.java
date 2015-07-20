/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.DeviceDAO;
import java.util.List;
import pojo.Device;

/**
 *
 * @author hang
 */
public class DeviceBO {
    
    public static List<Device> getAll() {
        return DeviceDAO.getAll("Activate");
    }
     //<editor-fold defaultstate="collapsed" desc="2. Lấy thông tin Device thông qua id">
    public static Device getDeviceByID(Integer id) {
        return DeviceDAO.getDeviceByID(id);
    }
    //</editor-fold>
}
