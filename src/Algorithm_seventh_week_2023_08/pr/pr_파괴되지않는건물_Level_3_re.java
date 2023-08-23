package Algorithm_seventh_week_2023_08.pr;

public class pr_파괴되지않는건물_Level_3_re {
    public static void main(String[] args) {
        int[][]board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][]skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][]destory = new int[N+1][M+1];

        int size = skill.length;

        for(int i=0;i<size;i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];

            if(type==1) degree *= -1;

            destory[r1][c1] += degree;
            destory[r1][c2+1] -= degree;
            destory[r2+1][c1] -= degree;
            destory[r2+1][c2+1] += degree;
        }

        //가로
        for(int i=0;i<N+1;i++){
            int sum = 0;
            for(int j=0;j<M+1;j++){
                sum += destory[i][j];
                destory[i][j] = sum;
            }
        }
        for(int j=0;j<M+1;j++){
            int sum = 0;
            for(int i=0;i<N+1;i++){
                sum += destory[i][j];
                destory[i][j] = sum;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(0<destory[i][j]+board[i][j]) answer++;
            }
        }
        System.out.println(answer);

    }
}
