package May_third;

public class pr_콜라문제_Level_1 {
    public static void main(String[] args) {
        int a = 2;int b =1; int n=20; int answer = 0;
        while(n/a>0) {
            answer += (n/a)*b;
            n = (n/a)*b + n%a;
        }

        System.out.println(answer);
    }
}
