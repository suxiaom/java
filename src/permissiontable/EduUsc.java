package permissiontable;

import java.util.HashSet;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class EduUsc {
    private static HashSet<String> UscTable = new HashSet<String>();
    static {
        UscTable.add("本科生");
        UscTable.add("博士研究生");
        UscTable.add("硕士研究生");
        UscTable.add("高中生");
        UscTable.add("大专生");

    }

    public EduUsc() {
    }
    //检查学历中填写的内容是否正确
    public static boolean findTable(String usc){
        boolean contains = UscTable.contains(usc);
        return contains;
    }
}
