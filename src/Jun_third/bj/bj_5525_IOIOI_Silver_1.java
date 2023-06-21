package Jun_third.bj;

import java.util.*;
import java.io.*;
public class bj_5525_IOIOI_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); int len = Integer.parseInt(br.readLine());
        int nSize =1;
        for(int i=0;i<N;i++) nSize +=2;
        String check = br.readLine();
        int answer = 0;
        int size = check.length();
        boolean flag = false; //O라는 표시 I는 true, O는 false
        int cnt = 0;
        for(int i=0;i<size;i++){
            char ch = check.charAt(i);
           //'I'일 때
            if(flag){
                //O이면 IO완성, flag 바꿔줌
                if(ch=='O'){ flag = !flag; cnt++;}
                else{
                   //지금까지 cnt를 N으로 나눈값이 answer에 +됨
                    if(nSize<=cnt) answer += ((cnt - nSize) / 2) + 1;
                    cnt = 1;
                   //flag는 true로 유지
               }
           //'O'일 때,
           }else{
                //I이면 계속 실행
                if(ch=='I') {flag= !flag; cnt++;}
               else{
                   //O일때 O이면 IOO이런식이니까 현재인 IO'O'에서 
                    cnt--; //이전의 cnt를 뺀 값인 I로 끝나는 값까지만 계산
                    if(nSize<=cnt) answer += ((cnt - nSize) / 2) + 1;
                    cnt = 0; //'O'로 시작할 수 없으니 cnt는 0
                    flag = false; //flag는 처음처럼 바꿔준다.
                }
           }
        }
        if(nSize<=cnt) answer += ((cnt - nSize) / 2) + 1;
        System.out.println(answer);


    }
}
