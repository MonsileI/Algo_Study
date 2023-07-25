package Algorithm_fourth_week_2023_07;

import java.util.*;
import java.io.*;
public class bj_1062_가르침_Gold_4 {
    static boolean []visited;
    static int answer;
    static String[]words;
    static int K,N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        words = new String[N];
        for(int i=0;i<N;i++) {
            String s = br.readLine();
            s = s.substring(4,s.length()-4);
            words[i] = s;
        }
        visited = new boolean[26];
        //antic
        visited['a'-97]=true; visited['n'-97]=true; visited['t'-97]=true; visited['i'-97]=true; visited['c'-97]=true;

        if(K<5) answer = 0;
        else if(K==26) answer = N;
        else{
            comb(0,0);
        }
        System.out.println(answer);
    }
    static void comb(int start,int depth){

        if(depth==K-5){
            int cnt = 0;
            for(int i=0;i<N;i++){
                boolean flag = true;
                String str = words[i];
                for(int j=0;j<str.length();j++){
                    int ch = str.charAt(j)-97;
                    if(!visited[ch]) {
                        flag = false;
                        break;
                    }
                }

                if(flag)cnt++;
            }
            answer=  Math.max(answer,cnt);
            return;
        }


        for(int i=start;i<26;i++){
            if(!visited[i]){
                visited[i] = true;
                comb(i+1,depth+1);
                visited[i] = false;
            }
        }
    }
}
