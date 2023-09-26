package Algorithm_ninth_week_2023_08.st;

import java.util.*;
import java.io.*;
public class st_업무처리_Level_3 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]map = new int[N+1][N+1];
        List<int[]> list = new ArrayList<>();
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<N+1;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                    map[i][j] = -1;
                    list.add(new int[]{i,j});
                }
            }
        }
        int[][]arr = new int[M][2];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        map[arr[0][0]][arr[0][1]] = 1;

        for(int tc=0;tc<M-1;tc++){
            int si = arr[tc][0]; int sj = arr[tc][1];
            int ei = arr[tc+1][0]; int ej = arr[tc+1][1];


           /*     for(int x=1;x<N+1;x++){
                    for(int y=1;y<N+1;y++){
                        System.out.print(map[x][y]);
                    }
                    System.out.println();
                }
                System.out.println("===========");*/

            int depart = map[ei][ej];
            map = new int[N+1][N+1];
            map[ei][ej] = depart;
            int size = list.size();
            for(int i=0;i<size;i++) map[list.get(i)[0]][list.get(i)[1]] = -1;
        }


    }
}
