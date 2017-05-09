package main.utils;


import main.leetcode.exception.AlgorithmException;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-09 18:39
 *  
 */
public class TimeCaculateUtils {
    public static long getRunningTime(long startTime,long endTime){
        if(endTime >= startTime){
            return endTime - startTime;
        }
        throw new AlgorithmException("开始时间不能小于结束时间！");
    }
}
