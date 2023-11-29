package Algorithm_nineteenth_week_2023_11.swea;
import java.util.*;
import java.io.*;
public class Solution_19003_팰린드롬문제_D3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int t=1;t<=TC;t++){
            int ans = 0;
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            List<String> list = new ArrayList<>();
            boolean flag = false;
            for(int i=0;i<N;i++){
                String str = br.readLine();
                if(check(str))  flag = true;
                else list.add(str);
            }
            if(flag) ans += M;
            int size = list.size();
            boolean[]check = new boolean[size];
            for(int i=0;i<size-1;i++){
                if(check[i]) continue;
                for(int j=i+1;j<size;j++){
                    if(check[j]) continue;
                    if(check(list.get(i)+list.get(j))) {
                        ans += (M*2);
                        check[i] = true; check[j] = true;
                    }
                }
            }
            sb.append("#"+t+" "+ans+"\n");
        }
        System.out.println(sb.toString());
    }
    static boolean check(String str) {
        int L = 0; int R = str.length()-1;
        while(L<=R) {
            char f = str.charAt(L); char s = str.charAt(R);
            if(f!=s) return false;
            L++; R--;
        }
        return true;
    }
}
