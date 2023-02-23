package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_18428_감시피하기_Gold_5 {

    static int N, map [][], t[],sn;
    static boolean flag;
    static List<int[]> list = new ArrayList<>();
    static List<int[]> tArr = new ArrayList<>();
    static void calc(){
        int[][]tmp = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                tmp[i][j] = map[i][j];
            }
        }
        for(int d=0;d<3;d++){
            int [] c = list.get(t[d]);
            tmp[c[0]][c[1]] = 3; //벽
        }


        for(int d=0;d<tArr.size();d++){

            int[]c = tArr.get(d);

            int y = c[0];
            int x = c[1];

            //상 하
            InnerLoop:
            for(int i=y;i<N;i++){
                if(tmp[i][x]==1) return;
                else if(tmp[i][x]==3) break  InnerLoop;
            }
            InnerLoop:
            for(int i=y;i>-1;i--){
                if(tmp[i][x]==1) return;
                else if(tmp[i][x]==3) break  InnerLoop;
            }

            //좌 우
            InnerLoop:
            for(int j=x;j<N;j++){
                if(tmp[y][j]==1) return;
                else if(tmp[y][j]==3) break  InnerLoop;
            }
            InnerLoop:
            for(int i=x;i>-1;i--){
                if(tmp[y][i]==1) return;
                else if(tmp[y][i]==3) break  InnerLoop;
            }
        }

        flag = false;
    }
    static  void comb(int depth, int start){

        if(!flag) return;
        if(depth==3){
            calc();
            return;
        }
        for(int i=start;i<sn;i++){
            t[depth] = i;
            comb(depth+1, i+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        tArr = new ArrayList<>();
        StringTokenizer st = null;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                char ch = st.nextToken().charAt(0);
                if(ch=='X'){
                    map[i][j] = 0;
                    list.add(new int[]{i,j});
                }else if(ch=='S') map[i][j] = 1; //학생
                 else {
                     map[i][j] = 2; //선생
                     tArr.add(new int[]{i,j});
                 }
            }
        }

        sn = list.size();
        t = new int[3];
        flag= true;

        comb(0,0);

        if(flag) System.out.println("NO");
        else System.out.println("YES");
    }
}
