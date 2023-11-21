package Algorithm_repeat_week_first_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_15686_치킨배달_Gold_5 {
    static int N;
    static int M;
    static List<int[]> chickens;
    static List<int[]> homes;
    static int[]tmp;
    static int chiN,homeN;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        chickens = new ArrayList<>();
        homes = new ArrayList<>();
        tmp = new int[M];
        answer = 987654321;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num==2) chickens.add(new int[]{i,j});
                else  if(num==1) homes.add(new int[]{i,j});
            }
        }
        chiN = chickens.size();
        homeN = homes.size();
        comb(0,0);
        System.out.println(answer);
    }
    static void calc(){
        int sum = 0;
        for(int i=0;i<homeN;i++){
            int min = 987654321;
            for(int j=0;j<M;j++){
                min = Math.min(min,Math.abs(chickens.get(tmp[j])[0]-homes.get(i)[0]) + Math.abs(chickens.get(tmp[j])[1]-homes.get(i)[1]));
            }
            sum += min;
            if(answer<=sum) return;
        }
        answer = sum;
    }
    static void comb(int depth, int start){
        if(depth==M){
            calc();
            return;
        }

        for(int i=start;i<chiN;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);
        }

    }
}
