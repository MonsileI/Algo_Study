package kakao;

import java.util.*;
public class no_1 {

    static int solution(String[] friends, String[] gifts){
        //1. 더 많이 준 사람(양쪽 중)
        //준거 - 받은거
        //같으면 선물 안주고받음
        Map<String, List<String>> givenMap = new HashMap<>(); //준거
        Map<String, List<String>> takeMap  = new HashMap<>(); //받은거
        for(int i=0;i<friends.length;i++){
            givenMap.put(friends[i],new ArrayList<>());
            takeMap.put(friends[i],new ArrayList<>());
        }
        for(int i=0;i<gifts.length;i++){
            String[]tmp = gifts[i].split(" ");
            String a = tmp[0]; //준 애
            String b=  tmp[1]; //받은 애
            givenMap.get(a).add(b);
            takeMap.get(b).add(a);
        }
        //양쪽 포문
        int max = 0;
        for(int i=0;i<friends.length;i++){
            int sum = 0;
            String a = friends[i];
            //양쪽비교
            for(int j=0;j<friends.length;j++){
                int tmp = 0;
                if(i==j) continue;
                String b = friends[j];
                for(String str : givenMap.get(a)) if(str.equals(b))tmp++;
                for(String str : givenMap.get(b)) if(str.equals(a))tmp--;
                //선물지수 비교
                if(0<tmp) tmp=1;
                else if(tmp==0){
                    int sizeA = givenMap.get(a).size()-takeMap.get(a).size();
                    int sizeB = givenMap.get(b).size()-takeMap.get(b).size();
                    if(sizeA>sizeB) tmp = 1;
                }else tmp = 0;
                sum += tmp;
            }
            max = Math.max(max,sum);
        }
        //다음달에 가장 많은 선물을 받을 친구의 선물 개수
        return max;
    }

    public static void main(String[] args) {
        String [] friends = {"muzi", "ryan", "frodo", "neo"};
        String [] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(solution(friends,gifts));
    }
}
