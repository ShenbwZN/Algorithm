package leetcode.Hashtable;

import java.util.HashMap;

/**
 * 1-两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
 */

public class TwoSum {
    /**
     * 暴力枚举
     */
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] + nums[i] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 哈希表法
     */
    public static int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        // 设置哈希表的长度避免扩容麻烦
        HashMap<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another)) {
                // another是前面的元素，num[i]是后面的元素
                return new int[]{map.get(another), i};
            }
            // 以值为键，索引为值
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 2};
        int target = 6;
        int[] index = twoSum1(nums, target);
        System.out.println("[" + index[0] + ", " + index[1] + "]");
    }
}
