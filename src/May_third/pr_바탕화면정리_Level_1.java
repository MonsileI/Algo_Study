package May_third;

public class pr_바탕화면정리_Level_1 {
    public static void main(String[] args) {

        String[]wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        int N = wallpaper.length;
        int M = wallpaper[0].length();

        int left = 987564321;
        int right = 0;
        int up = 987654321 ;
        int down = 0;

        for(int i=0;i<N;i++){
            String paper = wallpaper[i];
            for(int j=0;j<M;j++){
                char ch = paper.charAt(j);
                System.out.print(ch);
                if(ch=='#'){
                    left = Math.min(left,j);
                    up = Math.min(up,i);
                    right = Math.max(right,j);
                    down = Math.max(down,i);
                }
            }
                System.out.println();
        }
        down++; right++;
        int []answer = {up,left,down,right};
        System.out.println(up+" : "+left+ " : "+ down +" : "+right);
    }
}
