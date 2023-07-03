package January_Fourth;

import java.io.*;
import java.util.*;

public class bj_1439_뒤집기_Silver_5 {
    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int size = str.length();
        int zero =0; int one =0;
        if(str.charAt(0)=='0') one++;
        else zero++;
        for(int i=1;i<size;i++){
            char ch = str.charAt(i);
            char before = str.charAt(i-1);
            if(ch!=before){
                if(ch!='0') zero++;
                else one++;
            }
        }
        System.out.println(Math.min(zero,one));
    }
}
