package Febrary_third;

import java.io.*;
import java.util.*;

public class bj_17135_캐슬디펜스_Gold_3 {



    static void calc(){
        int[][] copy = new int[N+1][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                copy[i][j] = map[i][j];
            }
        }
        copy[N][tmp[0]] = 3;
        copy[N][tmp[1]] = 3;
        copy[N][tmp[2]] = 3;
        int kill = 0;
        int place = N;
        List<int[]>clist = new ArrayList<>();
        clist.addAll(list);

            while(true){

            List<int[]>deathNode = new ArrayList<>();

            for(int c=0;c<3;c++){

                int i = place;
                int j = tmp[c];
                // D거리보다 작으면 공격(D거리에 있는 적을 확인)
                int minRange = D;
                int left = 987654321;

                for(int d=0;d< clist.size();d++){

                    int [] p = clist.get(d);
                    int pi = p[0];
                    int pj = p[1];
                    int range = Math.abs(i-pi) + Math.abs(j-pj);

                    if(range==minRange){
                        if(pj < left){
                            minRange = range;
                            left = pj;
                        }
                    }else if(range < minRange){
                            minRange = range;
                            left = pj;
                    }
                }

                for(int d=0;d< clist.size();d++){

                    int [] p = clist.get(d);
                    int pi = p[0];
                    int pj = p[1];
                    int range = Math.abs(i-pi) + Math.abs(j-pj);
                    if(range==minRange && pj == left){

                        deathNode.add(new int[]{pi,pj});
                        break;
                    }
                }
            }
            //맵에서 없애주기
            kill += deathNode.size();

            for(int i=0;i<deathNode.size();i++){
                int [] c = deathNode.get(i);
                for(int j=0;j< clist.size();j++){
                    int [] cli = clist.get(j);
                    if(c[0]==cli[0] && c[1]==cli[1]) {
                        clist.remove(j);
                        break;
                    }
                }
                copy[c[0]][c[1]] = 0;
            }
            //궁수가 위로 이동
            for(int c=0;c<3;c++){
                copy[place][tmp[c]] = 0;
                copy[place-1][tmp[c]] = 3;
            }
            place--;
            for(int j=0;j<M;j++) if(copy[place][j]==1) copy[place][j] = 0;

            for(int[] i : copy) System.out.println(Arrays.toString(i));
            System.out.println(kill);
            System.out.println("===========");



            boolean flag = false;
            //확인
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(copy[i][j]==1) {
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag){
                answer = Math.max(answer,kill);
                break;

            }


        }

    }

    static void comb(int depth,int start){

        if(depth==3){
            calc();
            return;
        }

        for(int i=start;i<M;i++){
            tmp[depth] =  i;
            comb(depth+1,i+1);
        }

    }

    static int N,M,D;
    static int[][]map;
    static int[]tmp;
    static int answer;

    static List<int[]> list;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) list.add(new int[]{i,j});
            }
        }
        answer = 0;
        //세명 고르기
        tmp = new int[M];
        comb(0,0);

        System.out.println(answer);
    }
}
