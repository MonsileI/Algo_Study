package Algorithm_eighteenth_week_2023_11.복습;
import java.util.*;
import java.io.*;
public class bj_5052_전화번호목록_Gold_4 {

    static class TrieNode {

        public TrieNode() {}

        boolean check;

        Map<Character,TrieNode> childNode = new HashMap<>();

        public void insert(String str){
            TrieNode trieNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                trieNode.childNode.putIfAbsent(ch,new TrieNode());
                trieNode = trieNode.childNode.get(ch);
                if(i==str.length()-1){
                    trieNode.check = true;
                    return;
                }
            }
        }

        public boolean isContains(String str){
            TrieNode trieNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                TrieNode nowNode = trieNode.childNode.get(ch);
                if(nowNode.childNode.isEmpty()) return false;
                trieNode = nowNode;
            }

            if(trieNode.check){
                if(trieNode.childNode.isEmpty()) return false;
            }

            return true;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            List<String >list = new ArrayList<>();
            TrieNode trieNode = new TrieNode();
            for(int i=0;i<N;i++){
                String str = br.readLine();
                list.add(str);
                trieNode.insert(str);
            }
            boolean flag = true;
            for(String str : list){
                if(trieNode.isContains(str)){
                    flag= false;
                    break;
                }
            }
            if(flag) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb.toString());
    }
}
