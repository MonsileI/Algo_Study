package May_third;

import java.util.Arrays;

public class pr_비밀지도_Level_1 {
    public static void main(String[] args) {

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[]answer = new String[n];
        //2진수로 변화
        for (int i = 0; i < n; i++) {
            int fir = arr1[i];
            int sec = arr2[i];
            String changeFir = Integer.toBinaryString(fir);
            String changeSec = Integer.toBinaryString(sec);
            if(changeFir.length()<n) while(changeFir.length()<n) changeFir = "0"+changeFir;
            if(changeSec.length()<n) while(changeSec.length()<n) changeSec = "0"+changeSec;
            String tmp="";
            for(int j=0;j<n;j++){
                char fch = changeFir.charAt(j); char sch = changeSec.charAt(j);
                if(fch=='1'||sch=='1') tmp += "#";
                else tmp += " ";
            }
            answer[i] = tmp;
        }
        for(int i=0;i<n;i++) System.out.println(answer[i]);
    }
}