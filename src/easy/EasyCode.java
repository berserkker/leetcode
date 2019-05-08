package easy;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EasyCode {
    public static void main(String[] args) {
        //addTwoNumbers
       /* ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result.val + "" + result.next.val + "" + result.next.next.val);

        System.out.println(reverse(-123));*/

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
        if(x==0 || x>=Integer.MAX_VALUE || x <= Integer.MIN_VALUE){
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
            }else{
                number = Integer.valueOf(result.toString()).intValue();
            }
        } catch (Exception e) {
            return 0;
        }
        return number;
    }

    public static  int lengthOfLongestSubstring(String s) {
        StringBuffer sb =  new StringBuffer();
        int max = 0;
        for(int i=0;i<s.length();i++){
            int position = sb.indexOf(s.charAt(i)+"");
            if(position == -1){
                sb.append(s.charAt(i));
                max = Math.max(max,sb.length());
                System.out.println(sb.toString());
            }else{
                sb = new StringBuffer(sb.substring(position+1)+s.charAt(i)+"");
                System.out.println(sb.toString()+"---");
            }
        }
        return max;

    }

    public static int myAtoi(String str) {
        Long sum =0L;
        int flag =1;
        int start =0;
        char[] array = str.toCharArray();
        for(int i=0;i<str.length();i++){
            if(start==i && array[i]==' '){
                start++;
                continue;
            }
            if(array[i]=='-') {
                if(i+1 ==str.length() || !isNumber(array[i+1])){
                    break;
                }
                flag = -1;
                continue;
            }
            if(array[i]=='+'){
                if(i+1 ==str.length() || !isNumber(array[i+1])){
                    break;
                }
                continue;
            }
            if(isNumber(array[i])){
                sum = sum *10+(array[i]-'0');
                if(flag ==1 && sum >= Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if(flag == -1 && sum*flag <= Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                if(i+1 ==str.length() || !isNumber(array[i+1])){
                    break;
                }
            }else{
                break;
            }
        }
        return sum.intValue();
    }

    public static boolean isNumber(char a){
        if(a >= '0' && a <= '9'){
            return true;
        }
        return false;
    }
}


