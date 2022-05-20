package Leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class BastlongStr {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcda");
    }
    public static int lengthOfLongestSubstring(String s) {
    s = "abcdaaaaaqweertiujyu";
        int[] docker = new int[128];
        for (int i = 0; i <docker.length ; i++) {
            docker[i] = -1;
        }
        int start =0;
        int res = 0;

        for (int i = 0; i <s.length() ; i++) {
            int index = s.charAt(i);
            start = Math.max(start,docker[index]+1);
            res = Math.max(res, i-start+1);
            docker[index] = i;
        }

        return res;
    }

}
