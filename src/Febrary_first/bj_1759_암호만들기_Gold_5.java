package Febrary_first;

import java.util.*;
import java.io.*;
public class bj_1759_암호만들기_Gold_5 {

    static char[]ch;
    static char[]tmp;
    static int L,C;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ch = new char[C];
        tmp = new char[L];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<C;i++) ch[i] = st.nextToken().charAt(0);
        Arrays.sort(ch);
        comb(0,0);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(String str : list) sb.append(str).append("\n");
        System.out.println(sb.toString());
    }

    static void comb(int start,int depth){

        if(depth==L){
            String str = "";
            for(int i=0;i<L;i++) str += tmp[i];
            list.add(str);
            return;
        }

        for(int i=start; i<C;i++){
            tmp[depth] = ch[i];
            comb(i+1,depth+1);
        }
    }
}
