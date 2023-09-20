package Algorithm_twelveth_week_2023_09.복습;

import java.util.*;
import java.io.*;

public class bj_5052_전화번호목록_Gold_4 {

    static class TrieNode{
        TrieNode(){}

        Map<Character,TrieNode> childNode = new HashMap<>();
        boolean terminal;

        public void insert(String word){
            TrieNode trieNode = this;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                trieNode.childNode.putIfAbsent(c,new TrieNode());
                trieNode = trieNode.childNode.get(c);
                if(i==word.length()-1){
                    trieNode.terminal= true;
                    return;
                }
            }
        }
        public boolean contain(String word){
            TrieNode trieNode = this;
            for(int i=0;i< word.length();i++){
                char c = word.charAt(i);
                TrieNode node = trieNode.childNode.get(c);
                if(node==null) return false;
                trieNode = node;
            }
            if(trieNode.terminal) if(trieNode.childNode.isEmpty()) return false;

            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            TrieNode trieNode = new TrieNode();
            boolean check = true;
            List<String> list = new ArrayList<>();
            for(int j=0;j<N;j++){
                String word = br.readLine();
                trieNode.insert(word);
                list.add(word);
            }
            for(String key : list){
                if(trieNode.contain(key)){
                    check = false;
                    break;
                }
            }
            sb.append(check?"YES":"NO").append("\n");
        }
        System.out.println(sb.toString());
    }
}
