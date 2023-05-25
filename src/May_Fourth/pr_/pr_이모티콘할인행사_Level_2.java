package May_Fourth.pr_;

import java.util.Arrays;

public class pr_이모티콘할인행사_Level_2 {
    static int n,u,arr[],stCons[],stUser[][],answerRegist,answerPrice;
    static boolean[]visited;
    public static void main(String[] args) {
        int[][]users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[]emoticons = {1300, 1500, 1600, 4900};
        n = emoticons.length;
        u = users.length;
        visited = new boolean[n];
        //재귀적으로 10 20 30 40을 적용해보자
        //가장 많이 가입하면서, 가장 많이 판매하는 금액
        //중복순열
        answerRegist = 0;
        answerPrice = 0;
        stCons = emoticons;
        stUser = users;
        arr = new int[n];
        perm(0);
        System.out.println(answerRegist + " : "+answerPrice);
    }

    static void calc(){

        int []tmp = new int[n];
        for(int i=0;i<n;i++) tmp[i] = stCons[i] * (100-arr[i])/100;
        int sumPrice = 0;
        int sumRegist = 0;
        for(int i=0;i<u;i++){
            //가입 했는지 안했는지 보는거
            boolean flag = false;
            int []user = stUser[i];
            int hal = user[0];
            int money = user[1];
            int buyPrice = 0;
            InnerLoop:
            for(int j=0;j<n;j++){
                //할인율이 넘으면 구입
                if(hal<=arr[j]){
                    money -= tmp[j];
                    buyPrice += tmp[j];
                }
                //가지고 있는 돈을 넘어버리면 가입해버림
                if(money<=0){
                    sumRegist++;
                    flag = true;
                    break InnerLoop;
                }
            }
            //가입 안했으면 buyPrice에 저-장!
            if(!flag) sumPrice += buyPrice;
        }

        if(answerRegist<sumRegist){
            answerRegist = sumRegist;
            answerPrice = sumPrice;
        }else if(answerRegist==sumRegist){
            if(answerPrice<sumPrice){
                answerPrice = sumPrice;
            }
        }
    }

    static void perm(int depth){

        if(depth==n){
            calc();
            return;
        }

        for(int i=10;i<41;i+=10){
            if(!visited[depth]){
                visited[depth] = true;
                arr[depth] = i;
                perm(depth+1);
                visited[depth] = false;
            }
        }
    }
}
