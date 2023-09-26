package Algorithm_tenth_week_2023_09.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_2533_사회서비스SNS_Gold_3_re {

    static int N;
    static List<List<Integer>> list;
    static int answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) list.add(new ArrayList<>());
        StringTokenizer st = null;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }
        dfs(1,0);
        System.out.println(answer);
        }
        static int dfs(int node,int parent){

            if(list.get(node).size()==1&&list.get(node).get(0)==parent){
                return 1;
            }
            int tmp = 0;
            for(int next : list.get(node)){
                if(next==parent) continue;
                tmp += dfs(next,node);
            }
            //tmp가 0이라는건 root node임을 의미
            if(tmp==0) return 1;
            answer++;
            return 0;
        }
    }