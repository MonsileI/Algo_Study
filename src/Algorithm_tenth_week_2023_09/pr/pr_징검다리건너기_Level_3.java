package Algorithm_tenth_week_2023_09.pr;

public class pr_징검다리건너기_Level_3 {

    public static void main(String[] args) {
        int [] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int L = 1; int R = 200000000;
        while(L<R){
            int mid = (L+R)/2;
            if(check(mid,stones,k)) {
                L = mid+1;
            }
            else R = mid;
        }

        System.out.println(L-1);
    }
    static boolean check(int num,int[]stones,int k){
        int stone = 0;
        for(int s : stones){
            if(s - num<0){
                stone++;
            }else{
                stone = 0;
            }
            if(stone==k) return false;
        }
        return true;
    }
}
