package Algorithm_fifth_week_2023_07.bj;

import java.util.*;
import java.io.*;
public class bj_2210_숫자판점프_Silver_2 {
    static int [][]map;
    static Set<Integer> set = new HashSet<>();
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= null;
        map = new int[5][5];
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<5;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                bfs(i,j);
            }
        }
        System.out.println(set.size());
    }
    static void bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x,map[y][x],0});
        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0]; int j =c[1]; int num = c[2];int cnt= c[3];
            if(cnt==5) {
                set.add(num);
                continue;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj= j + move[d][1];
                if(ni<0||nj<0||4<ni||4<nj) continue;
                int newOne = num*10 + map[ni][nj];
                q.offer(new int[]{ni,nj,newOne,cnt+1});
            }
        }
    }
}
