package May_Fourth.bj;

import java.util.*;
import java.io.*;

public class br_1969_DNA_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[]strArr = new String[N];
        //입력
        for(int i=0;i<N;i++) strArr[i] = br.readLine();
        String answer = "";
        //알파벳                                         //틀린 갯수
        String alphaStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; int answerNum = 0;

        //세로로 비교하면서 가장 많이 나온 문자열을 넣어준다.
        for(int j=0;j<M;j++) {
            //개수 비교 알파벳 배열
            int[]alpha = new int[26];
            for(int i=0;i<N;i++){
                char ch = strArr[i].charAt(j);
                alpha[ch-65]++;
            }
            int max = 0; int num = 0;
            for(int i=25;i>-1;i--){
                //어차피 뒤에서부터 앞쪽으로 들어오기 때문에 나중에 들어온 알파벳이 사전순으로 앞선 알파벳이다( <= 를 적절히 활용 )
                if(max<=alpha[i]) {
                    max = alpha[i] ; num = i;
                }
            }
            //가장 많이 나온 알파벳을 answer에 추가
            char ansCh = alphaStr.charAt(num);
            answer += ansCh;
            //다시 세로로 돌며 가장 많은 알파벳과 다른 알파벳이 있다면, answerNum을 증가시켜준다.
            for(int i=0;i<N;i++){
                char ch = strArr[i].charAt(j);
                if(ch!=ansCh) answerNum++;
            }

        }
        System.out.println(answer);
        System.out.println(answerNum);
    }
}
