package basicDAO.DAOmain;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 * 此类为数据库中emp表类
 */
public class Emp {
    private Integer enumber;
    private String ename;
    private String esex;
    private String eid;
    private Integer emgr;
    private String etel;
    private String epos;
    private String pwd;

    public Emp() {
    }

    public Emp(Integer enumber, String ename, String esex, String eid, Integer emgr, String etel, String epos, String pwd) {
        this.enumber = enumber;
        this.ename = ename;
        this.esex = esex;
        this.eid = eid;
        this.emgr = emgr;
        this.etel = etel;
        this.epos = epos;
        this.pwd = pwd;
    }

    public Integer getEnumber() {
        return enumber;
    }

    public void setEnumber(Integer enumber) {
        this.enumber = enumber;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public Integer getEmgr() {
        return emgr;
    }

    public void setEmgr(Integer emgr) {
        this.emgr = emgr;
    }

    public String getEtel() {
        return etel;
    }

    public void setEtel(String etel) {
        this.etel = etel;
    }

    public String getEpos() {
        return epos;
    }

    public void setEpos(String epos) {
        this.epos = epos;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "enumber=" + enumber +
                ", ename='" + ename + '\'' +
                ", esex='" + esex + '\'' +
                ", eid='" + eid + '\'' +
                ", emgr=" + emgr +
                ", etel='" + etel + '\'' +
                ", epos='" + epos + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
