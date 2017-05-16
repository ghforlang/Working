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

    private static final int[] src = {1, 2, 3, 4,5,6};
    private static final int SUM = 6;

    public static void main(String[] args){
//        testSolutionOne();
//        testSolutionTwo();
        testSolutionThree();
    }

    private static void testSolutionOne(){
        long start = System.currentTimeMillis();
        int[] result = Problem1.solutionOne(src,SUM);
        long end = System.currentTimeMillis();
        System.out.print("solutionOne : " + TimeCaculateUtils.getRunningTime(start,end) + "| ");
        System.out.println(result[0] + "," + result[1]);
    }

    private static void testSolutionTwo(){
        long start = System.currentTimeMillis();
        int[] result = Problem1.solutionTwo(src,SUM);
        long end = System.currentTimeMillis();

        System.out.print("solutionTwo : " + TimeCaculateUtils.getRunningTime(start,end) + "| ");
        System.out.println(result[0] + "," + result[1]);
    }

    private static void testSolutionThree(){
        long start = System.currentTimeMillis();
        int[] result = Problem1.solutionThree(src,SUM);
        long end = System.currentTimeMillis();

        System.out.print("solutionThree : " + TimeCaculateUtils.getRunningTime(start,end) + "| ");
        System.out.println(result[0] + "," + result[1]);
    }
}
