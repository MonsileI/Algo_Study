package Febrary_second;

import java.util.*;
import java.io.*;
public class bj_18310_안테나_Silver_3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[num];

        for (int i = 0; i < num; i++)  arr[i] = Integer.parseInt(st.nextToken(" "));

        Arrays.sort(arr);

        if(num % 2 ==0) System.out.println(arr[num/2-1]);
        else System.out.println(arr[num/2]);

    }
}
