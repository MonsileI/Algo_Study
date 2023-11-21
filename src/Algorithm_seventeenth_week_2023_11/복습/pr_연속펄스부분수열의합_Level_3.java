package Algorithm_seventeenth_week_2023_11.복습;

public class pr_연속펄스부분수열의합_Level_3 {
    public static void main(String[] args) {
        int[]sequence={2, 3, -6, 1, 3, -1, 2, 4};
        int N = sequence.length;
        int[]a = new int[N];
        int[]b = new int[N];
        boolean flag = true;
        for(int i=0;i<N;i++){
            if(flag){
                a[i] = sequence[i]*1;
                b[i] = sequence[i]*(-1);
            }else{
                a[i] = sequence[i]*(-1);
                b[i] = sequence[i]*1;
            }
            flag = !flag;
        }
        long[]dp1 = new long[N];
        long[]dp2 = new long[N];
        dp1[0] = a[0]; dp2[0] = b[0];
        long ans = 0;
        for(int i=1;i<N;i++){
            dp1[i] = Math.max(dp1[i-1]+a[i],a[i]);
            dp2[i] = Math.max(dp2[i-1]+b[i],b[i]);
            ans = Math.max(ans,Math.max(dp1[i],dp2[i]));
        }
        System.out.println(ans);
     }
}
