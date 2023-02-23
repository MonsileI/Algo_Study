package Febrary_third;

import java.util.*;
import java.io.*;
public class pr_택배배달과수거하기_Level_2 {
    public static void main(String[] args) throws Exception {

        int cap = 2; int n = 7  ;
        int []delivers = {1, 0, 2, 0, 1, 0, 2};
        int []pickups = {0, 2, 0, 1, 0, 2, 0};
        int answer = 0;
        int cnt = 0;
        for(int i=0;i<delivers.length;i++) if(delivers[i]!=0) cnt++;
        for(int i=0;i<pickups.length;i++) if(pickups[i]!=0) cnt++;

        while(true){

            int power = cap;
            //가자
            boolean flag = true;
            int idx = n-1;
            for(int i=idx;i>-1;i--){
                if(delivers[i]!=0) {
                    if(flag) {
                        flag = false;
                        answer += i+i+2;
                    }
                    if(power - delivers[i] > -1) {
                        power -= delivers[i];
                        delivers[i] = 0;
                        cnt--;
                    }else{
                        delivers[i] -= power;
                        break;
                    }
                }
            }
            //오자
            power = cap;
            for(int i=idx;i>-1;i--){
                if(pickups[i]!=0) {
                    if(flag){
                        flag = false;
                        answer += i + i+2;
                    }
                    if(power - pickups[i] > -1) {
                        power -= pickups[i];
                        pickups[i] = 0;
                        cnt--;
                    }else{
                        pickups[i] -= power;
                        break;
                    }
                }
            }
            if(cnt==0) break;
        }
        System.out.println(answer);

    }
}
