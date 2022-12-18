package view;

import manage.CheckString;
import manage.Clientserver;

import java.util.Iterator;
import java.util.Scanner;

import static permissiontable.PermissionMessage.One_level;
import static permissiontable.PermissionMessage.Two_level;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class Mview {
    static Scanner scanner = new Scanner(System.in);
    private static boolean Menu_Islive = true;
    private static boolean Message_isLive = true;


    public static void main(String[] args) {
        while (Menu_Islive) {
            System.out.println("============企业人事管理系统============");
            System.out.println("1.登录");
            System.out.println("2.退出");
            System.out.print("请输入：");
            String i = scanner.next();
            if ((CheckString.checkInt(i))) {
                switch (i) {
                    case "1":
                        System.out.print("请输入员工编号：");
                        String unumber = scanner.next();
                        System.out.print("请输入密码：");
                        String password = scanner.next();
                        if (Clientserver.signIn(unumber, password)) {
                            new Mview().one_levelMenu();
                        }
                        break;
                    case "2":
                        System.out.println("正在退出");
                        Menu_Islive = false;
                        break;
                }
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
        System.exit(0);
    }
    public void one_levelMenu() {
        while (Menu_Islive) {
            System.out.println("欢迎" + Clientserver.getUsername() + "您的权限等级为：" + Clientserver.getPermisssion());
            System.out.println("============企业人事管理系统============");
            System.out.println("1.增加员工");
            System.out.println("2.员工信息调整");
            System.out.println("3.员工离职");
            System.out.println("4.查询员工信息");
            System.out.println("0.退出");
            System.out.print("请选择操作：");
            String next = scanner.next();
            if (CheckString.checkInt(next)) {
                switch (next) {
                    case "1":
                        System.out.print("请输入新增员工姓名：");
                        String name = scanner.next();
                        System.out.print("请输入员工性别：");
                        String sex = scanner.next();
                        System.out.print("请输入员工身份证号：");
                        String eid = scanner.next();
                        System.out.print("请输入该员工上级员工号：");
                        String emgr = scanner.next();
                        System.out.print("请输入员工电话号码：");
                        String etel = scanner.next();
                        System.out.print("请输入员工职位：");
                        String epos = scanner.next();
                        System.out.print("请输入员工密码：");
                        String pwd = scanner.next();
                        boolean b = Clientserver.addStaff(name, sex, eid, emgr, etel, epos, pwd);
                        if (b) {
                            System.out.println("操作成功！");
                        }
                        break;
                    case "2":
                        //员工信息修改菜单
                        messageMenu();
                        break;
                    case "3":
                        //System.out.println("员工离职");
                        //员工离职只能由人事部办理
                        System.out.print("请输入要离职员工的员工编号：");
                        String enumber = scanner.next();
                        Boolean selectemp = Clientserver.selectemp(enumber);
                        if (selectemp){
                            System.out.println("该操作不可逆，是否确认该员工离职 Y/N");
                            String yorn = scanner.next();
                            if (yorn.equals("y") || yorn.equals("Y")){
                                Clientserver.deleteStaff(enumber);
                            }
                        }
                        break;
                    case "4":
                        //System.out.print("查询员工信息");
                        System.out.println("1.查询指定员工");
                        System.out.println("2.查询全部员工");
                        String choose = scanner.next();
                        if (CheckString.checkInt(choose)) {
                            switch (choose){
                                case "1":
                                    System.out.print("请输入要查询的员工编号：");
                                    String enumb = scanner.next();
                                    Boolean selecte = Clientserver.selectemp(enumb);
                                    break;
                                case "2":
                                    Clientserver.selectallEmp();
                            }

                        }
                        break;
                    case "0":
                        System.out.print("退出系统");
                        Menu_Islive = false;
                        break;
                }
            }
        }
    }
    //修改员工信息菜单
    public void messageMenu() {
        while (Message_isLive) {
            System.out.println("欢迎" + Clientserver.getUsername() + "您的权限等级为：" + Clientserver.getPermisssion());
            System.out.println("============企业人事管理系统============");
            System.out.println("//员工信息修改，请输入要修改的信息表");
            System.out.println("1.员工表");
            System.out.println("2.部门表");
            System.out.println("3.学历表");
            System.out.println("4.薪资表");
            System.out.println("5.资历表");
            System.out.println("6.返回上一级菜单");
            System.out.println("0.登出");
            String next = scanner.next();
            if (CheckString.checkInt(next)) {
                switch (next) {
                    case "1":
                        System.out.print("请输入要修改员工的编号：");
                        String enumber = scanner.next();
                        System.out.print("请输入修改员工姓名：");
                        String name = scanner.next();
                        System.out.print("请输入修改员工性别：");
                        String sex = scanner.next();
                        System.out.print("请输入修改员工身份证号：");
                        String eid = scanner.next();
                        System.out.print("请输入修改员工上级员工号：");
                        String emgr = scanner.next();
                        System.out.print("请输入修改员工电话号码：");
                        String etel = scanner.next();
                        System.out.print("请输入修改员工职位：");
                        String epos = scanner.next();
                        System.out.print("请输入修改员工密码：");
                        String pwd = scanner.next();
                        Clientserver.updateemp(name, sex, eid, emgr, etel, epos, pwd, enumber);
                        break;
                    case "2":
//                        System.out.println("修改部门表");
                        System.out.print("请输入归属部门:");
                        String dept = scanner.next();
                        Clientserver.setdept(dept);
                        break;
                    case "3":
//                        System.out.println("修改学历表");
                        System.out.print("请输入学位：");
                        String uaca = scanner.next();
                        System.out.print("请输入毕业院校");
                        String usc = scanner.next();
                        Clientserver.addEdu(uaca,usc);
                        break;
                    case "4":
//                        System.out.println("修改薪资表");
                        System.out.print("请输入基本工资：");
                        String sbase = scanner.next();
                        System.out.println("请输入提成：");
                        String scom = scanner.next();
                        Clientserver.addSal(scom,sbase);
                        break;
                    case "5":
//                        System.out.println("修改资历表");
                        System.out.print("请输入职位变动发生日期：");
                        String data = scanner.next();
                        System.out.print("请输入职位变动详情：");
                        String qexper = scanner.next();
                        Clientserver.addExp(data,qexper);
                        break;
                    case "6":
                        System.out.println("返回上一级目录");
                        Message_isLive = false;
                        break;
                    case "0":
                        System.out.println("退出");
                        Message_isLive = false;
                        Menu_Islive = false;
                        break;
                }
            }
        }
    }
}
