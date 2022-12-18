package basicDAO.DAOmain;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class Edu {
    private Integer unumber;
    private String uaca;
    private String usc;

    public Edu() {
    }

    public Edu(Integer unumber, String uaca, String usc) {
        this.unumber = unumber;
        this.uaca = uaca;
        this.usc = usc;
    }

    public Integer getUnumber() {
        return unumber;
    }

    public void setUnumber(Integer unumber) {
        this.unumber = unumber;
    }

    public String getUaca() {
        return uaca;
    }

    public void setUaca(String uaca) {
        this.uaca = uaca;
    }

    public String getUsc() {
        return usc;
    }

    public void setUsc(String usc) {
        this.usc = usc;
    }

    @Override
    public String toString() {
        return "Edu{" +
                "unumber=" + unumber +
                ", uaca='" + uaca + '\'' +
                ", usc='" + usc + '\'' +
                '}';
    }
}
