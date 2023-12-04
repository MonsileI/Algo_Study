package kakao;
import java.util.*;
public class no_3 {


    static int N,M;
    static int []tmp; //콤비네이션 할건데, 6번 승부를 한다는 거지?
    static int []tmpB;
    static int []answer;
    static int max;
    static int[][]D;
    static int v;

    static int[] solution(int[][] dice){
        D = dice;
        N = dice.length;
        M = N/2;
        tmp = new int[M];
        answer = new int[M];

        comb(0,0);

        return answer;
    }
    static void dfs(int a,int b,int aIdx,int bIdx,int depth){
        if(depth==M){
            if(a>b) v++;
            else if(a<b) v--;
            return;
        }

    }
    static void calc(){
        //템프만큼 돌릴거임. 상대도 템프 아닌만큼 배열 만들어줘야겠네..

        tmpB = new int[M];
        int idxA = 0; //A의 인덱스
        int idxB = 0; //새로 만들 b의 인덱스
        for(int i=0;i<N;i++){
            if(idxA>M-1) tmpB[idxB++] = i;
            else if(tmp[idxA]!=i) tmpB[idxB++] = i;
            else idxA++;
        }

        //36 * 36
        //tmp[0]에서 하나, tmp[1]에서 하나, 총 36개와
        //tmpB[0]에서 하나, tmpB[1]에서 하나, 총 36개를 대결
        //1이랑 3이면, 1 vs 2, 1 vs 4, 3 vs 2 , 3 vs 4 이렇게 다 해야됨.
        //몇개 고를지 모르니까 그걸 다 해줘야 되네? 재귀로...;

        v = 0; //승리
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                dfs(0,0,0,i,j); //a b depth;
            }
        }

        System.out.println(v+" "+tmp[0]+1+" "+tmp[1]+1);
        if(v>max){
            max = v;
            for(int i=0;i<M;i++) answer[i] = tmp[i]+1;
        }
    }
    static void comb(int depth,int start){

        if(depth==M){
            calc();
            return;
        }


        for(int i=start;i<N;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);
        }
    }

    public static void main(String[] args) {
        int[][]dice = {{0, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80}, {70, 70, 1, 1, 70, 70}};
        System.out.println(Arrays.toString(solution(dice)));
    }
}
