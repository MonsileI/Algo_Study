package Febrary_fourth;

import java.util.*;
import java.io.*;
public class bj_21609_상어중학교_Gold_2 {
    static int N,M,map[][];
    static boolean visited[][];
    static int maxCnt, maxRow, maxCol;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][]maxBlock;


    static void gravity(){


        for(int [] i : map) System.out.println(Arrays.toString(i));

        for(int j=0;j<N;j++){
            for(int i=N-1;i>0;i--){
                if(map[i][j]==M+1){
                    int idx = i;
                    while(true){
                        map[idx][j] = map[idx-1][j];
                        map[idx-1][j] = M+1;
                        idx++;
                        if(idx>N-1) break;
                        if(map[idx][j]==-1) break;

                    }
                }
            }
        }
        System.out.println();
        for(int [] i : map) System.out.println(Arrays.toString(i));

        System.out.println("====================");
    }
    static void turn(){

        int[][]copyMap = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                copyMap[j][N-1-i] = map[i][j];
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) map[i][j] = copyMap[i][j];
        }




    }
    static void copy(boolean[][]tmpVisited){
        maxBlock = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                maxBlock[i][j] = tmpVisited[i][j];
            }
        }
    }
    static void bfs(int y,int x, int num){

        List<int[]> tmpList = new ArrayList<>();
        int cnt = 1;
        visited[y][x] = true;
        boolean[][] tmpVisited = new boolean[N][N];
        tmpVisited[y][x] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x,0});

        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0];
            int j = c[1];

            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];

                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;

                if(!visited[ni][nj] && (map[ni][nj] == 0 || map[ni][nj] == num)){
                    visited[ni][nj] = true;
                    tmpVisited[ni][nj] = true;
                    if(map[ni][nj]==0) tmpList.add(new int[]{ni,nj});
                    cnt++;
                    q.offer(new int[]{ni,nj});
                }
            }
        }

        //가장 큰 값 확인
        if(maxCnt < cnt){
            maxCnt = cnt ; maxRow = y; maxCol = x;
            copy(tmpVisited);
        }else if(maxCnt==cnt){
            if(maxRow < y){
                maxCnt = cnt ; maxRow = y; maxCol = x;
                copy(tmpVisited);
            }else if(maxRow==y){
                if(maxCol < x){
                    maxCnt = cnt ; maxRow = y; maxCol = x;
                    copy(tmpVisited);
                }
            }
        }
        //0은 다른 애가 영역으로 활용할 수도 있으니까 초기화 해주자.

        int size = tmpList.size();
        for(int i=0;i<size;i++) visited[tmpList.get(i)[0]][tmpList.get(i)[1]] = false;


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        int breakInt = 0;
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != -1) breakInt++;
            }
        }
        int answer = 0;

        while(true) {


            maxCnt = 0;
            maxRow = 0;
            maxCol = 0;


            //가장 큰 것 찾기 bfs
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && (map[i][j] != -1 || map[i][j] != 0)) {
                        bfs(i, j, map[i][j]);
                    }
                }
            }
            //점수 올려줌
            answer += Math.pow(maxCnt, 2);
            breakInt -= maxCnt;
            //블록이 다 제거되었으면 break;
            System.out.println(breakInt);
            if(breakInt==0) break;

            //M+1은 빈공간으로 생각하자(어차피 M보다 숫자가 큰 블록은 없음)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(maxBlock[i][j]) map[i][j] = M+1;
                }
            }
            //중력 작동
            gravity();
            //회전
            turn();
            //중력 재(?)작동
            gravity();

            break;


        }

        System.out.println(answer);

    }
}
