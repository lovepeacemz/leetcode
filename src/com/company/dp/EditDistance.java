package com.company.dp;

/**
 * 描述内容
 *
 * @author zhangmeng36
 * @date 2019/8/1 下午10:55
 */
public class EditDistance {

    public static int findEditDistance(String a, String b){
        char[] src = a.toCharArray();
        char[] desc = b.toCharArray();
        int [][] dp = new int [src.length + 1][ desc.length + 1];
        // 初始化
        for(int i = 1; i <= src.length; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j <= desc.length; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i <= src.length; i++){
            for(int j = 1; j <= desc.length; j++){
                int flag = 0;
                if(src[i-1] != desc[j-1]){
                    flag = 1;
                }
                dp[i][j] = Math.min(Math.min(dp[i-1][j-1] + flag, dp[i-1][j] + 1), dp[i][j-1] + 1);
                if(i > 1 && j > 1 && src[i-1] == desc[j-2] && src[i-2] == desc[j-1]){
                    dp[i][j] = Math.min(dp[i-2][j-2] + flag, dp[i][j]);
                }
            }
        }
        return dp[src.length][desc.length];
    }
    public static void main(String[] args) {
        int Edit = findEditDistance("ab","a");
    }
}
