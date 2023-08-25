package Algorithm_eighth_week_2023_08.st;

import java.util.*;
import java.io.*;
public class st_강의실배정_Level_3 {

    static class Lec implements Comparable<Lec>{
        int start ; int end;

        public Lec(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lec o) {
            return end - o.end;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Lec[]arr = new Lec[N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new Lec(s,e);
        }
        Arrays.sort(arr);

        int answer = 1;
        int end = arr[0].end;
        for(int i=1;i<N;i++){
            if(end<=arr[i].start){
                answer++;
                end = arr[i].end;
            }
        }

        System.out.println(answer);

    }
}
