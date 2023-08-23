package Algorithm_sixth_week_2023_08.test;

public class coupang {

    static int N,K,T,map[];
    static int answer;

    public static void main(String[] args) {

        int n = 4;  int k =2;int t=3;
        int[]arr = {1,1,2,2};
        N = n;K=k;T=t;map=arr;
        comb(0,0,0);
        System.out.println(answer);
    }

    static void comb(int depth,int start,int sum){

        if(T<sum) return;

        if(depth==N){
            if(sum<=T) answer++;
            return;
        }
        if(K<=depth){
            if(sum<=T) answer++;
        }


        for(int i=start;i<N;i++) {
            int newOne = sum + map[i];
            comb(depth + 1, i + 1, newOne);
        }
    }
}
