package pojo;
// Generated Aug 18, 2012 5:14:49 PM by Hibernate Tools 3.2.1.GA

/**
 * Technical generated by hbm2java
 */
public class Technical implements java.io.Serializable {

    private int id;
    private Lab lab;
    private User user;
    private TimeTable timeTable;

    public Technical() {
    }

    public Technical(int id) {
        this.id = id;
    }

    public Technical(int id, Lab lab, User user, TimeTable timeTable) {
        this.id = id;
        this.lab = lab;
        this.user = user;
        this.timeTable = timeTable;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lab getLab() {
        return this.lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TimeTable getTimeTable() {
        return this.timeTable;
    }

    public void setTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }
}
