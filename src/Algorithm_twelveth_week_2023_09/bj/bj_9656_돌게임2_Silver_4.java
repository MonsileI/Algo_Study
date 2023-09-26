package Algorithm_twelveth_week_2023_09.bj;

import java.util.*;
import java.io.*;

public class bj_9656_돌게임2_Silver_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N%2==0) System.out.println("SK");
        else System.out.println("CY");
    }

}
