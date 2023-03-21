package March_Second;

import java.util.*;
import java.io.*;
public class bj_15686_치킨배달_Gold_5 {
    static int N,M,map[][];
    static int[]tmp;
    static int answer;

    static List<int[]> chick, house;

    static int houseSize, chickSize;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        chick = new ArrayList<>();
        house = new ArrayList<>();
        answer = 987654321;
        tmp = new int[M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) house.add(new int[]{i,j});
                else if(map[i][j]==2)chick.add(new int[]{i,j});
            }
        }
        houseSize = house.size();
        chickSize = chick.size();
        comb(0,0);

        System.out.println(answer);
    }
    static void calc(){

        //tmp[i]에 들어있는 치킨집을 폐쇄시키고, 치킨거리를 세어 보자!(치킨거리는 가장 가까운 치킨거리!)
    int sum = 0;

      for(int i=0;i<houseSize;i++){
          int h = 987654321;
          for(int j=0;j<M;j++){
              int ci = chick.get(tmp[j])[0];
              int cj = chick.get(tmp[j])[1];
              h = Math.min(h, Math.abs(ci - house.get(i)[0] ) + Math.abs(cj - house.get(i)[1]));
          }
          sum += h;
      }

       answer = Math.min(answer,sum);
    }

    static void comb(int start,int depth){

        if(depth==M){
            calc();
            return;
        }


        for(int i=start;i<chickSize;i++){
            tmp[depth] = i;
            comb(i+1,depth+1);
        }
    }
}
