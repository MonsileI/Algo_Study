package Algorithm_nineteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;

public class bj_1194_달이차오른다가자_Gold_1 {
    static int N,M;
    static char[][]map;
    static int answer = -1;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int si = 0; int sj = 0;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='0'){
                    si = i;
                    sj= j;
                    map[i][j] ='.';
                }
            }
        }
        bfs(si,sj);
        System.out.println(answer);

    }
    static void bfs(int si,int sj){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][]visited = new boolean[N][M][64];
        visited[si][sj][0] = true;
        q.offer(new int[]{si,sj,0,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int key = c[2]; int cnt = c[3];
            if(map[i][j]=='1') {
                answer= cnt;
                return;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]=='#') continue;
                if(visited[ni][nj][key]) continue;
                //그냥 길일 경우
                //열쇠일 경우
                 if('a'<=map[ni][nj]&&map[ni][nj]<='f'){
                    int nextKey = 1<<(map[ni][nj] - 'a');
                    nextKey = nextKey | key;
                    if(!visited[ni][nj][nextKey]){
                        visited[ni][nj][nextKey] = true;
                        q.offer(new int[]{ni,nj,nextKey,cnt+1});
                    }
                //문인 경우
                }else if ('A'<=map[ni][nj]&&map[ni][nj]<='F'){
                    if((key & (1<<(map[ni][nj] - 'A')))!=0){
                        visited[ni][nj][key] = true;
                        q.offer(new int[]{ni,nj,key,cnt+1});
                    }
                }else{
                    visited[ni][nj][key] = true;
                    q.offer(new int[]{ni,nj,key,cnt+1});
                }


            }

        }
    }
}
