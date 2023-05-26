package May_third;

public class pr_로또의최고순위최저순위_Level_1 {
    public static void main(String[] args) {
        int[]lottos = {44, 1, 0, 0, 31, 25}; int[]win_nums = {31, 10, 45, 1, 6, 19};
        int[]answer = new int[2];
        int[]resultArr = {6,6,5,4,3,2,1};
        //6개 일등
        //순서가 없어서 이런식으로는 불가능
        int win = 0;
        int lose = 0;
        boolean[]visited = new boolean[6];
        for(int i=0;i<6;i++){
            int lottoNum = lottos[i];
            if(lottoNum==0){win++; continue;};
            InnerLoop:
            for(int j=0;j<6;j++){
                int winNum = win_nums[j];
                if(lottoNum==winNum && !visited[j]) {visited[j]=true; win++; lose++; break InnerLoop;}
            }
        }

        answer[0] = resultArr[win];
        answer[1] = resultArr[lose];


    }
}
