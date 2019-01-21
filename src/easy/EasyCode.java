package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EasyCode {
    public static void main(String[] args) {

        List<Integer> l1= new ArrayList<>();
        List<Integer> l2= new ArrayList<>();
        l1.add(2);
        l1.add(4);
        l1.add(3);
        l2.add(5);
        l2.add(6);
        l2.add(4);

//        addTwoNumbers(l1,l2);
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
     * */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        ListNode p=l1,q=l2,l3=new ListNode(0),l4= null;
        while(l1 != null ){
            list1.add(p.val);
            p=p.next;
        }
        while(l2 != null){
            list2.add(q.val);
            q=q.next;
        }
        int result1 = 0;
        for(int i =0;i<list1.size();i++){
            result1 += list1.get(i) * Math.pow(10,i);
        }
        for(int i =0;i<list2.size();i++){
            result1 += list2.get(i) * Math.pow(10,i);
        }
        String result = result1+"";
        for(int i=result.length()-1;i>=0;i--){
            l3.next = new ListNode(result.charAt(i));
            l4=l3.next;
        }
        return l4;
    }

   static class ListNode
    {
        int val;
        ListNode next = null;

        ListNode(int val)
        {
            this.val = val;
        }
    }

}
