package May_third;

public class pr_다트게임_Level_1 {
    public static void main(String[] args) {
        String dartResult = "1S2D*3T";
        int[] tmp = new int[3];

        int idx = -1;
        int size = dartResult.length();

        for(int i=0;i<size;i++){

            String str = ""+dartResult.charAt(i);
            //10일때 처리
            if(str.equals("1") && i < size-1  && dartResult.charAt(i+1)=='0') str = "10";
            //0일때 처리
            if(str.equals("0") && i!=0 && dartResult.charAt(i-1)=='1') continue;

            switch (str){
                case "S" : tmp[idx] = (int) Math.pow(tmp[idx],1);
                    break;
                case "D" : tmp[idx] = (int) Math.pow(tmp[idx],2);
                    break;
                case "T" : tmp[idx] = (int) Math.pow(tmp[idx],3);
                    break;
                case "*" : if(idx!=0) tmp[idx-1] *= 2; tmp[idx] *= 2;
                    break;
                case "#" : tmp[idx] *= -1;
                    break;
                default: idx++; tmp[idx] = Integer.parseInt(str);
                    break;

            }
        }
        int answer = 0;
        for(int i=0;i<3;i++) answer += tmp[i];
        System.out.println(answer);

    }
}