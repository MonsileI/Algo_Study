package May_third;

public class pr_공원산책_Level_1 {
    public static void main(String[] args) {
        String[]park = {"SOO","OOO","OOO"};
        String[]routes = {"E 2","S 2","W 1"};
        int N = park.length;
        int M = park[0].length();
        int[][]map = new int[N][M];

        int si = 0; int sj=0;
        for(int i=0;i<N;i++){
            String str = park[i];
            for(int j=0;j<M;j++){
                if(str.charAt(j)=='S'){si = i ; sj = j ; continue;};
                map[i][j] = str.charAt(j)=='O' ? 0 : 1;
            }
        }
        int size = routes.length;
        int [][]dir = {{-1,0},{0,1},{1,0},{0,-1}};

        for(int i=0;i<size;i++){

            char turn = routes[i].charAt(0);
            int d = 0;
            int range = Integer.parseInt(routes[i].charAt(2)+"");
            boolean flag = true;
            //NSWE
            switch (turn){
                case 'N': d=0;
                    break;
                case 'E': d=1;
                    break;
                case 'S': d=2;
                    break;
                case 'W': d=3;
                    break;
            }
            int ni=0; int nj=0; int tmpI = si; int tmpJ = sj;

            InnerLoop:
            for(int r=0;r<range;r++){
                ni = tmpI + dir[d][0];
                nj = tmpJ + dir[d][1];

                if(ni<0||nj<0||N-1<ni||M-1<nj||map[ni][nj]==1){flag = false; break InnerLoop;};
                tmpI = ni;
                tmpJ = nj;
            }
            if(flag) {si =tmpI; sj = tmpJ;};
        }

        System.out.println(si+" : "+sj);
    }
}
