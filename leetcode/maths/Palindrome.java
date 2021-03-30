package leetcode.maths;

/**
 * 9-回文数
 * 给一个整数x，如果x是一个回文数，返回true，否者返回false
 */

public class Palindrome {
    // 自己实现的
    public static boolean isPalindrome0(int x) {
        // 如果x是负数，或者个位数是0，则不是回文数，0除外
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        // 将数字转成字符串
        String str = x + "";
        int len = str.length();
        // 使用左右两个指针，从两头来判断字符是否相同
        int L = 0;
        int R = len - 1;
        while (L < R) {
            if (str.charAt(L) != str.charAt(R)) {
                return false;
            } else {
                L++;
                R--;
            }
        }
        return true;
    }

    /**
     * 官方解答：反转一半数字
     */
    public static boolean isPalindrome1(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // 数字长度为奇数时，通过revertedNumber / 10 去除中位的数字。（因为中位的数字不影响回文结果）
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     * 其他人解法:
     */
    // 整数转字符串
    public static boolean isPalindrome2(int x) {
        String reversedStr = (new StringBuffer(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

    // 数学解法
    public static boolean isPalindrome3(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;  // 当前的最高位
            int right = x % 10;  // 当前的最低位
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;  // 取余去除最高位，除10去除最低位
            div /= 100; // x 缩小两位，则div/100
        }
        return true;
    }
}
