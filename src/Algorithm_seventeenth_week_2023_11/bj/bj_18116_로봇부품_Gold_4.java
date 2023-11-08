package Algorithm_seventeenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_18116_로봇부품_Gold_4 {
    static int[]parents;
    static int[]cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        parents = new int[1000001];
        cnt = new int[1000001];
        for(int i=0;i<1000001;i++){
            cnt[i] = 1;
            parents[i] = i;
        }
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            char act = st.nextToken().charAt(0);
            if(act=='I'){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }else{
                int num = Integer.parseInt(st.nextToken());
                sb.append(cnt[find(num)]+"\n");
            }
        }

        System.out.println(sb.toString());
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num]= find(parents[num]);
    }

    static void union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA==rootB) return;
        parents[rootB] = rootA;
        cnt[rootA] += cnt[rootB];

    }
}
