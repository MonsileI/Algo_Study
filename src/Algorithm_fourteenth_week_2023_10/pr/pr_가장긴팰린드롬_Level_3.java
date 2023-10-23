package Algorithm_fourteenth_week_2023_10.pr;

public class pr_가장긴팰린드롬_Level_3 {
    public static void main(String[] args) {
        String s = "abcdcba";
        int answer = 0;
        int size = s.length();
        for(int i=0;i<size;i++){
            InnerLoop:
            for(int j=size-1;-1<j;j--) {
                int L = i;
                int R = j;
                boolean flag = true;
                while (L <= R) {
                    char fir = s.charAt(L);
                    char sec = s.charAt(R);
                    if (fir != sec) {
                        flag = false;
                        break;
                    }
                    L++;
                    R--;
                }
                if (flag) {
                    answer = Math.max(answer,j - i + 1);
                    break InnerLoop;
                }
            }
        }
        System.out.println(answer);
    }
}
