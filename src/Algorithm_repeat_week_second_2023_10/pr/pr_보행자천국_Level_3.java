package Algorithm_repeat_week_second_2023_10.pr;

public class pr_보행자천국_Level_3 {
    static int [][]C;
    static int[][] map;
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][]city_map = {{0, 0, 0},{0, 0, 0},{0, 0, 0}};
        int N = m;
        int M = n;
        C = city_map;
        map = new int[N+1][M+1];
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
               if(i==1&&j==1)map[i][j] =1;
               else if(city_map[i-1][j-1]==0) map[i][j] = (TopValue(i,j)+LeftValue(i,j)) % 20170805;
               else map[i][j] = 0;
            }
        }
        System.out.println(map[N][M]);
    }
    static int TopValue(int row,int col){
        for(int i=row-1;0<i;i--){
            if(C[i-1][col-1]!=2) return map[i][col];
        }
        return 0;
    }
    static int LeftValue(int row,int col){
        for(int i=col-1;0<i;i--){
            if(C[row-1][i-1]!=2) return map[row][i];
        }
        return 0;
    }
}
