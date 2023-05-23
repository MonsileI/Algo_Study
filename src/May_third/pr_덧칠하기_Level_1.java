package May_third;

public class pr_덧칠하기_Level_1 {
    public static void main(String[] args) {
        int n = 4; int m = 1; int[]section = {1, 2, 3, 4};
        int answer = 1;
        int size = section.length;
        int end = section[0]+m;
        for(int i=1;i<size;i++){
            if(section[i]<=end-1) continue;
            end = section[i]+m;
            answer++;
        }
        System.out.println(answer);
    }
}
