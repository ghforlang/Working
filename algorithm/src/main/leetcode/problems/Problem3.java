package main.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-05-22 18:30
 *  
 */
public class Problem3 {
    public static int lenOfLongestSubString(String str){
        int result = 0;
        if(str == null || (str != null && str.length() ==0)){
            return result;
        }else{
            int max = result;
            Set<Character> set = new HashSet<>();
            for(int i=0,j=0;i<str.length() && j<str.length();i++){
                if(!set.contains(str.charAt(i))){
                    set.add(str.charAt(i));
                }else{
                    max = max >set.size() ? max : set.size();
                    set.clear();
                    j ++;
                    i = j;
                }
            }
            result = max > set.size() ? max : set.size();
        }
        return result;
    }
}
