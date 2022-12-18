package basicDAO.DAO;

import basicDAO.DAOmain.Emp;
import org.omg.CORBA.INTERNAL;

import java.util.List;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class EmpDAO extends BasicDAO<Emp>{
    //返回当前员工表
    public List<Emp> get_allemp(){
        String sql = "Select * from emp";
        List<Emp> emps = super.queryMulti(sql, Emp.class);
        return emps;
    }
    //查看是否存在该用户
    public String checkSign(Integer enumber){
        String sql = "SELECT ename FROM emp WHERE enumber = ?";
        String o =(String) super.queryScalar(sql, Emp.class,enumber);
        return o;
    }
    //检查数据库中是否有该用户,并返回员工编号姓名和权限
    public Emp permissionsign(String unumber,String pwd){
        String sql = "SELECT enumber,ename,epos FROM emp WHERE enumber = ? AND pwd = MD5(?)";
        Emp emp = super.querySingle(sql, Emp.class, unumber, pwd);
        return emp;
    }
    //增加公司职员，其中职位只能由更高职位者任命
    public int addStaff(String name,String esex,String eid,Integer emgr,String etel,String epos,String pwd){
        String sql = "INSERT INTO emp VALUES(null,?,?,?,?,?,?,MD5(?))";
        int update = super.update(sql, Emp.class, name, esex, eid, emgr, etel, epos, pwd);
        return update;
    }
    //修改公司员工资料
    public int update(String name,String esex,String eid,Integer emgr,String etel,String epos,String pwd,Integer enumber){
        String sql = "UPDATE emp SET ename = ? ,esex = ?,eid = ?,emgr = ? ,etel = ?,epos = ?,pwd = MD5(?) WHERE enumber = ?";
        int update = super.update(sql, Emp.class, name, esex, eid, emgr, etel, epos, pwd, enumber);
        return update;
    }
    //返回员工号方法
    public Integer get_enmuber(String eid){
        String sql = "SELECT enumber FROM emp WHERE eid = ?";
        Object o = super.queryScalar(sql, Emp.class, eid);
        return (Integer) o;
    }
    /**
     * 检查身份证号是否重复
     * @param eid
     * @return 返回值为true时，则存在重复eid 返回值为false时不存在重复eid
     */
    public boolean checkEid(String eid){
        String sql = "SELECT enumber FROM emp WHERE eid = ?";
        Object o = super.queryScalar(sql, Emp.class, eid);
        if (o == null){
            return false;
        }
        else
            return true;
    }
    //查询员工信息
    public Emp selectEmp(Integer enumber){
        String sql = "SELECT enumber,ename,esex,emgr,etel,epos FROM emp WHERE enumber = ?";
        Emp emp = super.querySingle(sql, Emp.class, enumber);
        return emp;
    }

    //删除员工信息
    public Integer deleteEmp(Integer enumber){
        String sql = "DELETE FROM emp WHERE enumber = ?";
        int update = super.update(sql, Emp.class, enumber);
        return update;
    }
    public List<Emp> selectAllemp(){
        String sql = "SELECT enumber,ename,esex,emgr,etel,epos FROM emp";
        List<Emp> emps = super.queryMulti(sql, Emp.class);
        return emps;
    }
}
