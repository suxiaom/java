package basicDAO.DAOmain;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class Dept {
    private Integer dnumber;
    private String dname;
    private Integer dmgr;
    private String dpath;

    public Dept() {
    }

    public Dept(Integer dnumber, String dname, Integer dmgr, String dpath) {
        this.dnumber = dnumber;
        this.dname = dname;
        this.dmgr = dmgr;
        this.dpath = dpath;
    }

    public Integer getDnumber() {
        return dnumber;
    }

    public void setDnumber(Integer dnumber) {
        this.dnumber = dnumber;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getDmgr() {
        return dmgr;
    }

    public void setDmgr(Integer dmgr) {
        this.dmgr = dmgr;
    }

    public String getDpath() {
        return dpath;
    }

    public void setDpath(String dpath) {
        this.dpath = dpath;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dnumber=" + dnumber +
                ", dname='" + dname + '\'' +
                ", dmgr=" + dmgr +
                ", dpath='" + dpath + '\'' +
                '}';
    }
}
