package labuladong.ch1;

/**
 * 斐波那契数列
 * 斐波那契数列的数学形式就是递归的。
 */

public class Fibonacci {
    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
//            System.out.print(fib(i) + " ");
//            System.out.print(fib_memo(i) + " ");
            System.out.print(fib_dp(i) + " ");
        }
    }

    /**
     * 1-暴力递归
     */
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        // 存在重叠子问题
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 2-带备忘录的递归算法
     * <p>
     * 造一个“备忘录”，每次算出的子问题的答案后先不急着返回，先将其记录到“备忘录”里再返回
     * 每次遇到一个子问题先去备忘录里查一下，如果存在就直接用。
     * 一般使用数组充当“备忘录”或者字典（哈希表）
     * <p>
     * 就是把一颗存在巨量冗余的递归树通过剪枝，改造成不存在荣誉的递归图。
     * 时间复杂度：O(N)
     */
    public static int fib_memo(int n) {
        if (n == 0) {
            return 0;
        }
        // 备忘录，数组默认值是 0
        int[] memo = new int[n + 1];
        // 进行带备忘录的递归
        return helper(memo, n);
    }

    // 自顶向下
    public static int helper(int[] memo, int n) {
        // base case
        if (n == 1 || n == 2) {
            return 1;
        }
        // 若不为0，即已经2计算过（因为初始值是0）
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    /**
     * 数组的迭代解法
     */
    // 自底向上
    public static int fib_dp(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 优化：
     * 根据状态转移方程，当前状态之和前两个状态有关系，不需要一个长的DP表
     * <p>
     * “状态压缩”
     */
    public static int fib_dp_opt(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int prev = 1, cur = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + cur;
            prev = cur;
            cur = sum;
        }
        return cur;
    }

}
