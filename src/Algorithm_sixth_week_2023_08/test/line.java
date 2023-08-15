package Algorithm_sixth_week_2023_08.test;

import java.util.Arrays;

public class line {
    public static void main(String[] args) {
        String str = "RLLRLR";
        int size = str.length();
        int[]arr = new int[size];
        int[]change = new int[size];
        int sum = 0;
        for(int i=0;i<size;i++){
            char ch = str.charAt(i);
            if(ch=='R') {
                arr[i] = (size-1) - i;
                change[i] = i - arr[i];
            }
            else{
                arr[i] = i;
                change[i] = ((size-1) -i) - arr[i];
            }
            sum += arr[i];
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(change);
        boolean flag = true;
        for(int i=size-1;-1<i;i--){
            if(!flag) {
                sb.append(sum+" ");
                continue;
            }
            if(change[i]<0) {
                sb.append(sum+" ");
                flag= false;
                continue;
            }
            sb.append(sum+change[i]+" ");
            sum += change[i];
        }

        System.out.println(sb.toString());


    }
}
