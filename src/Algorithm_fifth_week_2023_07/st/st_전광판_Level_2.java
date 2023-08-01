package Algorithm_fifth_week_2023_07.st;

import java.io.*;
import java.util.*;

public class st_전광판_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = null;
    /*    int [][] map = {{0,4,3,3,4,3,2,2,1,2},
                        {4,0,5,3,2,5,6,2,5,4},
                        {3,5,0,2,5,4,3,5,2,3},
                        {3,3,2,0,3,2,3,3,2,1},
                        {4,2,5,3,0,3,4,2,3,2},
                        {3,5,4,2,3,0,1,4,2,1},
                        {2,6,3,3,4,1,0,4,1,2},
                        {2,2,5,3,2,4,4,0,3,2},
                        {1,5,2,2,3,2,1,3,0,1},
                        {2,4,3,1,2,1,2,2,1,0}};*/

        boolean[][]map = {  {true,true,false,true,true,true,true},
                            {false,true,false,false,true,false,false},
                            {true,true,true,false,false,true,true},
                            {true,true,true,false,true,true,false},
                            {false,true,true,true,true,false,false},
                            {true,false,true,true,true,true,false},
                            {true,false,true,true,true,true,true},
                            {true,true,false,true,true,false,false},
                            {true,true,true,true,true,true,true},
                            {true,true,true,true,true,true,false},};
        for(int t=0;t<TC;t++){
            st = new StringTokenizer(br.readLine());
            String fir = st.nextToken();
            String sec = st.nextToken();
            int answer = 0;
            int firSize = fir.length()-1;
            int secSize = sec.length()-1;
            if(firSize==secSize){
                for(int i=secSize;-1<i;i--){
                    int f = Integer.parseInt(fir.charAt(i)+"");
                    int s = Integer.parseInt(sec.charAt(i)+"");
                    for(int j=0;j<7;j++) if(map[f][j]!=map[s][j]) answer++;
                }
            }else if(firSize<secSize){
               while(true){
                    int s = Integer.parseInt(sec.charAt(secSize)+"");
                    if(firSize<0){
                        for(int j=0;j<7;j++) if(map[s][j]) answer++;
                        secSize--;
                        if(secSize<0) break;
                    }else{
                        int f = Integer.parseInt(fir.charAt(firSize)+"");
                        for(int j=0;j<7;j++) if(map[f][j]!=map[s][j]) answer++;
                        secSize--; firSize--;
                    }
               }

            }else{
                while(true){
                    int f = Integer.parseInt(fir.charAt(firSize) + "");
                    if (secSize < 0) {
                        for (int j = 0; j < 7; j++) if (map[f][j]) answer++;
                        firSize--;
                        if (firSize < 0) break;
                    } else {
                        int s = Integer.parseInt(sec.charAt(secSize) + "");
                        for (int j = 0; j < 7; j++) if (map[f][j] != map[s][j]) answer++;
                        secSize--; firSize--;
                    }

                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
