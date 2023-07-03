package Jun_First.bj;

import java.util.*;
import java.io.*;
public class bj_12891_DNA비밀번호_Silver_2 {

    static int[]check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        String str = br.readLine();
        for(int i=0;i<N;i++) arr[i] = str.charAt(i) - 65;
        check = new int[20];
        st = new StringTokenizer(br.readLine()," ");
        //A C G T
        check[0] = Integer.parseInt(st.nextToken());
        check[2] = Integer.parseInt(st.nextToken());
        check[6] = Integer.parseInt(st.nextToken());
        check[19] = Integer.parseInt(st.nextToken());

        int answer = 0;
        int [] tmp = new int[20];
        for(int i=0;i<M;i++){
            int alpha = arr[i];
            if(alpha==0 || alpha==2|| alpha==6 || alpha==19) tmp[alpha]++;
        }
        answer = check(tmp);

        for(int i=0;i<N-M;i++){
            int alpha = arr[i];
            if(alpha==0 || alpha==2|| alpha==6 || alpha==19)  tmp[alpha]--;
            alpha = arr[i+M];
            if(alpha==0 || alpha==2|| alpha==6 || alpha==19)  tmp[alpha]++;
            answer += check(tmp);
        }
        System.out.println(answer);
    }
    static int check(int[]tmp){
        if(tmp[0]<check[0]) return 0;
        if(tmp[2]<check[2]) return 0;
        if(tmp[6]<check[6]) return 0;
        if(tmp[19]<check[19]) return 0;
        return 1;
    }
}
