package Algorithm_eighteenth_week_2023_11.pr;

import java.util.Arrays;

public class pr_거리두기확인하기_Level_2 {

    static int[] solution(String[][] places){
        int[]answer = new int[5];
        int[][]dir = {{-1,0},{0,1},{1,0},{0,-1}}; //하, 우만 확인하면 됨
        int[][]dirTwo = {{-1,-1},{1,-1},{-1,1},{1,1}};
        for(int t=0;t<5;t++){
            boolean flag = true;
            OuterLoop:
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(places[t][i].charAt(j)=='P'){
                        //맨해튼 거리 확인, 일단 1 거리 확인
                        for(int d=0;d<4;d++){
                            int ni = i + dir[d][0];
                            int nj = j + dir[d][1];
                            if(ni<0||nj<0||4<ni||4<nj) continue;
                            if(places[t][ni].charAt(nj)=='P'){
                                flag = false;
                                break OuterLoop;
                            }
                        }
                        //맨해튼 거리 대각선 확인(2임)
                        for(int d=0;d<4;d++){
                            int ni = i + dirTwo[d][0];
                            int nj = j + dirTwo[d][1];
                            if(ni<0||nj<0||4<ni||4<nj) continue;
                            if(places[t][ni].charAt(nj)=='P'){
                                if(places[t][i].charAt(nj)!='X'||places[t][ni].charAt(j)!='X'){
                                    flag = false;
                                    break OuterLoop;

                                }
                            }
                        }

                        //리얼 맨해튼 거리 확인
                        for(int d=0;d<4;d++){
                            int ni = i + dir[d][0] + dir[d][0];
                            int nj = j + dir[d][1] + dir[d][1];
                            int ci = i + dir[d][0]; int cj = j + dir[d][1];
                            if(ni<0||nj<0||4<ni||4<nj) continue;
                            if(places[t][ni].charAt(nj)=='P'){
                                if(places[t][ci].charAt(cj)!='X'){
                                    flag = false;
                                    break OuterLoop;
                                }
                            }
                        }

                    }
                }
            }
            if(!flag) answer[t] = 0;
            else answer[t] = 1;
        }

        return answer;
    }
    public static void main(String[] args) {
        String[][]places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(solution(places)));
    }
}
