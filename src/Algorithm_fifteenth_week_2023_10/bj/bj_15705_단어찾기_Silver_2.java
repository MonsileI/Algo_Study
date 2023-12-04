package Algorithm_fifteenth_week_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_15705_단어찾기_Silver_2 {
    static char[] check;
    static int N,M;
    static char[][]map;
    static int len;
    static int answer;
    static boolean flag;
    static int[][]move ={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        check = br.readLine().toCharArray();
        len = check.length;
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int l=0;l<8;l++){
                    dfs(i,j,0,l);
                }
            }
        }
        System.out.println(answer);
    }
    static void dfs(int i,int j,int depth, int dir){
        if(flag) return;
        if(map[i][j]!=check[depth]) return;
        if(depth==len-1) {
            answer++;
            flag = true;
            return;
        }

        int ni = i + move[dir][0]; int nj = j + move[dir][1];
        if(ni<0||nj<0||N-1<ni||M-1<nj) return;
        dfs(ni,nj,depth+1,dir);

    }


}
