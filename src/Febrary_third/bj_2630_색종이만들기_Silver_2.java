    package Febrary_third;

    import java.util.*;
    import java.io.*;
    public class bj_2630_색종이만들기_Silver_2 {

        static int N;
        static int[][]map;
        static int []check;

        public static void main(String[] args)throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            check= new int[2];
            StringTokenizer st = null;

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }



            dfs(N,0,0,map[0][0]);


            System.out.println(check[0]+"\n"+check[1]);


        }

        static void dfs(int size,int y,int x,int color){

            if(size==1) {
                check[color]++;
                return;
            }
            boolean flag = false;

            Loop:
            for(int i=y;i<size+y;i++){
                for(int j=x;j<size+x;j++){
                    if(map[i][j]!=map[y][x]){
                        flag = true;
                        break Loop;
                    }
                }
            }

            if(!flag){
                check[color]++;
                return;
            }else{

                dfs(size/2,y,x,map[y][x]);
                dfs(size/2,y+size/2,x,map[y+size/2][x]);
                dfs(size/2,y,x+size/2,map[y][x+size/2]);
                dfs(size/2,y+size/2,x+size/2,map[y+size/2][x+size/2]);

            }
        }
    }
