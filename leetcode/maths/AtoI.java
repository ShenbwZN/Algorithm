package leetcode.maths;

/**
 * 8.字符串转换整数
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 */
public class AtoI {

    public static int myAtoI(String str) {
        int max = 2147483647;
        int min = -2147483648;
        int flag = 1;  // 正数标志
        str = str.trim();
        int len = str.length();
        char[] chars = str.toCharArray();
        if (len == 0) {
            return 0;
        }
        int index = 0;
        if (chars[0] == '-') {
            index++;
            flag = -1;
        }
        if (chars[0] == '+') {
            index++;
        }
        int result = 0;
        for (int i = index; i < len; i++) {
            if (chars[i] <= '9' && chars[i] >= '0') {
                if (result > max / 10 || ((chars[i] - 48) > (max % 10) && max / 10 == result)) {
                    return max;
                }
                if (result < min / 10 || ((chars[i] - 48) > -(min % 10) && min / 10 == result)) {
                    return min;
                }
                result = result * 10 + flag * (chars[i] - 48);
            } else {
                break;
            }
        }
        return result;
    }
}
