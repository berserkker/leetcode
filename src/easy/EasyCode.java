package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EasyCode {
    public static void main(String[] args) {
        //addTwoNumbers
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result.val + "" + result.next.val + "" + result.next.next.val);

        System.out.println(reverse(-123));

        System.out.println(myAtoi("-91283472332"));

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

    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     * 示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */
    public static int reverse(int x) {
        StringBuffer result = new StringBuffer();
        boolean flag = false;
        if (x == 0 || x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            x = x * -1;
            flag = true;
        }
        while (x / 10 > 0) {
            result.append(x % 10 + "");
            x = x / 10;
        }
        result.append(x + "");
        int number = 0;
        try {
            if (flag) {
                number = Integer.valueOf(result.toString()).intValue() * -1;
            } else {
                number = Integer.valueOf(result.toString()).intValue();
            }
        } catch (Exception e) {
            return 0;
        }
        return number;
    }

    public static int lengthOfLongestSubstring(String s) {
        StringBuffer sb = new StringBuffer();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int position = sb.indexOf(s.charAt(i) + "");
            if (position == -1) {
                sb.append(s.charAt(i));
                max = Math.max(max, sb.length());
                System.out.println(sb.toString());
            } else {
                sb = new StringBuffer(sb.substring(position + 1) + s.charAt(i) + "");
                System.out.println(sb.toString() + "---");
            }
        }
        return max;

    }

    /**
     * leetcode 第8题，字符串转整数
     */
    public static int myAtoi(String str) {
        Long sum = 0L;
        int flag = 1;
        int start = 0;
        char[] array = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (start == i && array[i] == ' ') {
                start++;
                continue;
            }
            if (array[i] == '-') {
                if (i + 1 == str.length() || !isNumber(array[i + 1])) {
                    break;
                }
                flag = -1;
                continue;
            }
            if (array[i] == '+') {
                if (i + 1 == str.length() || !isNumber(array[i + 1])) {
                    break;
                }
                continue;
            }
            if (isNumber(array[i])) {
                sum = sum * 10 + (array[i] - '0');
                if (flag == 1 && sum >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (flag == -1 && sum * flag <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                if (i + 1 == str.length() || !isNumber(array[i + 1])) {
                    break;
                }
            } else {
                break;
            }
        }
        return sum.intValue();
    }

    public static boolean isNumber(char a) {
        if (a >= '0' && a <= '9') {
            return true;
        }
        return false;
    }

    /**
     * 20
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * <p>
     * 输入: "{[]}"
     * 输出: true
     */
    public static boolean isvalid(String s) {
        Stack<String> stack = new Stack<>();
        Map<String, String> map = new HashMap<String, String>(3) {{
            put(")", "(");
            put("}", "{");
            put("]", "[");
        }};
        if ("".equals(s)) {
            return true;
        }
        for (char a : s.toCharArray()) {
            if (a == '(' || a == '{' || a == '[') {
                stack.push(a + "");
            } else if (!stack.isEmpty() && map.get(a + "").equals(stack.peek())) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }

    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 1:
     * <p>
     * 给定 nums = [3,2,2,3], val = 3,
     * <p>
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * <p>
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * <p>
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * <p>
     * 注意这五个元素可为任意顺序。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 说明:
     * <p>
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * <p>
     * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * <p>
     * 你可以想象内部操作如下:
     * <p>
     * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
     * int len = removeElement(nums, val);
     * <p>
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     * <p>
     * 27  双指针法
     */
    public int removeElement(int[] nums, int val) {
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[number] = nums[i];
                number++;
            }

        }
        return number;
    }

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 21
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode l0 = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l0.next = l1;
                l1 = l1.next;
            } else {
                l0.next = l2;
                l2 = l2.next;
            }
            l0 = l0.next;
        }
        l0.next = l1 == null ? l2 : l1;
        return result.next;
    }

}


