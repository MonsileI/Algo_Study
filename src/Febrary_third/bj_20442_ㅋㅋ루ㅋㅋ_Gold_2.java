package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_20442_ㅋㅋ루ㅋㅋ_Gold_2 {

    public static void main(String[] args) throws Exception {

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        char[]RU= br.readLine().toCharArray();
        int size = RU.length;
        int answer = 0;

        int L = 0;
        boolean flag = true;
        int R = size-1;
        //R로 초기화
        for(int i=0;i<size;i++) {

            if(RU[i]=='R') answer++;
            else {
                if(flag) {
                    L = i;
                    flag = false;
                }
                if(R<i) R = i;
            }
        }
        //R양옆에 K가 대칭으로 붙는지 확인

        int tmp = 0;

        while(L<=R) {

            if(L==R){
                if(RU[L]==RU[R]) tmp++;
                break;
            }
            if(RU[L]==RU[R]){
                tmp += 2;
                L++ ; R--;
            }else{
                if(RU[L]=='K') L++;
                else R--; //R이 'R'이라는 의미니까 --
            }
        }

        answer = Math.max(answer,tmp);
        System.out.println(answer);

    }
}

