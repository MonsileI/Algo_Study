package Algorithm_seventh_week_2023_08.gr;

import java.util.*;
import java.io.*;

public class gr_폴더폰자판_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]strArr = {"","1.,?!","2ABC","3DEF","4GHI","5JKL","6MNO","7PQRS","8TUV","9WXYZ"};
        int N = Integer.parseInt(br.readLine());
        int num = 0;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        for(int i=0;i<N;i++){
            int now = Integer.parseInt(str.charAt(i)+"");
            if(num==0||num==now) {
                num = now;
                cnt++;
            }
            else{
                int size = ((cnt-1)%(strArr[num].length()));
                sb.append(strArr[num].charAt(size));
                num = now;
                cnt = 1;
            }
        }
        if(num!=0){
            int size = ((cnt-1)%(strArr[num].length()));
            sb.append(strArr[num].charAt(size));
        }
        System.out.println(sb.toString());
    }
}
