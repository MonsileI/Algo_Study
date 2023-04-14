package April_Second;

import java.util.*;
import java.io.*;
public class bj_1092_배_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]crane = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) crane[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[]box = new int[M];
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++) box[i] = Integer.parseInt(st.nextToken());
        int answer = 0;
        Arrays.sort(crane);
        Arrays.sort(box);

        while(true){

            for(int i=N-1;i>-1;i--){
                
            }

        }

    }
}
