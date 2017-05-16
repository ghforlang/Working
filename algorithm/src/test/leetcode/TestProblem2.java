package test.leetcode;

import main.leetcode.problems.ListNode;
import main.leetcode.problems.Problem2;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-16 19:36
 *  
 */
public class TestProblem2 {

    private static ListNode l1 = new ListNode(2);
    private static ListNode l2 = new ListNode(5);
    static{
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
    }

    public static void main(String[] args){
        ListNode result = Problem2.solutionOne(l1,l2);

        while(result != null){
            System.out.println(result.val + ",");
            result = result.next;
        }
    }

}
