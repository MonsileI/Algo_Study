package May_third;

public class pr_둘만의암호_Level_1 {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        String answer = "";
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int size = skip.length();
        for (int i = 0; i < size; i++) {
            String ch = skip.charAt(i) + "";
            alpha = alpha.replace(ch, "");
        }
        size = alpha.length();
        int sSize = s.length();
        System.out.println(alpha);
        for (int i = 0; i < sSize; i++) {
            char ch = s.charAt(i);
            int idx = alpha.indexOf(ch);
            idx = (idx + index) % alpha.length();
            answer += alpha.charAt(idx);

        }
        System.out.println(answer);
    }
}
