package January_Fifth;

import java.util.*;
import java.io.*;

public class bj_1966_프린터큐_Silver_3 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int N =0; int M=0;
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken()); //문서갯수
            M = Integer.parseInt(st.nextToken()); //몇번째 문서가 궁금?
            int []arr = new int[N]; //중요도가 들어있는 배열
            int [] sortArr = new int[N]; //중요도가 sorting 되어있는 배열
            int idx = 0; //중요도의 idx가 들어있는 max num
            Queue<Integer> q = new ArrayDeque<>();
            for(int i=0;i<N;i++) q.offer(i);
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sortArr[i] = arr[i];
            }
            Arrays.sort(sortArr);
            int answer = 0;

            while(true) {

                int cnum = q.poll();

                if(sortArr[idx]==cnum) {
                    //넘어갈거야 가장 크니까 다시 풋 안하고 근데 그게 답이면?
                    if(idx==M){
                        answer = idx;
                        break;
                    }
                    //답이 아니니까 그냥 idx만 늘려주고, 넘어감
                    idx++;
                }else{
                    //답이 아니면 다시 q에 쌓음
                    q.offer(cnum);
                }
            }

            System.out.println(answer);
        }
    }
}
