package May_third;

public class pr_삼총사_Level_1 {
    static int answer = 0;
    static int[]staticNumber;
    static int size;
    public static void main(String[] args) {
        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        staticNumber = number;
        size = number.length;
        comb(0,0,0);
        System.out.println(answer);
    }
    static void comb(int depth,int sum,int start){
        if(depth==3){
            if(sum==0) answer++;
            return;
        }

        for(int i=start;i<size;i++){
            int newSum = sum + staticNumber[i];
            comb(depth+1,newSum,i+1);
        }


    }
}
