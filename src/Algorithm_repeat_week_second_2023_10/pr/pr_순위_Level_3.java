package Algorithm_repeat_week_second_2023_10.pr;

public class pr_순위_Level_3 {
    public static void main(String[] args) {
        int n =5;
        int [][] results = {{4, 3},{4, 2},{3, 2},{1, 2},{2, 5}};
        boolean[][]map = new boolean[n+1][n+1];
        boolean[][]reverseMap = new boolean[n+1][n+1];

        for(int i=0;i<n;i++){
            int a = results[i][0]; int b = results[i][1];
            map[a][b] = true;
            reverseMap[b][a] = true;
        }
        for(int l=1;l<n+1;l++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(i==j) continue;
                    if(map[i][l]&&map[l][j]) map[i][j] = true;
                    if(reverseMap[i][l]&&reverseMap[l][j]) reverseMap[i][j] = true;
                }
            }
        }
        int answer = 0;
        OuterLoop:
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==j) continue;
                if(!map[i][j]&&!reverseMap[i][j]) continue OuterLoop;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
