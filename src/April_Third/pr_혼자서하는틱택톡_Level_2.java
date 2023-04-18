package April_Third;


public class pr_혼자서하는틱택톡_Level_2 {
    public static void main(String[] args) {
        String[]board = {"...", ".X.", "..."};

        //O나X가 3이 되거나
        //X의 수가 O보다 많거나
        //O의 수가 X보다 두개 더 많을 때

        int answer = 1;
        int O = 0;
        int X = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                char ch = board[i].charAt(j);
                if(ch=='X') X++;
                else if(ch=='O') O++;
            }
        }
        if(X>O) answer = 0;
        else if(X<=O) answer = 0;




    }
}
