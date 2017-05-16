package main.leetcode.problems;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-16 19:18
 *  链表累加
 */
public class Problem2 {
    public static ListNode solutionOne(ListNode l1,ListNode l2){
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0,x = 0,y = 0,sum = 0;
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while(p != null || q != null){
            x = (p != null) ? p.val : 0;
            y = (q != null) ? q.val : 0;
            sum = x + y + carry;
            carry = sum / 10;//获取进位
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }

        if(carry >0){
            curr.next = new ListNode(carry);
        }
        return result.next;
    }

    public static ListNode solutionTwo(ListNode l1,ListNode l2){
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
}
