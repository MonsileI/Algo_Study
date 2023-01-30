package January_Fifth;

import java.io.*;
import java.util.*;
public class bj_1620_나는야포켓몬마스터이다솜_Silver_4 {


    public static void main(String[] args) throws Exception{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        Map<String,String> map = new HashMap<>();
        for(int i=1;i<N+1;i++) {
            String mon = br.readLine();
            map.put(String.valueOf(i),mon);
            map.put(mon,String.valueOf(i));
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++){
            String question = br.readLine();
            sb.append(map.get(question)).append("\n");
        }

        System.out.println(sb.toString());


    }
}
