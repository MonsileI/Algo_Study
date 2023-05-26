package May_Fourth.pr_;

import java.util.*;

public class pr_혼자서하는틱택톡_Level_2 {
    public static void main(String[] args) {
        String[]board = {"OXO", "OOX", "OXX"};
        int answer = 1;

        int fp=0; int sp=0;
        //개수 체크 + 가로체크
        boolean fb = false; boolean sb = false;
        for(int i=0;i<3;i++){
            String str = board[i];
            int f =0; int s=0;
            for(int j=0;j<3;j++){
                char ch = str.charAt(j);
                if(ch=='O') fp++;
                else if(ch=='X') sp++;
            }
            if(3<=f){ fb = true; break;}
            if(3<=s){ sb = true; break;}
        }
        if(fp<sp || sp+1<fp) {answer = 0; return;}
        if(fb){
            if(fp!=sp || fp-1!=sp) answer=0;
            if(fp-1==sp) if(sp!=4) answer=0;
            return;
        }
        //후공이 이긴 경우는 반드시 선공과 개수가 같아야 한다.
        if(sb){
            if(fp!=sp) answer=0;
            return;
        }
        //for문 돌면서 세로 체크
        for(int j=0;j<3;j++){
            String str = board[j];
            int f =0; int s=0;
            for(int i=0;i<3;i++){
                char ch = board[i].charAt(j);
                if(ch=='O') fp++;
                else if(ch=='X') sp++;
            }
            if(3<=f){ fb = true; break;}
            if(3<=s){ sb = true; break;}
        }
        if(fp<sp || sp+1<fp) {answer = 0; return;}
        if(fb){
            if(fp!=sp || fp-1!=sp) answer=0;
            if(fp-1==sp) if(sp!=4) answer=0;
            return;
        }
        //후공이 이긴 경우는 반드시 선공과 개수가 같아야 한다.
        if(sb){
            if(fp!=sp) answer=0;
            return;
        }
        //boolean으로 체크하면서 대각선 체크
        for(int i=0;i<3;i++){
            String str = board[i];
            int f =0; int s=0;
            for(int j=0;j<3;j++){
                char ch = board[i].charAt(j);
                if(ch=='O') fp++;
                else if(ch=='X') sp++;
            }
            if(3<=f){ fb = true; break;}
            if(3<=s){ sb = true; break;}
        }
        if(fp<sp || sp+1<fp) {answer = 0; return;}
        if(fb){
            if(fp!=sp || fp-1!=sp) answer=0;
            if(fp-1==sp) if(sp!=4) answer=0;
            return;
        }
        //후공이 이긴 경우는 반드시 선공과 개수가 같아야 한다.
        if(sb){
            if(fp!=sp) answer=0;
            return;
        }


    }
}
