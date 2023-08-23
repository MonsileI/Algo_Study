package Algorithm_fifth_week_2023_07.pr;

public class pr_단체사진찍기_Level_2 {
    static String[] Data;
    static int answer;
    static boolean[]visited;
    static char[] member = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int N;
    public static void main(String[] args) {
        int n = 2;
        String []data = {"N~F=0", "R~T>2"};
        N = n;
        Data = data;
        visited = new boolean[8];
        dfs(0,"");
        System.out.println(answer);
    }
    static boolean check(String str){

        for(int i=0;i<N;i++){
            String tmp = Data[i];
            char f = tmp.charAt(0);
            char s = tmp.charAt(2);
            int fIdx = str.indexOf(f);
            int sIdx = str.indexOf(s);
            char op = tmp.charAt(3);
            int num = Integer.parseInt(tmp.charAt(4)+"")+1;
            int range = Math.abs(fIdx-sIdx);
            InnerLoop:
            switch (op){
                case '=': if(num!=range) return false;
                    break InnerLoop;
                case '<': if(num<=range) return false;
                    break InnerLoop;
                case '>': if(num>=range) return false;
                    break InnerLoop;
            }
        }
        return true;

    }
    static void dfs(int depth,String now){

        if(depth==8){
            if(check(now))answer++;
            return;
        }

        for(int i=0;i<8;i++){
            if(!visited[i]){
                visited[i] = true;
                String newOne = now + member[i];
                dfs(depth+1,newOne);
                visited[i] = false;
            }
        }


    }
}
