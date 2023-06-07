package Jun_First.bj;

import java.util.*;
import java.io.*;
public class bj_1972_놀라운문자열_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> list = null;
        OuterLoop:
        while(true){
            String str = br.readLine();
            if(str.equals("*")) break;
            int size = str.length();
            int idx = 1;
            while(idx<size){
                list = new ArrayList<>();
                for(int i=0;i<size-idx;i++){
                    String check = ""+str.charAt(i)+str.charAt(i+idx);
                    if(list.contains(check)) {
                        sb.append(str+" is NOT surprising.").append("\n");
                        continue OuterLoop;
                    }
                    list.add(check);
                }
                idx++;
           }
            sb.append(str+" is surprising.").append("\n");
        }
        System.out.println(sb.toString());
    }

}
