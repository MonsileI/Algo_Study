package Algorithm_nineteenth_week_2023_11.bitmasking;

public class no_2 {
    public static void main(String[] args) {
        int a = 4;
        System.out.println(Integer.toBinaryString(1<<a));
        a = 1 << a;
        System.out.println(Integer.toBinaryString(a));
    }
}
