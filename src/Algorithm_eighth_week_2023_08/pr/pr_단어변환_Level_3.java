package Algorithm_eighth_week_2023_08.pr;

public class pr_단어변환_Level_3 {
    static String b,t;
    static String []w;
    static int N;
    static int answer;
    static boolean[]visited;
    static int size;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[]words = {"hot", "dot", "dog", "lot", "log"};
        b = begin;
        t = target;
        w = words;
        N = words.length;
        visited = new boolean[N];
        size = b.length();
        answer = 987654321;
        boolean flag = false;
        for(int i=0;i<N;i++){
            if(w[i].equals(t)) {
                flag = true;
                break;
            }
         }
        if(!flag) answer= 0;
        else dfs(0,0,b);

        System.out.println(answer);
    }
    static void dfs(int depth,int cnt,String now){

        if(now.equals(t)){
            answer = Math.min(answer,cnt);
            return;
        }
        if(depth==N){
            if(now.equals(t)) answer = Math.max(answer,depth);
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                int tmp = 0;
                boolean flag = true;
                for(int j=0;j<size;j++){
                    if(now.charAt(j)!=w[i].charAt(j)) tmp++;
                    if(1<tmp) {
                        flag = false;
                        break;
                    }
                }
                if(flag&&tmp!=0){
                    visited[i] = true;
                    dfs(depth+1,cnt+1,w[i]);
                    visited[i] = false;
                }
            }
        }
    }

}
