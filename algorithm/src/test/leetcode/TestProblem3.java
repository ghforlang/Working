package test.leetcode;

import main.leetcode.problems.Problem3;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-22 18:39
 *  
 */
public class TestProblem3 {
    private static final String[] str ={
            "c",
            " ",
//            "abcabcbb",
//            "bbbbb",
            "pwwkew"};

    public static void main(String[] args){
        testSolutionOne();
    }

    public static void testSolutionOne(){
        for(String s : str){
            System.out.println(s + " : " + Problem3.lenOfLongestSubString(s));
        }
    }
}
