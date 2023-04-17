package April_Second;

import java.util.*;
import java.io.*;
public class bj_13549_숨바꼭질3_Gold_5 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int subin = sc.nextInt();
        int Bro = sc.nextInt();
        int answer = 0;
        int[]visited=  new int[100001];
        visited[subin] = 1;

        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{subin,0});


        while(!q.isEmpty()){

            int[]cur = q.poll();
            int loc = cur[0];
            int cnt = cur[1];

            int a=0;

            for(int i=0;i<3;i++){
                //x
                if(i==0){
                a = loc*2;
                if(a<100001) {
                    if (visited[a] == 0 || visited[a] > cnt) {
                        visited[a] = cnt;
                        q.offer(new int[]{a, cnt});
                    }
                }
                //-
                }else if(i==1){
                    a = loc-1;
                    if(-1<a) {
                        if (visited[a] == 0 || visited[a] > cnt + 1) {
                            visited[a] = cnt + 1;
                            q.offer(new int[]{a, cnt + 1});
                        }
                    }
                //+
                }else{
                    a = loc+1;
                    if(a<100001) {
                        if (visited[a] == 0 || visited[a] > cnt + 1) {
                            visited[a] = cnt + 1;
                            q.offer(new int[]{a, cnt + 1});
                        }
                    }
                }
            }

        }
        System.out.println(visited[Bro]);
    }
}
