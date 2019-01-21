package easy;

import java.util.HashMap;
import java.util.Map;

public class EasyCode {
    public static void main(String[] args) {

    }

    /**
     * two sum
     * Given nums = [2, 7, 11, 15], target = 9,
     * <p>
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - i;
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
