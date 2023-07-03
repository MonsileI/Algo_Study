package Jun_third.bj;

import java.util.*;
import java.io.*;

public class bj_20920_영단어암기는어려워_Silver_3 {

    static class Word implements Comparable<Word>{
        int cnt; String word;

        public Word(String word,int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o) {
            return cnt == o.cnt ? word.length() == o.word.length() ? word.compareTo(o.word) : -(word.length() - o.word.length()) : -(cnt - o.cnt);
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<N;i++){
            String w = br.readLine();
            if(map.containsKey(w)){
                map.put(w,map.getOrDefault(w,0)+1);
                continue;
            }else{
                if(M<=w.length()) map.put(w,1);
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = map.size();
        Word[]answer = new Word[size];
        int idx = 0;
        for(String key : map.keySet()) answer[idx++] = new Word(key,map.get(key));
        Arrays.sort(answer);
        for(int i=0;i<size;i++) sb.append(answer[i].word).append("\n");
        System.out.println(sb.toString());
    }
}
