package leetcode.numSum;

import java.util.HashMap;

/**
 * @author rcli
 * Created on 2019/10/29.
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoNumSum {

    public static void main(String[] args) {

    }

    // 蛮力解法 O(n^2)
    public int[] twoSum1(int[] nums, int target) {
        int[] result = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] != nums[j] && nums[j] == diff) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    // 字典序
    public int[] twoSum2(int[] nums, int target) {
        int[] result = {0, 0};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }
}
