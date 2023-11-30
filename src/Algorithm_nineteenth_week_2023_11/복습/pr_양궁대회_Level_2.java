package Algorithm_nineteenth_week_2023_11.복습;

import java.util.Arrays;

public class pr_양궁대회_Level_2 {

    static int[]apeach;
    static int[]tmp;
    static boolean flag;
    static int[]answer;
    static int max;
    static int[] solution(int n, int[] info) {

        apeach = info;
        tmp = new int[11];
        answer = new int[11];
        dfs(n);
        if(!flag) answer = new int[]{-1};
        return answer;
    }

    static void check(){
        int a = 0; int r = 0;
        for(int i=0;i<11;i++){
            if(apeach[i]==0&&tmp[i]==0) continue;
            if(apeach[i]<tmp[i]) r += (10-i);
            else a += (10-i);
        }
        int diff = r-a;
        if(max<diff) {
            max = diff;
            for(int i=0;i<11;i++)answer[i] = tmp[i];
            flag = true;
        }
        else if(max==diff){
            for(int i=10;-1<i;i--) {
                if(tmp[i]<answer[i]) return;
                if(answer[i]<tmp[i]) {
                    for(int j=0;j<11;j++)answer[j] = tmp[j];
                    return;
                }
            }

        }
    }

    static void dfs(int n){
        if(n==0){
            check();
            return;
        }

        for(int i=0;i<11&&tmp[i]<=apeach[i];i++){
            tmp[i]++;
            dfs(n-1);
            tmp[i]--;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int [] info = {0,0,0,0,0,0,0,0,3,4,3};
        System.out.println(Arrays.toString(solution(n,info)));
    }
}
