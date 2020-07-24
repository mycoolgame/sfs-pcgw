//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4645 👎 0

package com.sou.sfspcgw.backup;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4);
//        ListNode l3 = new ListNode(3);
        l1.next = l2;
//        l2.next =l3;
        ListNode r1 = new ListNode(5);
//        ListNode r2 = new ListNode(6);
//        ListNode r3 = new ListNode(9);
//        ListNode r4 = new ListNode(7);
//        r1.next = r2;
//        r2.next = r3;
//        r3.next = r4;

        ListNode res = solution.addTwoNumbers(l1,r1);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }


    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode head = null;
        ListNode index = null;
        //处理相加部分
        //进位
        int up = 0;
        while(current1!=null||current2!=null){
            int v1 = current1==null?0:current1.val;
            int v2 = current2==null?0:current2.val;
            int sum = v1+v2+up;
            up = sum/10;
            ListNode c = new ListNode(sum%10);
            if(head == null){
                head = c;
                index = c;
            }else{
                index.next = c;
                index = c;
            }
            if(current1!=null){
                current1 = current1.next;
            }
            if(current2!=null){
                current2 = current2.next;
            }
        }
        if(up!=0){
            ListNode c = new ListNode(up);
            index.next = c;
        }
        return head;
    }
}
static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
//leetcode submit region end(Prohibit modification and deletion)

}