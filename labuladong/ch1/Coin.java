package labuladong.ch1;

import java.util.Arrays;

/**
 * 凑零钱问题--动态规划为题
 * 题目： 给你 K 种面值的硬币，面值分别为 c1,c2,...,ck，每种硬币的数量无限。
 * 再给一个总金额 amount ，问最少需要几枚硬币凑出这个金额，若不能凑出，返回-1。
 */


public class Coin {
    public static void main(String[] args) {
        int[] coins = new int[]{2, 5};
        for (int i = 0; i <= 20; i++) {
            int k = coinChange_dp(coins, i);
            System.out.println(i + "\t" + k);
        }
    }

    /**
     * 暴力递归
     * 1-确定base case：当amount = 0时，算法返回0
     * 2-确定“状态”：原问题和子问题的变量，硬币数量无限，面额给定，只有目标金额不断地向base case靠拢
     * 唯一的状态就是：amount
     * 3-确定“选择”：导致“状态”产生变化的行为。所有硬币的面值就是你的“选择“。
     *
     * @param coins  可选硬币的面值
     * @param amount 目标金额
     * @return 最少硬币数
     */
    public static int coinChange(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        // 求最小值，所以初始化为正无穷
        int res = 2147483647;
        for (int coin : coins) {
            int subProblem = coinChange(coins, amount - coin);
            // 子问题无解
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        return ((res != 2147483647) ? res : -1);
    }


    /**
     * 数组迭代发
     * 使用自底向上来消除重叠子问题。
     */
    public static int coinChange_dp(int[] coins, int amount) {
        // 数组大小为 amount + 1，初始化也为amount + 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 类似于遍历填充数组
        dp[0] = 0;
        // 外层for循环遍历所有状态的可取值
        for (int i = 0; i < dp.length; i++) {
            // 内存for循环求所有选择最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

}
