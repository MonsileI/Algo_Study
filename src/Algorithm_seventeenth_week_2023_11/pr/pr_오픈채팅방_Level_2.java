package Algorithm_seventeenth_week_2023_11.pr;
import java.util.*;
public class pr_오픈채팅방_Level_2 {
    public static void main(String[] args) throws Exception {
        String[]record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        Map<String,String >map = new HashMap<>();
        for(int i=0;i<record.length;i++){
            String[]tmp =record[i].split(" ");
            if(tmp[0].equals("Leave")) continue;
            map.put(tmp[1],tmp[2]);
        }
        List<String> list = new ArrayList<>();
        for(int i=0;i<record.length;i++){
            String[]tmp = record[i].split(" ");
            if(tmp[0].equals("Change")) continue;
        ;   String str = map.get(tmp[1])+"님이 ";
            str += tmp[0].equals("Enter") ? "들어왔습니다.": "나갔습니다.";
            list.add(str);
        }
        String[]ans = new String[list.size()];
        for(int i=0;i<ans.length;i++) ans[i] = list.get(i);
        System.out.println(Arrays.toString(ans));
    }

}
