package Febrary_third;

import java.util.*;
import java.io.*;
public class bj_10942_팰린드롬_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int q=0;q<Q;q++){

            st = new StringTokenizer(br.readLine()," ");
            int S = Integer.parseInt(st.nextToken())-1;
            int E = Integer.parseInt(st.nextToken())-1;
            int size = E-S+1;
            int [] tmp = new int[size];
            int idx = 0;
            for(int i=S;i<=E;i++) tmp[idx++] = arr[i];
            Stack<Integer> stack = new Stack<>();
            Arrays.sort(tmp);

            for(int i=0;i<size;i++){
                int num = tmp[i];
                if(!stack.isEmpty()){
                    if(stack.peek()==num) stack.pop();
                    else stack.add(num);
                }else stack.add(num);
            }

            if(size%2==0){
                if(stack.isEmpty())sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }else{
                if(stack.size()%2==1)sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }

        }
        System.out.println(sb.toString());
    }
}
