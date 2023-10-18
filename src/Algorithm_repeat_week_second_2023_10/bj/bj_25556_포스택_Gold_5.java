package Algorithm_repeat_week_second_2023_10.bj;

import java.util.*;
import java.io.*;
public class bj_25556_포스택_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> f = new Stack<>();
        Stack<Integer> s = new Stack<>();
        Stack<Integer> t = new Stack<>();
        Stack<Integer> fo = new Stack<>();
        f.push(0); s.push(0); t.push(0); fo.push(0);

        StringTokenizer st=  new StringTokenizer(br.readLine());
        boolean flag = true;
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(f.peek()<num) {
                f.push(num);
                continue;
            }
            if(s.peek()<num){

                s.push(num);
                continue;
            }
            if(t.peek()<num){

                t.push(num);
                continue;
            }
            if(fo.peek()<num){

                fo.push(num);
                continue;
            }
            flag = false;
            break;
        }
        System.out.println(flag ? "YES" : "NO");
    }
}
