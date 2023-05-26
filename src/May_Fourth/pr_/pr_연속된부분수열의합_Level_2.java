package May_Fourth.pr_;

public class pr_연속된부분수열의합_Level_2 {
    public static void main(String[] args) {
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        int[] answer = new int[2];
        //크면 L을 늘려준다. 작으면 R을 늘려준다
        int min = 987654321;
        int L = 0;
        int R = 0;
        int N = sequence.length;
        int sum = sequence[L];
        while (L < N) {
            if (k < sum) {
                sum -= sequence[L];
                L++;
            }else if (sum == k) {
                if ((R - L) + 1 < min) {
                    min = (R - L) + 1;
                    answer[0] = L;
                    answer[1] = R;
                }
                R++;
                if(N-1<R) break;
                sum += sequence[R];
            }else {
                R++;
                if(N-1<R) break;
                sum += sequence[R];
            }
        }
        System.out.println(answer[0] + " : "+answer[1]);
    }
}
