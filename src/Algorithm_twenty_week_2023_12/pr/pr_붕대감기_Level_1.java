package Algorithm_twenty_week_2023_12.pr;
import java.util.*;

public class pr_붕대감기_Level_1 {


    static int solution(int[] bandage, int health, int[][] attacks) {

        int answer = 0;
        int nowHealth = health; //현재체력
        int second = 0; //현재 시간
        int yeonsok = 0;
        int time = bandage[0]; //time  연속적으로 시간이 되면, 추가 회복
        int hps = bandage[1]; //heal per second
        int eff = bandage[2]; //effective
        int N = attacks.length;

        for(int i=0;i<N;i++){
            int attackTime = attacks[i][0];
            int attackPower = attacks[i][1];
            //현재 시간에서 공격 시간 전까지 회복 진행
            nowHealth += ((attackTime-1)-second) * hps;
            //연속적으로 공격하는 시간인지 아닌지 확인해야됨.
            yeonsok += ((attackTime-1)-second);
            if(yeonsok >= time){
                nowHealth += (yeonsok/time) * eff;
                yeonsok %= time;
            }
            if(nowHealth>health) nowHealth = health;
            nowHealth -= attackPower;
            if(nowHealth<1){
                answer = nowHealth;
                break;
            }
            second = attackTime;
            yeonsok = 0;
        }
        answer = nowHealth;
        return answer < 1  ? -1 : answer;
    }

    public static void main(String[] args) {
        int[]bandage = {3, 2, 7};
        int health = 20;
        int[][]attacks = {{1, 15},{5, 16},{8, 6}};
        System.out.println(solution(bandage,health,attacks));
    }
}
