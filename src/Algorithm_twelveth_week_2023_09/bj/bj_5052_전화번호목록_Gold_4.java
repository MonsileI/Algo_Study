package Algorithm_twelveth_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_5052_전화번호목록_Gold_4 {

    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean terminal;

        TrieNode() {

        }

        public void insert(String word) {
            TrieNode trieNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                trieNode.childNode.putIfAbsent(c, new TrieNode());
                trieNode = trieNode.childNode.get(c);

                if (i == word.length() - 1) {
                    trieNode.terminal = true;
                    return;
                }
            }
        }
        public boolean contains(String word){
            TrieNode triedNode = this;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                TrieNode node = triedNode.childNode.get(c);

                if(node==null){
                    return false;
                }
                triedNode = node;
            }
            if(triedNode.terminal){
                if(triedNode.childNode.isEmpty()){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TC; t++) {
            int n = Integer.parseInt(br.readLine());
            TrieNode trie = new TrieNode();
            boolean isConsistent = true;
            List<String> keyList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String str = br.readLine();
                trie.insert(str);
                keyList.add(str);
            }
            for (String key : keyList) {
                if (trie.contains(key)) {
                    isConsistent = false;
                    break;
                }
            }
            sb.append(isConsistent ? "YES" : "NO").append("\n");
        }
        System.out.println(sb.toString());
    }
}