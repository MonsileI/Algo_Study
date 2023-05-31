package May_Fifth.bj;

import java.util.*;
import java.io.*;
public class bj_1764_듣보잡_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();
        for(int i=0;i<N;i++) list.add(br.readLine());
        List<String> answerList = new ArrayList<>();
        for(int i=0;i<M;i++) {
            String str = br.readLine();
            if(list.contains(str)) answerList.add(str);
        }
        Collections.sort(answerList);
        StringBuilder sb = new StringBuilder();
        sb.append(answerList.size()).append("\n");
        for(String str : answerList) sb.append(str).append("\n");
        System.out.println(sb.toString());
    }
}
