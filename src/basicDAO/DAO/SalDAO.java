package basicDAO.DAO;

import basicDAO.DAOmain.Edu;
import basicDAO.DAOmain.Sal;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class SalDAO extends BasicDAO<Sal>{
    //新增薪资信息
    public int addSal(Double scom, Double sbase){
        String sql = "INSERT INTO sal VALUES(null,?,?)";
        int update = super.update(sql, Sal.class, scom, sbase);
        return update;
    }
    //获取snumber以添加至sc表
    public Integer getSnumber(Double scom,Double sbase){
        String sql = "SELECT snumber FROM sal WHERE scom = ? AND sbase = ?";
        Object o = super.queryScalar(sql, Sal.class, scom, sbase);
        Integer unumber = (Integer) o;
        return unumber;
    }
}
