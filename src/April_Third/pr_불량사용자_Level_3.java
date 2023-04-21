package April_Third;

import java.util.*;
public class pr_불량사용자_Level_3 {

    static String []users;
    static String []banneds;
    static Set<Set<String>> result;

    public static void main(String[] args) {
        String[]user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[]banned_id = {"fr*d*", "abc1**"};
        Set<String> set = new HashSet<>();
        users = user_id;
        banneds = banned_id;
        result = new HashSet<>();
        dfs(new HashSet<>(),0);

        System.out.println(result.size());
    }

    static void dfs(HashSet<String>set,int depth){
        if (depth == banneds.length) {
            result.add(set);
            return;
        }
        for(int i=0;i< users.length;i++){
            if(set.contains(users[i])) continue;
            if(check(users[i],banneds[depth])){
                set.add(users[i]);
                dfs(new HashSet<>(set),depth+1);
                set.remove(users[i]);
            }
        }
    }
    static boolean check(String user,String ban){

        if(user.length()!=ban.length())return false;

        for(int i=0;i<user.length();i++) if(ban.charAt(i) !='*' && ban.charAt(i)!=user.charAt(i)) return false;

        return true;
    }
}
