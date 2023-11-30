package Algorithm_nineteenth_week_2023_11.bitmasking;

public class no_1 {
    public static void main(String[] args) {
        int x = 10; // 2진수로 변환 시 1010
        int y = 12; // 2진수로 변환 시 1100

        System.out.println("1.");
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        System.out.println("============================");
        System.out.println("2.");
        System.out.println(Integer.toBinaryString(x|y)+" x|y ");
        System.out.println(Integer.toBinaryString(x&y)+" x&y ");
        System.out.println(Integer.toBinaryString(x^y)+" x^y ");
        System.out.println(Integer.toBinaryString(~x)+" ~x ");
        System.out.println(Integer.toBinaryString(x>>2)+" x>>2 ");
        System.out.println("============================");


    }
}
