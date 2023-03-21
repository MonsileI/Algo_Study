package March_Second;

import java.util.*;
import java.io.*;
public class bj_17086_아기상어_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][]map = new int[N][M];

        List<int[]>sharks = new ArrayList<>();
        List<int[]>others = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1)sharks.add(new int[]{i,j});
                else others.add(new int[]{i,j});
            }
        }

        int sSize = sharks.size();
        int oSize = others.size();
        int answer = 0;

        for(int i=0;i<oSize;i++){
            int tmp = 987654321;

            for(int j=0;j<sSize;j++){
                int check = Math.abs(sharks.get(j)[0] - others.get(i)[0]);
                check = Math.max(check,Math.abs(sharks.get(j)[1] - others.get(i)[1]));
                tmp = Math.min(tmp,check);
            }
            answer = Math.max(tmp,answer);
        }

        System.out.println(answer);
    }
}
