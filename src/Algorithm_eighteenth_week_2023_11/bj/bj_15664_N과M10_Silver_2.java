package Algorithm_eighteenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_15664_N과M10_Silver_2 {
    static int N,M,arr[];
    static Set<String>set;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        set = new HashSet<>();
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        comb(0,0,""); //depth, start;
        System.out.println(sb.toString());
    }
    static void comb(int depth,int start,String str){
        if(depth==M){
            if(!set.contains(str)){
                set.add(str);
                sb.append(str.substring(1,str.length())+"\n");
            }
            return;
        }
        for(int i=start;i<N;i++){
            comb(depth+1,i+1,str+" "+arr[i]);
        }
    }
}
