package Algorithm_eleventh_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_24954_물약구매_Silver_1 {
    static int N;
    static int answer = Integer.MAX_VALUE;
    static int []arr;
    static int[]tmp;
    static List<List<int[]>> list;
    static boolean[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tmp = new int[N];
        arr= new int[N];
        visited = new boolean[N];
        list = new ArrayList();
        for(int i=0;i<N;i++) list.add(new ArrayList<>());
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            int M = Integer.parseInt(br.readLine());
            for(int j =0;j<M;j++){
                st = new StringTokenizer(br.readLine()," ");
                int num = Integer.parseInt(st.nextToken())-1;
                int price = Integer.parseInt(st.nextToken());
                list.get(i).add(new int[]{num,price});
            }
        }
        perm(0);
        System.out.println(answer);
    }
    static void calc(){

        int sum = 0;
        int[]tempArr = new int[N];
        for(int i=0;i<N;i++) tempArr[i] = arr[i];

        for(int i=0;i<N;i++){
            sum += tempArr[tmp[i]];
            if(answer<=sum) return;
            for(int [] check : list.get(tmp[i])){
                int num =check[0];
                int price = check[1];
                tempArr[num] -= price;
                if(tempArr[num]<1) tempArr[num] = 1;
            }
        }
        answer = Math.min(answer,sum);
    }
    static void perm(int depth){

        if(depth==N){
            calc();
            return;
        }


        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = i;
                perm(depth+1);
                visited[i] = false;
            }
        }

    }
}
