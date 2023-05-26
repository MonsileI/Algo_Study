package May_Fourth.pr_;

import java.util.*;
public class pr_후보키_Level_2 {
    static int N;

    public static void main(String[] args) {

        String[][]relation ={{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        N = relation[0].length;
        comb(1,0,"");
    }

    static void calc(String str){
        System.out.println(str);
    }
    static void comb(int depth,int start,String num){

        if(N+1<depth) return;



        for(int i=start;i<N;i++){

            String newNum = num + depth;
            comb(depth+1,i+1,newNum);
            calc(num);

        }


    }
}
