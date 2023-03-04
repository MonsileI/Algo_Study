package Febrary_second;

import java.util.*;
import java.io.*;
public class bj_21608_상어초등학교_Gold_5 {

    static class Score implements Comparable<Score>{

        int like, blank, i, j;

        @Override
        public int compareTo(Score o) {
            if(like==o.like){
                if(blank==o.blank){
                    if(i==o.i){
                        if(j==o.j){
                            return 0;
                        }else return j-o.j;
                    }else return i-o.i;
                }else return -(blank-o.blank);
            }else return -(like - o.like);

        }

        public Score(int like, int blank, int i, int j) {
            this.like = like;
            this.blank = blank;
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Score{" +
                    "like=" + like +
                    ", blank=" + blank +
                    ", i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};


    int[][]map = new int[N][N]; //진짜 자리
    int[][]stu = new int[N*N][5];
    StringTokenizer st = null;

    for(int i=0;i<N*N;i++){
        st = new StringTokenizer(br.readLine()," ");
        stu[i][0] = Integer.parseInt(st.nextToken()) - 1;
        stu[i][1] = Integer.parseInt(st.nextToken())-1;
        stu[i][2] = Integer.parseInt(st.nextToken())-1;
        stu[i][3] = Integer.parseInt(st.nextToken())-1;
        stu[i][4] = Integer.parseInt(st.nextToken())-1;
    }
    // 일단 앉혀본다
        /*
        비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
        1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
        2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
        * */
    for(int c=0;c<N*N;c++){
        //초기화
        int student = stu[c][0];
        List<Score> list = new ArrayList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                //이미 누가 앉아있으면 패스
                if(map[i][j]!=0) continue;

                Score score = new Score(0,0,i,j);

                for(int d=0;d<4;d++){
                    //사방 탐색
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    //범위 넘어가면 굳이 x
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                    //빈칸이면 빈칸 +1
                    if(map[ni][nj]==0) {
                        score.blank = score.blank+1;
                    }else{
                        //좋아하는 애가 앉았으면 +1
                        innerLoop:
                        for(int s : stu[student]){
                            if(s==map[ni][nj]) {
                                score.like = score.like+1;
                                break innerLoop;
                            }
                        }
                    }
                }
                list.add(score); //점수 넣어주기
            }
        }
        Collections.sort(list);
        System.out.println(list);
        Score here = list.get(0);
        map[here.i][here.j] = student;

    }

    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++) {
            map[i][j]++;
        }
    }

    for(int [] i : map) System.out.println(Arrays.toString(i));

    }
}
