package Algorithm_fourth_week_2023_07;

import java.io.*;
import java.util.*;
public class bj_1713_후보추천하기_Silver_1 {

    static class Node implements Comparable<Node>{
        int num,cnt,time;

        public Node(int num, int cnt, int time) {
            this.num = num;
            this.cnt = cnt;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return cnt==o.cnt ? time - o.time : cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[]arr = new int[101];
        List<Node> list = new ArrayList<>();

        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            if(arr[num]>0){
                arr[num]++;
                for(int j=0;j<list.size();j++){
                    if(list.get(j).num==num){
                        list.get(j).cnt++;
                        break;
                    }
                }
            }else{
                if(list.size()>=N){
                    Collections.sort(list);
                    int n = list.get(0).num;
                    arr[n] = 0;
                    list.remove(0);
                }
                list.add(new Node(num,0,i));
                arr[num] = 1;
            }
        }
        for(int i=1;i<101;i++) if(arr[i]!=0) System.out.print(i+" ");


    }
}
