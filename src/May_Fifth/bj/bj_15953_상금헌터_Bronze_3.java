package May_Fifth.bj;

import java.io.*;
import java.util.*;

public class bj_15953_상금헌터_Bronze_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]fArr = {5000000,3000000,2000000,500000,300000,100000};
        int[]sArr = {5120000,2560000,1280000,640000,320000};
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int fNum = Integer.parseInt(st.nextToken());
            int sNum = Integer.parseInt(st.nextToken());

            int fscore = 0;
            if(fNum==0) fscore = 0;
            else if(fNum==1) fscore += fArr[0];
            else if(fNum<=3)fscore += fArr[1];
            else if(fNum<=6)fscore += fArr[2];
            else if(fNum<=10) fscore += fArr[3];
            else if(fNum<=15) fscore += fArr[4];
            else if(fNum<=21) fscore += fArr[5];

            int sscore = 0;
            if(sNum==0) sscore = 0;
            else if(sNum==1) sscore += sArr[0];
            else if(sNum<=3) sscore += sArr[1];
            else if(sNum<=7) sscore += sArr[2];
            else if(sNum<=15)sscore += sArr[3];
            else if(sNum<=31) sscore += sArr[4];
            sb.append(fscore+sscore).append("\n");
        }
        System.out.println(sb.toString());
    }
}
