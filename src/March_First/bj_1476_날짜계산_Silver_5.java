package March_First;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1476_날짜계산_Silver_5 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int answer =1;

        int E = Integer.parseInt(st.nextToken()); //15
        int S = Integer.parseInt(st.nextToken()); //28
        int M = Integer.parseInt(st.nextToken()); //19

        int e=1;int s=1;int m=1;

        while(true){

            if(e==16) e=1;
            if(s==29) s=1;
            if(m==20) m=1;

            if(E==e && S==s && M==m) break;


            e++;
            s++;
            m++;
            answer++;

        }

        System.out.println(answer);



    }
}
