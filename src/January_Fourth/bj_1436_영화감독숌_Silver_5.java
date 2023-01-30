package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_1436_영화감독숌_Silver_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;
        int N = Integer.parseInt(br.readLine());
        int number = 0;

        while (N > 0) {
            number++;
            String s = Integer.toString(number);

            if (s.contains("666")) {
                N--;
            }
        }

        System.out.println(number);

    }
}
