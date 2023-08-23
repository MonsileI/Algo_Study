package Algorithm_fifth_week_2023_07.bj;
import java.util.*;
import java.io.*;
public class bj_9656_돌게임2_Silver_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String answer = "";
        if(N==4) answer = "SK";
        else{
            if(N%2==0) answer = "CY";
            else answer = "SK";
        }
        System.out.println(answer);
    }
}
