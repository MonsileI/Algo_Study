package Algorithm_eighteenth_week_2023_11.pr;
import java.util.*;
public class pr_키패드누르기_Level_1 {


    static String solution(int[] numbers, String hand) {
        //147 무조건 왼손 //369 무조건 오른손
        //2 5 8 0 은 가까운 손, 거리가 같다면 오른손잡이는 오른손, 왼손잡이는 왼손으로 터치
        //처음 위치는 왼손은 * 오른손은 #
        //맨해튼 거리로 계산!
        int[]L ={3,0}; int[]R ={3,2};
        int []pos = {0,1};
        int rPos = 0; int lPos =0;
        StringBuilder sb=  new StringBuilder();
        boolean flag = true;//트루가 오른손
        for(int i=0;i<numbers.length;i++){
            int num = numbers[i];
            if(num==1||num==4||num==7){
                flag = false;
                L[1] = 0;
                if(num==1) L[0] = 0;
                else if(num==4) L[0] = 1;
                else L[0] = 2;
            }else if(num==3||num==6||num==9){
                flag = true;
                R[1] = 2;
                if(num==3) R[0] = 0;
                else if(num==6) R[0] = 1;
                else R[0] = 2;
            }else{
                if(num==2)pos[0] = 0;
                else if(num==5)pos[0] = 1;
                else if(num==8)pos[0] = 2;
                else pos[0] = 3;

                rPos = Math.abs(R[0]-pos[0]) + Math.abs(R[1]-pos[1]);
                lPos = Math.abs(L[0]-pos[0]) + Math.abs(L[1]-pos[1]);

                if(rPos<lPos) {
                    R[0] = pos[0];
                    R[1] = pos[1];
                    flag = true;
                }
                else if(lPos<rPos) {
                    L[0] = pos[0];
                    L[1] = pos[1];
                    flag = false;
                }else{
                    if(hand.equals("right")){
                        R[0] = pos[0];
                        R[1] = pos[1];
                        flag = true;
                    }else{
                        L[0] = pos[0];
                        L[1] = pos[1];
                        flag = false;
                    }
                }
            }

            if(flag) sb.append("R");
            else sb.append("L");
        }


        return sb.toString();
    }


    public static void main(String[] args) {
        int[]numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";
        System.out.println(solution(numbers,hand));
    }
}
