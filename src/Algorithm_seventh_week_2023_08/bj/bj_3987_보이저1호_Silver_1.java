package Algorithm_seventh_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_3987_보이저1호_Silver_1 {
    static int N,M;
    static char[][]map;
    static boolean[][]visited;
    static int answerCnt;
    static char answerCh;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static char[] chArr = {'U','R','D','L'};
    static boolean flag;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine()," ");
        int si = Integer.parseInt(st.nextToken());
        int sj = Integer.parseInt(st.nextToken());
        /*
        상 / ->우,
        상 \ -> 좌


        우 / -> 상
        우 \ -> 하

        하 / -> 좌
        하 \ -> 우

        좌 / -> 하
        좌 \ ->상
        * */
        //위 아래 왼쪽 오른쪽
        OuterLoop:
        for(int tc =0 ; tc < 4 ; tc++){
            Queue<int[]> q = new ArrayDeque<>();
            visited = new boolean[N][M];
            visited[si][sj] = true;
            q.offer(new int[]{si,sj,tc,0});
            while(!q.isEmpty()){
                int [] c = q.poll();
                int i = c[0]; int j = c[1]; int dir = c[2]; int cnt = 0;
                int ni = i + move[dir][0]; int nj = j + move[dir][1];
                //범위가 나가면 break;
                if(ni<0||nj<0||N-1<ni||M-1<nj) {
                    if(answerCnt<cnt){
                        answerCnt = cnt;
                        answerCh = chArr[tc];
                        break;
                    }
                }
                else if(map[ni][nj]=='C'){
                    if(answerCnt<cnt){
                        answerCnt = cnt;
                        answerCh = chArr[tc];
                        break;
                    }
                }
                else if(visited[ni][nj]){
                    answerCh = chArr[tc];
                    flag = true;
                    break OuterLoop;
                }
                else if(map[ni][nj]=='.'){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,dir,cnt+1});
                }
                else if(map[ni][nj]=='/'||map[ni][nj]=='\\'){
                    if(map[ni][nj]=='/'){
                        switch (dir){
                            case 0: dir = 1;
                                break;
                            case 1: dir = 0;
                                break;
                            case 2: dir = 3;
                                break;
                            case 3: dir = 2;
                                break;
                        }
                    }
                    else {
                        switch (dir){
                            case 0: dir = 3;
                                break;
                            case 1: dir = 2;
                                break;
                            case 2: dir = 1;
                                break;
                            case 3: dir = 0;
                                break;
                        }
                    }
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,dir,cnt+1});
                }
            }
        }
        if(flag){
            System.out.println(answerCh);
            System.out.println("Voyage");
        }else{
            System.out.println(answerCh);
            System.out.println(answerCnt);
        }
    }
}
