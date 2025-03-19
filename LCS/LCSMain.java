package LCS;

public class LCSMain {
    public static int lcs(int index1 , int index2 ,String s , String t ){
if(index1 <0 || index2 <0) return 0;

if(s.charAt(index1)== t.charAt(index2)){
    return 1+lcs(index1-1, index2-1, s, t);
}

return  0+ Math.max(lcs(index1-1, index2, s, t), lcs(index1, index2-1, s, t));
    }
    public static int findCommonLcs(String s , String t){
return lcs(s.length()-1, t.length()-1, s, t);
    }
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int ans =findCommonLcs(text1, text2);
        System.out.println(ans);
    }
}
