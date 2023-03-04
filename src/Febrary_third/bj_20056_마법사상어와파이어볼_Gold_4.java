package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_20056_마법사상어와파이어볼_Gold_4 {

    static class Fire {

        int r,c,m,s,d;

        public Fire(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Fire{" +
                    "r=" + r +
                    ", c=" + c +
                    ", m=" + m +
                    ", s=" + s +
                    ", d=" + d +
                    '}';
        }
    }

    static int[][]move = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        List<Fire> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List[][]map = new List[N][N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Fire f = new Fire(r,c,m,s,d);
            list.add(f);
        }
        /*
        ri, ci), 질량은 mi이고, 방향은 di, 속력은 si이다.
        * */
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = new ArrayList<Fire>();
            }
        }


        while(0<K){

            int size = list.size();
            for(int i=0;i<size;i++){
                //우선 이동
                Fire fire = list.get(i);
                //지워주기
                map[fire.r][fire.c].remove(fire);

                //이동
                fire.r = fire.r + (fire.s * move[fire.d][0]);
                fire.c = fire.c + (fire.s * move[fire.d][1]);
                //이동 후 맵에 추가
                map[fire.r][fire.c].add(fire);

            }
            list = new ArrayList<>();

            for(Fire f : list) System.out.println(f);


            //겹치는거 확인, 업로드
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    //한개면 그냥 추가
                    if(map[i][j].size()==1){

                    }






                }
            }






            K--;
        }


    }
}
