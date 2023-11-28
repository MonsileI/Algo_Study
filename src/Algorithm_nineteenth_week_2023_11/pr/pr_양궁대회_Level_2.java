package Algorithm_nineteenth_week_2023_11.pr;

import java.util.Arrays;

public class pr_양궁대회_Level_2 {

    static int[]tmp;
    static int[]apeach;
    static boolean flag;
    static int ans;
    static int[]answer;
    static int[] solution(int n, int[] info) {
        apeach = info;
        tmp = new int[11];
        answer = new int[11];
        //n발을 쏠거임
        //모든 10발에 대한 dfs
        dfs(n);
        if(!flag) return new int[]{-1};
        return answer;

    }
    static void check(){
        int a = 0;
        int r = 0;
        for(int i=0;i<10;i++){
            if(apeach[i]==0&&tmp[i]==0) continue;
            if(apeach[i]<tmp[i]) r += (10-i);
            else a += (10-i);
        }
        int diff = r-a;
        if(0<diff){
            flag = true;
            if(ans<diff){
                ans = diff;
                for(int i=0;i<11;i++)answer[i] = tmp[i];
            }else if(ans==diff){
                for(int i=10;-1<i;i--){
                    if(answer[i]>tmp[i]) return;
                    else if(answer[i]<tmp[i]){
                        for(int j=0;j<11;j++)answer[j] = tmp[j];
                        return;
                    }
                }
            }
        }
    }
    static void dfs(int last){
        if(last==0){
            System.out.println(Arrays.toString(tmp));
            check();
            return;
        }
        for(int i=0;i<11 && tmp[i]<=apeach[i];i++){
            tmp[i] += 1;
            dfs(last-1);
            tmp[i] -= 1;
        }
    }

    public static void main(String[] args) {
        int n =10;
        int []info = {0,0,0,0,0,0,0,0,3,4,3};
        System.out.println(Arrays.toString(solution(n,info)));
    }
}
