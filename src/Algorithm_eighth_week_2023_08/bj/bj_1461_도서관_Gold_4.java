package Algorithm_eighth_week_2023_08.bj;

import java.util.*;
import java.io.*;
public class bj_1461_도서관_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int start = arr[0];
        int cnt = 1;
        //마지막으로 들릴 애는 다시 돌아오지 않아도 됨
        int answer = 0;
        for(int i=1;i<N;i++){
           if(start==0) start = arr[i];
            cnt++;
            //cnt가 다 차거나, arr[i]가 +나 -로 바뀌는 순간
            if((start*arr[i])<0){
                answer += Math.abs(start*2);
                start = arr[i];
                cnt = 1;
            }
            else if(cnt==M){
                if(0<start) start = arr[i]; //+면 가장 큰값을 더해줘야함
                answer += Math.abs(start)*2;
                start = 0;
                cnt= 0;
            }
        }
        //다 돌았는데 start가 남아있다는건? 해결해줘야한다는거임
        answer += Math.abs(start)*2;
        answer -= Math.max(Math.abs(arr[0]),Math.abs(arr[N-1]));
        //마지막으로 들릴 애는 다시 돌아오지 않아도 됨

        int secAnswer = 0;
        start = arr[0];
        cnt = 1;
        for(int i=1;i<N;i++){
            if(start==0) start = arr[i];
            cnt++;
            //cnt가 다 차거나, arr[i]가 +나 -로 바뀌는 순간
            if(cnt==M){
                if(0<start) start = arr[i]; //+면 가장 큰값을 더해줘야함
                if(start*arr[i]<0){
                    secAnswer += Math.abs(start)*2;
                    secAnswer += arr[i]*2;
                }else{
                    secAnswer += Math.abs(start)*2;
                }
                start = 0;
                cnt= 0;
            }
        }
        secAnswer += Math.abs(start)*2;
        secAnswer -= Math.max(Math.abs(arr[0]),Math.abs(arr[N-1]));

        System.out.println(Math.min(answer,secAnswer));

    }
}
