package Febrary_second;

import java.util.*;
import java.io.*;
public class bj_2864_5와6의차이_Bronze_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        //가장 큰건 6
        //가장 작은건 다 5

        String sFir = String.valueOf(first);
        String sSec = String.valueOf(second);

        String minf = "";
        String mins = "";
        String maxf = "";
        String maxs = "";

        for(int i=0;i<sFir.length();i++){
            char ch = sFir.charAt(i);
            if(ch=='6') {
                minf += '5';
                maxf += '6';
            }
            else if(ch=='5'){
                minf += '5';
                maxf += '6';
            }else{
                minf += ch;
                maxf += ch;
            }
        }
        for(int i=0;i<sSec.length();i++) {
            char ch = sSec.charAt(i);
            if (ch == '6') {
                mins += '5';
                maxs += '6';
            } else if (ch == '5') {
                mins += '5';
                maxs += '6';
            } else {
                mins += ch;
                maxs += ch;
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(Integer.parseInt(minf)+Integer.parseInt(mins)).append(" ");
        sb.append(Integer.parseInt(maxf)+Integer.parseInt(maxs));

            System.out.println(sb.toString());
    }
}