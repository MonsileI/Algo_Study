package Jun_First.bj;

import java.util.Arrays;

public class hyundaiAutoEverNo2 {
    public static void main(String[] args) {

        int N = 5; int M = 2;
        int[]arr = {1,0,1,1,0};
        int[]sumArr = new int[N];
        int[][]tc = {{1,3},{3,5}};
        int tmp = 0;
        int answer = 0;
        int sum = 0;
        for(int i=0;i<N;i++) {tmp += arr[i]; sumArr[i] = tmp; sum += arr[i];}

        for(int t=0;t<M;t++){
            int sIdx = tc[t][0]-1; int eIdx = tc[t][1]-1;
            int check = (sum-sumArr[sIdx]) + (sum-sumArr[eIdx]);
            answer += check;
        }
        System.out.println(answer);
    }
}
