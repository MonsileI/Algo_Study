package Algorithm_seventeenth_week_2023_11.bj;
import java.util.*;
import java.io.*;
public class bj_25601_자바의형변환_Silver_1 {
    static Map<String,List<String>> map;
    static String son;
    static boolean ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        map = new HashMap<>();
        for(int i=0;i<N-1;i++){
            st =new StringTokenizer(br.readLine()," ");
            String a = st.nextToken();
            String b = st.nextToken();
            if(!map.containsKey(b)) map.put(b,new ArrayList<>());
            map.get(b).add(a);
        }
        st = new StringTokenizer(br.readLine()," ");
        String a = st.nextToken(); son = st.nextToken();
        check(a);
        if(!ans){
            String tmp = son;
            son = a;
            a = tmp;
            check(a);
        }
        System.out.println(ans ? 1 : 0);
    }
    static void check(String a){
        if(!map.containsKey(a)) return;
        for(String str : map.get(a)){
            if(str.equals(son)) {
                ans = true;
                return;
            }
            check(str);
        }
    }
}
