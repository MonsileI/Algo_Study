package May_Fourth.pr_;

public class pr_택배배달과수거하기_Level_2_re {
    public static void main(String[] args) {
        int cap = 4;   int n =5; int[]deliveries = {1, 0, 3, 1, 2};int []pickups = {0, 3, 0, 4, 0};
        long answer = 0;
        int deliver = 0;
        int pickup = 0;

        for(int i=n-1;i>-1;i--){

            if(0<deliveries[i]|| 0<pickups[i]){
                int cnt = 0;
                while(deliver < deliveries[i] || pickup < pickups[i]){
                    deliver += cap;
                    pickup += cap;
                    cnt++;
                }
                deliver -= deliveries[i];
                pickup -= pickups[i];
                answer += (i+1) * cnt * 2;
            }
        }
        System.out.println(answer);
    }
}
