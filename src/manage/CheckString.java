package manage;

/**
 * @auther 苏小牧
 * -Dfile.encoding=UTF-8
 */
public class CheckString {
    //检查字符串是否为纯数字
    public static boolean checkInt(String str){
        boolean tof = false;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9' || aChar == '.'){
                tof = true;
            }
        }
        return tof;
    }

    /**
     * 检查相应字符长度是否合适
     * @param str
     * @param Size 第一个为最大长度 第二个为最小长度，最多传两个参数，若传一个参数则长度等于传入的唯一参数
     * @return
     */
    public static boolean checkLong(String str,int... Size) {
        char[] chars = str.toCharArray();
        if (Size.length == 1) {
            if (chars.length <= Size[0] && chars.length >= Size[0]) {
                return true;
            } else {
                System.out.println("输入的长度存在问题！");
                return false;
            }
        } else {
            if (chars.length <= Size[0] && chars.length >= Size[1]) {
                return true;
            } else {
                System.out.println("输入的长度存在问题！");
                return false;
            }
        }
    }
    public static boolean CheckData(String data){
        String Reg = "\\d{4,}-\\d{2,}-\\d{2,}";
        boolean matches = data.matches(Reg);
        return matches;
    }
}
