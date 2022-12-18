package basicDAO.DAOmain;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class Sc {
    private Integer enumber;
    private Integer qnumber;
    private Integer dnumber;
    private Integer unumber;
    private Integer snumber;

    public Sc() {
    }

    public Sc(Integer enumber, Integer qnumber, Integer dnumber, Integer unumber, Integer snumber) {
        this.enumber = enumber;
        this.qnumber = qnumber;
        this.dnumber = dnumber;
        this.unumber = unumber;
        this.snumber = snumber;
    }

    public Integer getEnumber() {
        return enumber;
    }

    public void setEnumber(Integer enumber) {
        this.enumber = enumber;
    }

    public Integer getQnumber() {
        return qnumber;
    }

    public void setQnumber(Integer qnumber) {
        this.qnumber = qnumber;
    }

    public Integer getDnumber() {
        return dnumber;
    }

    public void setDnumber(Integer dnumber) {
        this.dnumber = dnumber;
    }

    public Integer getUnumber() {
        return unumber;
    }

    public void setUnumber(Integer unumber) {
        this.unumber = unumber;
    }

    public Integer getSnumber() {
        return snumber;
    }

    public void setSnumber(Integer snumber) {
        this.snumber = snumber;
    }
}
