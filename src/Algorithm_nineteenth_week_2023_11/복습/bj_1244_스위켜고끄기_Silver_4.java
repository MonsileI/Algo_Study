    package Algorithm_nineteenth_week_2023_11.복습;
    import java.util.*;
    import java.io.*;
    public class bj_1244_스위켜고끄기_Silver_4 {
        public static void main(String[] args) throws Exception{
            BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            boolean[]arr=  new boolean[N+1];
            for(int i=1;i<N+1;i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = (num == 1) ? true : false;
            }
            int M  =Integer.parseInt(br.readLine());
            for(int o=0;o<M;o++){
                st = new StringTokenizer(br.readLine()," ");
                int gen = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                if(gen==1){
                    for(int i=num;i<N+1;i += num)  arr[i] = !arr[i];
                }else{
                    int L = num-1; int R = num+1;

                    while(L>=1 && R <N+1){

                        if(arr[L]!=arr[R]) break;
                        L--; R++;
                    }
                    L++; R--;
                    for(int i=L;i<=R;i++) arr[i] = !arr[i];
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=1;i<N+1;i++) {
                sb.append(arr[i] ? "1 " : "0 ");
                if(i%20==0) sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }
