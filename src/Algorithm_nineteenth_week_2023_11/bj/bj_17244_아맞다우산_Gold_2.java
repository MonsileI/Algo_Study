package Algorithm_nineteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_17244_아맞다우산_Gold_2 {
    static int N,M;
    static char[][]map;
    static int answer;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static char end;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int x = 0; int si = 0; int sj = 0;
        map = new char[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='S'){
                    si = i; sj = j;
                    map[i][j] = '.';
                }
                if(map[i][j]=='X'){
                    x++;
                    map[i][j] = String.valueOf(x).charAt(0);
                }
            }
        }
        end = String.valueOf(x).charAt(0);
        x = (int)Math.pow(2,x);
        bfs(si,sj,x);
        System.out.println(answer);
    }
    static void bfs(int si,int sj,int xcount){
        boolean[][][]visited=  new boolean[N][M][xcount];
        visited[si][sj][0] = true;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{si,sj,0,0}); //출발i , 출발j, key값, cnt;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int key = c[2]; int cnt = c[3];
            if(map[i][j]=='E'){
                if(key==(xcount-1)){
                    answer = cnt;
                    return;
                }
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj][key]) continue;
                if(map[ni][nj]=='#') continue;
                //물건일경우 vs 아닐경우
                if('1'<=map[ni][nj]&&map[ni][nj]<=end){
                    int newKey = 1<<(map[ni][nj] - '1');
                    newKey = newKey | key;
                    if(!visited[ni][nj][newKey]){
                        visited[ni][nj][newKey] = true;
                        q.offer(new int[]{ni,nj,newKey,cnt+1});
                    }
                }else{
                    visited[ni][nj][key] = true;
                    q.offer(new int[]{ni,nj,key,cnt+1});
                }
            }
        }
    }
}
