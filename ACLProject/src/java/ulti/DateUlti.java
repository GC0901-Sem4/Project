/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ulti;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author hang
 */
@ManagedBean
@RequestScoped
public class DateUlti {

    public static String getNow(String dateFormat) {
        DateFormat format = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        return format.format(date);
    }

    public static Date getNow() {
        Date date = new Date();
        return date;
    }

    public static String getFormatDateQuery(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    public static Date getDatePattern(String date)  {
             DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return df.parse(date);
//            Calendar cal = Calendar.getInstance();
//            cal.setTime( df.parse(date));
//            cal.set(Calendar.HOUR,0);
//            cal.set(Calendar.MINUTE, 0);
//            cal.set(Calendar.SECOND, 0);
//            return cal.getTime();
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
            
           
       
    }

    public static String formatDate(Date date, String dateFormat) {
        DateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(date);
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    public static boolean futureDate(Date date) {
        Date now = new Date();
        return date.after(now);
    }
    public static Date getDate(String date) {
        return new Date(date);
    }
}
