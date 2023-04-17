package March_fourth;

public class ㅇ {
    public static void main(String[] args) {

        int a = 3;
        int b = 6;

        int min = Math.min(a,b);
        int max = Math.max(a,b);

        int tmp = 1;
        while(tmp!=0){
            tmp = max % min;
            max = min;
            min = tmp;
        }
        System.out.println(max);
        System.out.println(a * b / max);
    }
}
