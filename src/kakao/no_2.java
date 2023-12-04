package kakao;
import java.util.*;
public class no_2 {

    static List<List<Integer>> list;
    static int N;
    static boolean[]visited;
    static int[]answer;
    static boolean stickFlag;
    static int[] solution(int[][] edges){
        answer = new int[4]; //정점, 막대, 싸이클, 도넛
        list = new ArrayList<>();
        for(int i=0;i<edges.length;i++) N = Math.max(N,Math.max(edges[i][0],edges[i][1]));
        for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
        int [] go=  new int[N+1];
        int [] come = new int[N+1];
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            list.get(a).add(b);
            go[a]++;
            come[b]++;
        }
        int max = 0;//제일 내가 많이 나간 정점
        int start = 0;
        for(int i=1;i<N+1;i++){
            if(come[i]==0){
                if(max<go[i]){
                    max = go[i];
                    start = i;
                }
            }
        }
        //이제 돌면서 뭔지 확인해보자
        visited = new boolean[N+1];//어차피 각자 서로한테 영향을 못줌
        visited[start] = true; //start에 돌아올 필요가 없음
        answer[0] = start;
        for(Integer node : list.get(start)){
            stickFlag = true;
            dfs(node);
            if(stickFlag) answer[2]++;
        }
        return answer;
    }
    static void dfs(int node){
        if(list.get(node).size()>1){ //간선이 두개 이상이면, 도넛
            answer[3]++;
            stickFlag = false;
            return;
        }
        visited[node] = true;
        if(list.get(node).size()==0) return;
        int nextNode = list.get(node).get(0);
        if(visited[nextNode]) { //이미 들렸던 간선이 있다는건, 사이클이 있다는것!
            answer[1]++;
            stickFlag = false;
            return;
        }
        dfs(nextNode);
    }

    public static void main(String[] args) {
        int [][] edges= {{2, 3}, {4, 3}, {1, 1}, {2, 1}};
        System.out.println(Arrays.toString(solution(edges)));

    }
}
