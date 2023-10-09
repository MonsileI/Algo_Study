package Algorithm_repeat_week_first_2023_10.bj;
import java.util.*;
import java.io.*;
public class bj_1931_회의실배정_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st=  null;
        int[][] con = new int[N][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            con[i][0] = Integer.parseInt(st.nextToken());
            con[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(con,(o1,o2)-> o1[1]==o2[1] ? o1[0]- o2[0] : o1[1] - o2[1]);
        int ans = 1;
        int end = con[0][1];
        for(int i=1;i<N;i++){
            if(end<=con[i][0]){
                ans++;
                end = con[i][1];
            }
        }
        System.out.println(ans);
    }
}
