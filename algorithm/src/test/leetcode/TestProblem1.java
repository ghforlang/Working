package test.leetcode;


import main.leetcode.problems.Problem1;
import main.utils.TimeCaculateUtils;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-09 18:44
 *  
 */


public class TestProblem1 {

    private static final int[] src = {2, 0, 11, 7};
    private static final int SUM = 9;

    public static void main(String[] args){
        testSolutionOne();
        testSolutionTwo();
        testSolutionThree();
    }

    private static void testSolutionOne(){
        long start = System.currentTimeMillis();
        Problem1.solutionOne(src,SUM);
        long end = System.currentTimeMillis();
        System.out.println("solutionOne : " + TimeCaculateUtils.getRunningTime(start,end));
    }

    private static void testSolutionTwo(){
        long start = System.currentTimeMillis();
        Problem1.solutionTwo(src,SUM);
        long end = System.currentTimeMillis();
        System.out.println("solutionTwo : " + TimeCaculateUtils.getRunningTime(start,end));
    }

    private static void testSolutionThree(){
        long start = System.currentTimeMillis();
        Problem1.solutionThree(src,SUM);
        long end = System.currentTimeMillis();
        System.out.println("solutionThree : " + TimeCaculateUtils.getRunningTime(start,end));
    }
}
