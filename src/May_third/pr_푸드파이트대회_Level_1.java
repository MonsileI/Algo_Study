package May_third;

public class pr_푸드파이트대회_Level_1 {
    public static void main(String[] args) {
        int[]food = {1, 7, 1, 2};
        int size = food.length;
        String answer = "0";
        for(int i=size-1;0<i;i--){
            int cnt = food[i];
            if(cnt<2) continue;
            if(cnt%2==1) cnt--;
            while(0<cnt){
                answer += i;
                answer = i + answer;
                cnt -= 2;
            }
        }
        System.out.println(answer);
    }
}
