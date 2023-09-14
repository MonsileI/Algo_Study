package Algorithm_eleventh_week_2023_09.bj;

import java.io.*;
import java.util.*;
public class bj_12892_생일선물_Gold_4 {
    static int N, arr[][];
    static int D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken()); //가격
            arr[i][1] = Integer.parseInt(st.nextToken()); //가치
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        //가격차이가 D이상 차이나면 안됨
        int L = 0;
        int R = 0;
        long slide = arr[0][1];
        int i =0;
        for(i=1;i<N;i++){
            if(D<=arr[i][0]-arr[0][0]) break;
            slide += arr[i][1];
        }
        R = i;
        long answer = slide;
        while(R<N && L<N){
            int temp = arr[R][0] - arr[L][0];

            if(D<=temp){
                slide -= arr[L++][1];
            }else{
                slide += arr[R++][1];
                answer = Math.max(answer,slide);
            }
        }
        System.out.println(answer);
    }
}
