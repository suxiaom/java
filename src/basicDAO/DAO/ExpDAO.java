package basicDAO.DAO;

import basicDAO.DAOmain.Exp;
import basicDAO.DAOmain.Sal;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class ExpDAO extends BasicDAO<Exp>{
    public int addExp(String qdata, String qexper){
        String sql = "INSERT INTO exp VALUES(null,?,?)";
        int update = super.update(sql, Exp.class, qdata, qexper);
        return update;
    }
    //获取qnumber以添加至sc表
    public Integer getQnumber(String qdata, String qexper){
        String sql = "SELECT qnumber FROM exp WHERE qdata = ? AND qexper = ?";
        Object o = super.queryScalar(sql, Exp.class, qdata, qexper);
        Integer qnumber = (Integer) o;
        return qnumber;
    }
}
