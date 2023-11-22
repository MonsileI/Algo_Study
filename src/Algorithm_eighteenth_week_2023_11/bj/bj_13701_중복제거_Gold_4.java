package Algorithm_eighteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_13701_중복제거_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,Integer> map = new HashMap<>();
        StringBuilder sb= new StringBuilder();
        String[]tmp = br.readLine().split(" ");
        int size = tmp.length;
        for(int i=0;i<size;i++){
            int num = Integer.parseInt(tmp[i]);
            if(!map.containsKey(num)){
                map.put(num,0);
                sb.append(num+" ");
            }
        }
        System.out.println(sb.toString());
    }
}
