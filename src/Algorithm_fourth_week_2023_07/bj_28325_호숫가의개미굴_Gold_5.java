package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_28325_호숫가의개미굴_Gold_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        int answer = 0;
        boolean[]check= new boolean[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]!=0) {
                answer += arr[i];
                //여기서 check 가 true것은 반드시 선택을 안한다는 것
                check[i] = true;
            }
        }

        if(N==1) {
            if (answer != 0) {
                answer++;
            }
        }else if(N==2){
                if(check[0] && !check[1]) answer++;
                else if(!check[0] && !check[1]) answer++;
        }else if(answer==0){
            answer = N/2;
        }
        else{
                for(int i=0;i<N;i++){
                    if(check[i]) continue;
                    if(i==0){
                        if(check[N-1]&&check[i+1])answer++;
                        else if(check[N-1]||check[i+1])check[i] = true;
                        else if(!check[N-1]&&!check[i+1]) check[i] = true;
                    }else if(i==N-1){
                        if(check[i-1]&&check[0])answer++;
                        else if(check[i-1]||check[0])check[i] = true;
                        else if(!check[i-1]&&!check[0]) check[i] = true;
                    }else{
                        if(check[i-1]&&check[i+1])answer++;
                        else if(check[i-1]||check[i+1])check[i] = true;
                        else if(!check[i-1]&&!check[i+1]) check[i] = true;
                    }
                }
        }
        System.out.println(answer);
    }
}
