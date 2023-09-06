package Algorithm_tenth_week_2023_09.pr;

public class pr_피로도_Level_2 {
    static int N,D[][];
    static boolean[]visited;
    static boolean flag;
    static int answer;
    public static void main(String[] args) {
        int k = 80;
        int [][] dungeons = {{80,20},{50,40},{30,10}};
        D = dungeons; N = dungeons.length;
        visited = new boolean[N];
        dfs(0,k);
        System.out.println(answer);
    }
    static void dfs(int depth,int tired){
        answer = Math.max(answer,depth);
        if(flag) return;

        if(depth==N){
            answer = N;
            flag= true;
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i] && D[i][0]<=tired){
                visited[i] = true;
                int newT = tired - D[i][1];
                dfs(depth+1,newT);
                visited[i] = false;
            }
        }

    }
}
