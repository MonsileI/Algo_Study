package Algorithm_nineteenth_week_2023_11.bitmasking;

public class no_3 {
    public static void main(String[] args) {
        int a = 3;
        int flag = 0;
        System.out.println(flag&(1<<a));
        flag = flag | (1<<a);
        System.out.println(Integer.toBinaryString(flag));
        System.out.println(1<<a);
        System.out.println(flag&(1<<a));

    }
}
