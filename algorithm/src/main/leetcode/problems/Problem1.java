package main.leetcode.problems;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-09 18:44
 *  
 */


import main.leetcode.exception.AlgorithmException;

import java.util.HashMap;
import java.util.Map;

/**
 * Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class Problem1 {

    /**
     * 暴力破解,TC O(N2),SC O(1)
     * @param src
     * @return
     */
    public static int[] solutionOne(int[] src,int target){
        for(int i=0;i<src.length;i++){
            for(int j= i + 1;j<src.length;j++){
                if(src[i] == target - src[j]){

                    return new int[]{i,j};
                }
            }
        }
        throw new AlgorithmException("no solution!");
    }

    /**
     * 采用hashtable解决问题,TC: O(N),SC:O(N)
     * @param src
     * @param target
     * @return
     */
    public static int[] solutionTwo(int[] src,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<src.length;i++){
            map.put(src[i],i);
        }

        for(int i=0;i<src.length;i++){
            int complement = target - src[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i,map.get(complement)};
            }
        }
        throw new AlgorithmException("no solution!");
    }

    /**
     * hashtable,一次循环完成所有，相比solutionTwo少一次循环
     * @param src
     * @param target
     * @return
     */
    public static int[] solutionThree(int[] src,int target){
        Map<Integer,Integer> map = new HashMap<>();
        int complement = -1;
        for(int i=0;i<src.length;i++){
            complement = target - src[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return  new int[]{i,complement};
            }
            map.put(src[i],i);
        }
        throw new AlgorithmException("no solution!");
    }
}
