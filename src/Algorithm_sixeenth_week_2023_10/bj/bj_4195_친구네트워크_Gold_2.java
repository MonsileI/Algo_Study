package Algorithm_sixeenth_week_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_4195_친구네트워크_Gold_2 {
    static int[]level;
    static int[]parents;
    static Map<String,Integer> map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            parents = new int[N*2];
            level = new int[N*2];
            map = new HashMap<>();
            for(int i=0;i<N*2;i++){
                parents[i] = i;
                level[i] = 1;
            }
            int idx = 0;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                String a = st.nextToken();
                String b = st.nextToken();
                if(!map.containsKey(a)) map.put(a,idx++);
                if(!map.containsKey(b)) map.put(b,idx++);
                sb.append(union(map.get(a),map.get(b))+"\n");
            }
        }
        System.out.println(sb.toString());
    }
    static int union(int a,int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA!=rootB){
            parents[rootB] = rootA;
            level[rootA] += level[rootB];
            level[rootB] = 1;
        }
        return level[rootA];
    }
    static int find(int num){
        if(parents[num]==num) return num;
        return parents[num] = find(parents[num]);
    }
}
