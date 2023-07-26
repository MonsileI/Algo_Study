package Algorithm_fourth_week_2023_07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj_16139_인간컴퓨터상호작용_Silver_1_re {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int size =str.length();
        StringBuilder sb = new StringBuilder();
        int[][]arr = new int[size][26];
        arr[0][str.charAt(0)-'a']++;
        for(int i=1;i<size;i++){
            int idx = str.charAt(i)-'a';
            arr[i][idx] = arr[i-1][idx]+1;
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<size;j++){
                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }
    }
}
