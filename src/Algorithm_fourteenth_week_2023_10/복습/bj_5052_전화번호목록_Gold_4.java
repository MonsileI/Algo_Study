package Algorithm_fourteenth_week_2023_10.복습;

import java.util.*;
import java.io.*;
public class bj_5052_전화번호목록_Gold_4 {

    static class TrieNode {

        TrieNode(){};
        Map<Character,TrieNode> childNode = new HashMap<>();
        boolean check;

        public void make(String word){
            TrieNode trieNode = this;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                trieNode.childNode.putIfAbsent(ch,new TrieNode());
                trieNode = trieNode.childNode.get(ch);
                if(i==word.length()-1){
                    trieNode.check = true;
                    return;
                }
            }
        }
        public boolean contain(String word){
            TrieNode trieNode = this;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                TrieNode node = trieNode.childNode.get(ch);
                if(node==null) return false;
                trieNode = node;
            }
            if(trieNode.check) {
                if(trieNode.childNode.isEmpty()) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            TrieNode trieNode = new TrieNode();
            for(int i=0;i<N;i++){
                String str = br.readLine();
                list.add(str);
                trieNode.make(str);
            }
            boolean flag = true;
            for(String str : list){
                if(trieNode.contain(str)) {
                    sb.append("NO\n");
                    flag= false;
                    break;
                }
            }
            if(flag) sb.append("YES\n");
        }
        System.out.println(sb.toString());
    }
}
