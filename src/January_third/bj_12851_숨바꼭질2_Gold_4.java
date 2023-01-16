package January_third;
import java.io.*;
import java.util.*;

public class bj_12851_숨바꼭질2_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int subin = Integer.parseInt(st.nextToken());
        int sis = Integer.parseInt(st.nextToken());
        int answer = 987654321;

        Queue<int[]> q= new ArrayDeque<>();
        int[]dist = new int[100001];
        q.offer(new int[]{subin,0});

        int way = 0;

        dist[subin] = 0;


        while(!q.isEmpty()){


            int [] c = q.poll();
            int now = c[0];
            int cnt = c[1];

            if(now==sis) {
                answer = cnt;
                way++;
            }

            if(answer<cnt) break;


            int ni = now + 1;
            if(100000<ni) continue;
            if(dist[ni]==0 || ni==sis) {
                dist[ni] = cnt + 1;
                q.offer(new int[]{ni, cnt + 1});
            }
            ni -= 2;
            if(ni<0) continue;
            if(dist[ni]==0 || ni==sis) {
                dist[ni] = cnt + 1;
                q.offer(new int[]{ni, cnt + 1});
            };

            ni++;
            ni *= 2;
            if(100000<ni) continue;
            if(dist[ni]==0 || ni==sis) {
                dist[ni] = cnt + 1;
                q.offer(new int[]{ni, cnt + 1});
            };
        }


        System.out.println(answer+"\n"+way);


    }
}
