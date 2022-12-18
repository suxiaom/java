package basicDAO.DAO;

import basicDAO.DAOmain.Emp;
import basicDAO.DAOmain.Sc;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class ScDAO extends BasicDAO<Sc>{
    //在新增员工时，在sc表进行注册
    public int addEnum(Integer enumber){
        String sql = "INSERT INTO sc VALUES (?,null,null,NULL,NULL)";
        int update = super.update(sql, Sc.class, enumber);
        return update;
    }
    //因为dept表为固定的部门表所以设定员工的部门归属问题通过sc表设定
    public int addDept(Integer enumber,Integer dnumber){
        String sql = "UPDATE sc SET dnumber = ? WHERE enumber = ?";
        int update = super.update(sql, Sc.class, dnumber, enumber);
        return update;
    }
    public int addEdu(Integer enumber,Integer unumber){
        String sql = "UPDATE sc SET unumber = ? WHERE enumber = ?";
        int update = super.update(sql, Sc.class, unumber, enumber);
        return update;
    }
    public int addSal(Integer enumber, Integer snumber){
        String sql = "UPDATE sc SET snumber = ? WHERE enumber = ?";
        int update = super.update(sql, Sc.class, snumber, enumber);
        return update;
    }
    public int addExp(Integer enumber, Integer dnumber){
        String sql = "UPDATE sc SET qnumber = ? WHERE enumber = ?";
        int update = super.update(sql, Sc.class, dnumber, enumber);
        return update;
    }
    //返回员工职位
    public Integer getDnumber(Integer enumber){
        String sql = "SELECT dnumber FROM sc WHERE enumber = ?";
        Object o = super.queryScalar(sql, Sc.class, enumber);
        return (o == null ? 0:(Integer) o);
    }
    //删除员工信息
    public Integer deletesc(Integer enumber){
        String sql = "DELETE FROM sc WHERE enumber = ?";
        int update = super.update(sql, Sc.class, enumber);
        return update;
    }
}
