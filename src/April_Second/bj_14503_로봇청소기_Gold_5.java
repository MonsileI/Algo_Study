package April_Second;

import java.util.*;
import java.io.*;
public class bj_14503_로봇청소기_Gold_5 {
    static int N,M,map[][];
    static int si,sj,rd; //0 1 2 3 북 동 남 서 (상우하좌)
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); map = new int[N][M];
        st = new StringTokenizer(br.readLine()," ");
        si = Integer.parseInt(st.nextToken()); sj = Integer.parseInt(st.nextToken()); rd = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while(true){
            //first
            if(map[si][sj]==0){
                map[si][sj] = 2;
                cnt++;
            }

            //second
            if(!second()){
                int ni = si - move[rd][0];
                int nj = sj - move[rd][1];
                if(map[ni][nj]==1) break;
                si = ni;
                sj = nj;
                continue;

            }else{
                //0 ->3 : 1 -> 0 : 2-> 1 : 3->2
                //회전
                    rd = (rd + 3) % 4;
                    int ni = si + move[rd][0];
                    int nj = sj + move[rd][1];
                    if (map[ni][nj] == 0) {
                        si = ni;
                        sj = nj;
                        continue;

                }
            }
        }


        System.out.println(cnt);

    }

    static boolean second(){
        for(int d=0;d<4;d++){
            int ni = si + move[d][0];
            int nj = sj + move[d][1];
            if(map[ni][nj]==0) return true;
        }
        return false;
    }
}
