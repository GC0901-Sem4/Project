package pojo;
// Generated Aug 18, 2012 5:14:49 PM by Hibernate Tools 3.2.1.GA

import java.util.Date;

/**
 * SignLab generated by hbm2java
 */
public class SignLab implements java.io.Serializable {

    private int id;
    private User user;
    private Lab lab;
    private TimeTable timeTable;
    private Date createDate;
    private Date useDate;
    private String content;
    private String status;
    public String getGrade() {
            if (this.status.equalsIgnoreCase("request")) {
                return "gradeA";
            } else if (this.status.equalsIgnoreCase("deny")) {
                return "gradeX";
            } else {
                return  "gradeD";
            }
    }
    
    public SignLab() {
    }

    public SignLab(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public SignLab(int id, User user, Lab lab, TimeTable timeTable, Date createDate, Date useDate, String content, String status) {
        this.id = id;
        this.user = user;
        this.lab = lab;
        this.timeTable = timeTable;
        this.createDate = createDate;
        this.useDate = useDate;
        this.content = content;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lab getLab() {
        return this.lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public TimeTable getTimeTable() {
        return this.timeTable;
    }

    public void setTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUseDate() {
        return this.useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Boolean getSignAble() {
         Date now = new Date();
         return this.useDate.after(now);
    }
}
