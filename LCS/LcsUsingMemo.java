package LCS;

import java.util.Arrays;

public class LcsUsingMemo {
    public static int lcs(int index1 , int index2 ,String s , String t ,int dp[][] ){
        if(index1 <0 || index2 <0) return 0;
        if(dp[index1][index2] != -1) return dp[index1][index2] ;
        
        
        if(s.charAt(index1)== t.charAt(index2)){
            return dp[index1][index2] = 1+lcs(index1-1, index2-1, s, t , dp);
        }
        
        return dp[index1][index2] = 0+ Math.max(lcs(index1-1, index2, s, t , dp), lcs(index1, index2-1, s, t, dp));
            }

    public static int findCommonLcs(String s, String t) {
        int dp[][] = new int[s.length()][t.length()];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return lcs(s.length() - 1, t.length() - 1, s, t , dp);
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int ans = findCommonLcs(text1, text2);
        System.out.println(ans);
    }
}
