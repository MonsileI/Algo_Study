package May_First;

import java.util.*;
import java.io.*;
public class pr_광물캐기_Level_2 {
    static int size, pick[], tmp, arr[];
    static String[]mineral;
    static int answer = 987654321; //피로도
    static boolean[] visited; // 순서 배열을 위한 visited 배열
    static List<Integer> list;


    static void calc(){
        //다이아몬드 곡갱이 = 0
        //철 곡갱이 =1;
        //돌 곡갱이 =2;

        //다이아 곡갱이는 피로도 전부 1
        //철 곡갱이는 다이아 캘때 5, 나머지 1
        //돌 곡갱이는 다이아 25, 철 5 돌 1
        int sum = 0;
        int hammerIdx = 0;
        int rockIdx = 0;
        int cnt = 0; //다섯개 캐면 그만하려고~

        while(true){
            int hammer = arr[hammerIdx];
            String rockStr = mineral[rockIdx];
            int rock = (rockStr.equals("diamond") ? 25 : rockStr.equals("iron") ? 5 : 1);
            int tired = (rock/hammer == 0 ? 1 : rock/hammer);
            sum += tired;

            cnt++;
            rockIdx++;
            if(cnt==5) {hammerIdx++; cnt=0;}
            if(rockIdx==size) break;
            if(hammerIdx==tmp) break;
            if(answer <= sum) return;
        }
        answer = Math.min(answer,sum);
    }

    static void perm(int depth){

        if(depth==tmp){
            calc();
            return;
        }

        for(int i=0;i<tmp;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = list.get(i);
                perm(depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int[]picks = {1,3,2};
        String[]minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        list = new ArrayList<>();
        for(int i=0;i<picks.length;i++) {
            int cnt = picks[i];
            for (int j = 0; j < cnt; j++) {
                list.add(i == 0 ? 25 : i == 1 ? 5 : 1);
            }
        }
        tmp = list.size();


        size = minerals.length; //미네랄의 크기
        //카피하기 like 카피닌자
        pick = picks;
        mineral = minerals;
        arr = new int[tmp];
        visited = new boolean[tmp];
        perm(0);

        System.out.println(answer);

    }


}
