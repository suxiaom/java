package manage;

import basicDAO.DAO.*;
import basicDAO.DAOmain.Emp;
import com.sun.org.apache.xpath.internal.operations.Bool;
import permissiontable.DeptTable;
import permissiontable.EduUsc;
import permissiontable.IntLong;
import permissiontable.PermissionMessage;

import java.util.Iterator;
import java.util.List;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class Clientserver {
    private static String username = null;
    private static Integer Enumber = null;
    private static String permisssion = null;
    private static Integer position = null;


    /**
     * @param enumber 用户编号应为数字
     * @param pwd     用户密码
     * 此方法为效验用户名密码是否正确，并将登录成功后的用户名与员工编号写入与username和enumber中
     */
    public static boolean signIn(String enumber, String pwd) {
        boolean sign = false;
        EmpDAO empDAO = new EmpDAO();
        ScDAO scDAO = new ScDAO();
        if (CheckString.checkInt(enumber) &&
                CheckString.checkLong(enumber, IntLong.Enumber_Max_long, IntLong.Enumber_Min_long)) {
            Emp s = empDAO.permissionsign(enumber, pwd);
            if (s != null) {
                username = s.getEname();
                permisssion = s.getEpos();
                Enumber = s.getEnumber();
                position = scDAO.getDnumber(Integer.parseInt(enumber));
                if (position == 0){
                    System.out.println("未设置部门！");
                }
                sign = true;
                System.out.println("登录成功，欢迎" + username);
            } else {
                System.out.println("登录失败，请重新登录");
            }
        } else {
            System.out.println("输入的账号格式错误！");
        }
        return sign;
    }

    //新增员工
    public static boolean addStaff(String name, String sex, String eid, String emgr, String etel, String epos, String pwd) {
        int index = 0;
        EmpDAO empDAO = new EmpDAO();
        ScDAO scDAO = new ScDAO();
        if (!checkPer()) {
            System.out.println("操作权限不足，操作失败");
        } else if (empDAO.checkEid(eid)) {
            System.out.println("存在身份证相同员工，操作失败");
        } else if (CheckString.checkInt(emgr) && CheckString.checkInt(etel) &&
                CheckString.checkLong(eid, IntLong.Eid__long) &&
                CheckString.checkLong(etel, IntLong.Etel__long)) {
            index = empDAO.addStaff(name, sex, eid, Integer.parseInt(emgr), etel, epos, pwd);
            Integer enmuber = empDAO.get_enmuber(eid);
            int i = scDAO.addEnum(enmuber);
            System.out.println(i > 0 ? "SC表注册成功" : "SC表注册失败");
            index = i > 0 && index > 0? 1 : 0;
        }
        return index > 0 ? true : false;
    }

    //修改emp表的员工信息，先查员工编号有无该员工
    public static void updateemp(String name, String esex, String eid, String emgr, String etel, String epos, String pwd, String enumber) {
        EmpDAO empDAO = new EmpDAO();
        if (CheckString.checkInt(eid) && CheckString.checkInt(emgr) && CheckString.checkInt(enumber) &&
                CheckString.checkLong(eid, IntLong.Eid__long) &&
                CheckString.checkLong(etel, IntLong.Etel__long)) {
            Integer enu = Integer.parseInt(enumber);
            if (empDAO.checkSign(enu) != null) {
                if (empDAO.checkSign(enu).equals(username)) {//进行职位检查，防止非本人私自修改信息
                    int update = empDAO.update(name, esex, eid, Integer.parseInt(emgr), etel, epos, pwd, enu);
                    System.out.println(update > 0 ? "修改成功" : "修改失败");
                } else {
                    System.out.println("非本人进行修改！");
                }
            } else {
                System.out.println("未能找到该员工编号的员工！");
            }
        }
    }
    //对dept进行修改，因为dept表为固定的部门表所以设定员工的部门归属问题通过sc表设定
    public static void setdept( String Dnumber){
        ScDAO scDAO = new ScDAO();
        Integer getdnumber = DeptTable.getdnumber(Dnumber);
        int i = scDAO.addDept(Enumber, getdnumber);
        System.out.println(i > 0 ? "添加成功" : "添加失败");
    }
    //修改学历表
    /**
     * 因为学历信息具有重复度，所以一条学历信息可以重复利用于多人
     * 故添加学历信息前先进行查询有无重复学历信息，如果有直接将其加入sc表，如果没有再进行添加
     * @param uaca 学历
     * @param usc 毕业院校
     */
    public static void addEdu(String uaca,String usc){
        EduDAO eduDAO = new EduDAO();
        ScDAO scDAO = new ScDAO();
        Integer unumber = null;

        //先检查学历是否正确
        if (!(EduUsc.findTable(uaca))){
            System.out.println("学历信息填写有误！");
        }
        else {
            if ((unumber = eduDAO.getUnumber(uaca, usc)) != null) {//查看是否存在可复用信息
                //存在可复用信息直接将unumber写入相应enumber中
                int i = scDAO.addEdu(Enumber, unumber);
                System.out.println(i > 0 ? "添加成功" : "添加失败");
            }
            else {//不存在可复用的信息，则创建并返回unumber
                int i = eduDAO.addEdu(uaca, usc);
                int i1 = scDAO.addEdu(Enumber, eduDAO.getUnumber(uaca, usc));
                i = i + i1;
                System.out.println(i == 2 ? "添加成功" : "添加失败");
            }
        }
    }
    //新增薪资表，先对数值进行检查
    public static void addSal(String scom,String sbace){
        SalDAO salDAO = new SalDAO();
        ScDAO scDAO = new ScDAO();
        if(!(CheckString.checkInt(scom)&& CheckString.checkInt(sbace))){
            System.out.println("输入的数字有误！");
        }
        else{
            int i = salDAO.addSal(Double.parseDouble(scom), Double.parseDouble(sbace));
            int i1 = scDAO.addSal(Enumber, salDAO.getSnumber(Double.parseDouble(scom), Double.parseDouble(sbace)));
            i += i1;
            System.out.println( i == 2 ? "添加成功" : "添加失败");
        }
    }
    //修改资历表
        public static void addExp(String qdata,String qexper){
            ExpDAO expDAO = new ExpDAO();
            ScDAO scDAO = new ScDAO();
        if(!(CheckString.CheckData(qdata))){
            System.out.println("输入的日期有误！");
        }
        else{
            int i = expDAO.addExp(qdata, qexper);
            int i1 = scDAO.addExp(Enumber,expDAO.getQnumber(qdata,qexper));
            i += i1;
            System.out.println( i == 2 ? "添加成功" : "添加失败");
        }
    }
    //查询员工信息
    public static Boolean selectemp(String enumber){
        EmpDAO empDAO = new EmpDAO();
        Boolean tof = false;
        if (CheckString.checkInt(enumber)) {
            if (position != 0) {
                if (position <= 3) {
                    Emp emp = empDAO.selectEmp(Integer.parseInt(enumber));
                    if (emp != null) {
                        System.out.println("员工编号： " + emp.getEnumber() + " 员工姓名： " + emp.getEname()
                                + " 员工性别： " + emp.getEsex() + " 员工上级编号： " + emp.getEmgr()
                                + " 员工联系方式： " + emp.getEtel() + " 员工职位： " + emp.getEpos());
                        tof = true;
                    }
                    else {
                        System.out.println("未查询到该员工");
                    }
                } else {
                    System.out.println("权限等级不够！");
                }
            } else {
                System.out.println("未设置部门！");
            }
        }
        else {
            System.out.println("输入的员工编号错误！");
        }
        return tof;
    }
    public static void selectallEmp(){
        EmpDAO empDAO = new EmpDAO();
        if (position != 0) {
            if (position <= 3) {
                List<Emp> emps = empDAO.selectAllemp();
                Iterator it = emps.iterator();
                while (it.hasNext()){
                    Emp emp = (Emp) it.next();
                    System.out.println("员工编号： " + emp.getEnumber() + " 员工姓名： " + emp.getEname()
                            + " 员工性别： " + emp.getEsex() + " 员工上级编号： " + emp.getEmgr()
                            + " 员工联系方式： " + emp.getEtel() + " 员工职位： " + emp.getEpos());
                }
            } else {
                System.out.println("权限等级不够！");
            }
        }
        else {
            System.out.println("未设置部门！");
        }
    }
    //删除员工
    public static void deleteStaff(String enumber){
        EmpDAO empDAO = new EmpDAO();
        ScDAO scDAO = new ScDAO();
        Integer integer = empDAO.deleteEmp(Integer.parseInt(enumber));
        Integer deletesc = scDAO.deletesc(Integer.parseInt(enumber));
        System.out.println(integer >= 1 ? "emp表删除成功": "emp表删除失败");
        System.out.println(deletesc >= 1 ? "sc表删除成功": "sc表删除失败");
    }

    //对新增员工操作进行职位检查，即此操作只能由人事部副经理或总经理操作进行
    public static boolean checkPer() {
        if (permisssion.equals(PermissionMessage.One_level)
                || permisssion.equals(PermissionMessage.Two_level)) {
            return true;
        } else
            return false;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPermisssion() {
        return permisssion;
    }
}
