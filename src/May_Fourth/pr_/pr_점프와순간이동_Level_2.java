package May_Fourth.pr_;

public class pr_점프와순간이동_Level_2 {
    public static void main(String[] args) {
        int N = 5000;
        int answer = 0;

        while(0<N){
            if(N%2==0){
                N /= 2;
            }else{
                answer++;
                N--;
            }
        }
        System.out.println(answer);
    }
}
