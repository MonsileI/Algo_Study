package May_Fourth.pr_;

import java.util.*;

public class pr_오픈채팅방_Level_2 {
    public static void main(String[] args) {
        String[]record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        Map<String,String> map = new HashMap<>();
        int size = record.length;

        for(int i =0; i<size;i++){
            String[] tmp = record[i].split(" ");
            String action = tmp[0];
            if(action.equals("Leave")) continue;
            String uid = tmp[1];
            String nick = tmp[2];
            map.put(uid,nick);
        }
        System.out.println(map);

        List<String> answerList = new ArrayList<>();

        for(int i=0;i<size;i++){
            String[] tmp = record[i].split(" ");
            String action = tmp[0];
            if(action.equals("Change")) continue;
            String uid = tmp[1];
            String nick = map.get(uid);
            String ans = nick+"님이 "+ (action.equals("Enter") ? "들어왔습니다." : "나갔습니다.");
            answerList.add(ans);
        }
        String[]answer = new String[answerList.size()];

        for(int i=0;i<answerList.size();i++) answer[i] = answerList.get(i);

        for(String str : answer) System.out.println(str);

    }
}
