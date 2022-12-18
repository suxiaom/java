package basicDAO.DAOmain;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class Exp {
    private Integer qnumber;
    private String qdata;
    private String qexper;

    public Exp() {
    }

    public Exp(Integer qnumber, String qdata, String qexper) {
        this.qnumber = qnumber;
        this.qdata = qdata;
        this.qexper = qexper;
    }

    public Integer getQnumber() {
        return qnumber;
    }

    public void setQnumber(Integer qnumber) {
        this.qnumber = qnumber;
    }

    public String getQdata() {
        return qdata;
    }

    public void setQdata(String qdata) {
        this.qdata = qdata;
    }

    public String getQexper() {
        return qexper;
    }

    public void setQexper(String qexper) {
        this.qexper = qexper;
    }

    @Override
    public String toString() {
        return "Exp{" +
                "qnumber=" + qnumber +
                ", qdata='" + qdata + '\'' +
                ", qexper='" + qexper + '\'' +
                '}';
    }
}
