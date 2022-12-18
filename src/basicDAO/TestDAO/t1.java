package basicDAO.TestDAO;

import basicDAO.DAO.EmpDAO;
import basicDAO.DAOmain.Emp;
import manage.CheckString;
import manage.Clientserver;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 * 测试类
 */
public class t1 {
    EmpDAO empDAO = new EmpDAO();
//    public static void main(String[] args) {
//        EmpDAO empDAO = new EmpDAO();
//        List<Emp> allemp = empDAO.get_allemp();
//        Iterator it = allemp.iterator();
//        while (it.hasNext()) {
//            Emp next = (Emp) it.next();
//            System.out.println(next);
//    }
//    public void EmpTest(){
//        EmpDAO empDAO = new EmpDAO();
//        List<Emp> allemp = empDAO.get_allemp();
//        Iterator it = allemp.iterator();
//        while (it.hasNext()) {
//            Emp next = (Emp) it.next();
//            System.out.println(next);
//        }
    @Test//测试登录功能
    public void checksig(){
        String s = empDAO.checkSign(9);
        if (s == null){
            System.out.println("无此用户");
        }else {
            System.out.println("欢迎" + s + "登录");
        }
    }
    @Test//测试权限登录
    public void newcheck(){
        Emp text = empDAO.permissionsign("5", "123456");
        System.out.println(text);
    }
    //测试新增员工
    @Test
    public void newworker(){
        int i = empDAO.addStaff("张三", "男", "123456789123456778", 2, "12345678912", "员工", "123456");
        System.out.println(i > 0 ? "已添加入库" : "未影响到数据库");
    }
    //测试检查身份证号是否重复
    @Test
    public void checkeid(){
        boolean b = empDAO.checkEid("123456789123456113");
        System.out.println(b);
    }
    //测试修改员工资料,直接通过封装的方法测试
    //需要先进行登录为username传值
    @Test
    public void update(){
        boolean b = Clientserver.signIn("5", "123456");
        Clientserver.updateemp("麦汉荣","男","123456789123456789","1","12345678912","狗","123456","1");
    }
    //测试新增员工能模块
    @Test
    public void addstuff(){
        boolean b1 = Clientserver.signIn("1", "123456");
        boolean b = Clientserver.addStaff("李四", "男", "123456789123456779", "3", "12345678912", "员工", "123456");
        System.out.println(b);
    }
    //测试修改dept表
    @Test
    public  void  setdept() {
        boolean b1 = Clientserver.signIn("4", "123456");
        Clientserver.setdept("部门管理");
    }
    //测试修改edu表
    @Test
    public void  addedu(){
        boolean b1 = Clientserver.signIn("4", "123456");
        Clientserver.addEdu("本科生","福州工商学院");
    }
    //测试修改sal表
    @Test
    public void addSal(){
        boolean b = Clientserver.signIn("4", "123456");
        Clientserver.addSal("100","3000");
    }
    //测试日期检查
    @Test
    public void CheckString(){
        String data = "2000-01-01";
        boolean b = CheckString.CheckData(data);
        System.out.println(b);
    }
    //测试添加exp表
    @Test
    public void addexp(){
        boolean b = Clientserver.signIn("4", "123456");
        String data = "2000-01-01";
        Clientserver.addExp(data,"表现良好");
    }
}
