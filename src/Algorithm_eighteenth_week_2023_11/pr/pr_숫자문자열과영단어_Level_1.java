package Algorithm_eighteenth_week_2023_11.pr;
import java.util.*;
public class pr_숫자문자열과영단어_Level_1 {

    static int solution(String s){
        //다 숫자로 변환해야함.
        Map<String,String> map = new HashMap<>();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");
        int N = s.length();
        String str = "";
        StringBuilder sb=  new StringBuilder();
        for(int i=0;i<N;i++){
            char ch = s.charAt(i);
            if('a'<=ch&&ch<='z'){
                str += ch;
                if(map.containsKey(str)){
                    sb.append(map.get(str));
                    str = "";
                }
            }else{
                sb.append(ch);
                str = "";
            }
        }
        return Integer.parseInt(sb.toString());

    }

    public static void main(String[] args) {
        String s = "123";
        System.out.println(solution(s));
    }
}
