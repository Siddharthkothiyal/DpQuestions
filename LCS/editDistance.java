package LCS;

import java.util.Arrays;

public class editDistance {
    public static int Helper(String s, String t, int index1, int index2, int dp[][]) {
        if (index1 < 0 ) return index2 + 1;
        if (index2 < 0) return index1 + 1;
            
        if (dp[index1][index2] != -1)
            return  dp[index1][index2];

        if (s.charAt(index1) == t.charAt(index2)) {
            return 0+ Helper(s, t, index1 - 1, index2 - 1, dp);
        }
        // for insert-> delete -> replace
        return   1+Math.min(Helper(s, t, index1, index2 - 1, dp),
                Math.min(Helper(s, t, index1 - 1, index2, dp), Helper(s, t, index1 - 1, index2 - 1, dp)));
    }

    public static int editDis(String s , String t){
        int [][] dp = new int[s.length()][t.length()];
        for(int row[] : dp){
            Arrays.fill(row , -1);
        }
return Helper(s, t, s.length()-1, t.length()-1, dp);
    }

    public static void main(String[] args) {
        String s = "horse";
        String t = "ros";

        System.out.println(editDis(s, t));
    }

}
