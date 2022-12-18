package basicDAO.DAO;

import basicDAO.DAOmain.Edu;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class EduDAO extends BasicDAO<Edu>{
    //新增教育信息
    public int addEdu(String uaca, String usc){
        String sql = "INSERT INTO edu VALUES(null,?,?)";
        int update = super.update(sql, Edu.class, uaca, usc);
        return update;
    }
    //获取unumber以添加至sc表
    public Integer getUnumber(String uaca,String usc){
        String sql = "SELECT unumber FROM edu WHERE uaca = ? AND usc = ?";
        Object o = super.queryScalar(sql, Edu.class, uaca, usc);
        Integer unumber = (Integer) o;
        return unumber;
    }
}
