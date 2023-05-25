package May_Fourth.pr_;

public class pr_택배배달과수거하기_Level_2 {
    public static void main(String[] args) {
        int cap = 4;   int n =5; int[]deliveries = {1, 0, 3, 1, 2};int []pickups = {0, 3, 0, 4, 0};
        long answer = 0;
        int deliver = 0;
        int pickup = 0;
        for(int i=n-1;i>-1;i--){
            if(deliveries[i]>0 || pickups[i]>0){
                int cnt = 0;//몇번 오는지
                while(deliver<deliveries[i] || pickup < pickups[i]){
                    cnt++;
                    deliver += cap;
                    pickup += cap;
                }
                deliver -= deliveries[i];
                pickup -= pickups[i];
                answer += (i+1) * cnt *2;
            }
        }
        System.out.println(answer);
    }
}
