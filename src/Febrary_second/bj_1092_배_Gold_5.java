package Febrary_second;

import java.util.*;
import java.io.*;
public class bj_1092_배_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[]crains = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) crains[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        Integer[]boxes = new Integer[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++) boxes[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(crains,(o1,o2) -> o2-o1);
        Arrays.sort(boxes,(o1,o2) -> o2-o1);

        System.out.println(Arrays.toString(crains));
        System.out.println(Arrays.toString(boxes));
    }
}
