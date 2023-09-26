package Algorithm_eleventh_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_29792_규칙적인보스돌_Gold_5 {
    static int K,M;
    static int [] arr;
    static int[][]mons;
    static boolean[]visited;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]tmp = new int[N];
        for(int i=0;i<N;i++) tmp[i] = Integer.parseInt(br.readLine());
        Arrays.sort(tmp);
        arr = new int[M];
        for(int i=0;i<M;i++) arr[i] = tmp[N-1-i];
        mons = new int[K][2];
        int L = 0; int R = 0;
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine()," ");
            mons[i][0] =  Integer.parseInt(st.nextToken());
            mons[i][1] =  Integer.parseInt(st.nextToken());
            R += mons[i][1];
        }
        visited = new boolean[N];
        perm(0,new int[K]);
        /*while(L<R){
            int mid = (L+R)/2;

            if(calc(mid)){
                L = mid+1;
            }else{
                R = mid;
            }
            break;
        }*/
        for(int [] i : list) System.out.println(Arrays.toString(i));
        System.out.println(L-1);
    }
    static void perm(int depth,int[]arr){
        if(depth==K){
            list.add(arr);
            return;
        }
        for(int i=0;i<K;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                perm(depth+1,arr);
                arr[depth] = 0;
                visited[i] = false;
            }
        }
    }

}
