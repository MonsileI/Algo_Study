package May_third;

public class pr_이상한문자만들기_Level_1 {
    public static void main(String[] args) {
        String s = "try hello world";
        String answer = "";
        int size = s.length();
        int tmp = 0;
        for(int i=0;i<size;i++){
            char ch = s.charAt(i);
            if(ch==' ') {answer += ' ';tmp = 0; continue;}
            if(tmp%2==0) answer += Character.toUpperCase(ch);
            else answer += Character.toLowerCase(ch);
            tmp++;

        }
        System.out.println(answer);
    }
}
