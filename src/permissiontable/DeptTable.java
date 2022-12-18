package permissiontable;

import java.util.HashMap;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class DeptTable {
    private static HashMap<String,Integer>Table =  new HashMap();
    static {
        Table.put("管理",1);
        Table.put("部门管理",2);
        Table.put("人事部",3);
        Table.put("财务部",4);
        Table.put("市场部",5);
        Table.put("销售部",6);
        Table.put("售后部",7);
        Table.put("研发部",8);
        Table.put("生产部",9);
    }
    public static Integer getdnumber(String dname){
        return Table.get(dname);
    }
}
