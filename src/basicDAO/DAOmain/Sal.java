package basicDAO.DAOmain;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class Sal {
    private Integer snumber;
    private Double scom;
    private Double sbase;

    public Sal() {
    }

    public Sal(Integer snumber, Double scom, Double sbase) {
        this.snumber = snumber;
        this.scom = scom;
        this.sbase = sbase;
    }

    public Integer getSnumber() {
        return snumber;
    }

    public void setSnumber(Integer snumber) {
        this.snumber = snumber;
    }

    public Double getScom() {
        return scom;
    }

    public void setScom(Double scom) {
        this.scom = scom;
    }

    public Double getSbase() {
        return sbase;
    }

    public void setSbase(Double sbase) {
        this.sbase = sbase;
    }

    @Override
    public String toString() {
        return "Sal{" +
                "snumber=" + snumber +
                ", scom=" + scom +
                ", sbase=" + sbase +
                '}';
    }
}
