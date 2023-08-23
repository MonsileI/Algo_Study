package Algorithm_fifth_week_2023_07.st;

import java.util.*;
import java.io.*;
public class st_회의실예약_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeMap<String,boolean[]> map = new TreeMap<>();
        for(int i=0;i<N;i++){
            map.put(br.readLine(),new boolean[19]);
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            String room = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for(int j=s;j<=e;j++) map.get(room)[j] = true;
        }
        StringBuilder sb = new StringBuilder();
        int last = map.size();
        for(String key : map.keySet()){
            String str = "";
            int size = map.get(key).length;
            boolean flag = false;

            if(!map.get(key)[9]){
                str += "09-";
                flag = true;
            }
            int cnt = 0;
            for(int i=10;i<=18;i++){
                if(map.get(key)[i]){
                   if(flag) {
                       cnt++;
                       str += i+"\n";
                       flag = false;
                   }else continue;
                }else{
                    if(!flag){
                        flag = true;
                        str += i-1+"-";
                    }
                }
            }
            if(flag){
                cnt++;
                str+="18\n";
            }
            last--;
            if(last==0){
                if(cnt==0) str = "Room "+key+":\n"+"Not available";
                else str = "Room "+key+":\n"+cnt+" available:\n" + str;
            }else{
                if(cnt==0) str = "Room "+key+":\n"+"Not available"+"\n"+"-----\n";
                else str = "Room "+key+":\n"+cnt+" available:\n" + str + "-----\n";
            }

            sb.append(str);
        }

        System.out.println(sb.toString());
    }
}
