package Algorithm_ninth_week_2023_08.pr;

public class pr_풍선터뜨리기_Level_3 {
    public static void main(String[] args) {
        int []a = {9,-1,-5};
        int answer = 2;
        if(a.length==1) answer = 1;
        else{

            int [] leftMin = new int[a.length];
            int [] rightMin = new int[a.length];
            int l = a[0];
            int r = a[a.length-1];

            for(int i=1;i<a.length-1;i++){
                if(l>a[i]) l = a[i];
                leftMin[i] = l;
            }
            for(int i=a.length-2;0<i;i--){
                if(r>a[i]) r = a[i];
                rightMin[i] = r;
            }

            for(int i=1;i<a.length-1;i++){
                    if(a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
                    answer++;
            }
            System.out.println(answer);
        }
    }
}
