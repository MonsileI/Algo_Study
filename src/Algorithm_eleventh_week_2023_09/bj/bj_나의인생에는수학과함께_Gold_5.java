package Algorithm_eleventh_week_2023_09.bj;

import java.util.*;
import java.io.*;
public class bj_나의인생에는수학과함께_Gold_5 {

    static class Node {
        int i; int j; char op; int sum;

        public Node(int i, int j, char op, int sum) {
            this.i = i;
            this.j = j;
            this.op = op;
            this.sum = sum;
        }
    }
    static int N;
    static char[][]map;
    static int[][]move = {{0,1},{1,0}};
    static int max = -987654321;
    static int min = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            int jIdx = 0;
            for(int j=0;j<str.length();j += 2){
                map[i][jIdx++] = str.charAt(j);
            }
        }

        bfs();
        System.out.println(max+" "+min);
    }

    static void bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0,0,'x',Integer.parseInt(map[0][0]+"")));
        while(!q.isEmpty()){
            Node node = q.poll();
            int i = node.i; int j = node.j; char op = node.op; int sum = node.sum;
            if(i==N-1&&j==N-1){
                max = Math.max(max,sum);
                min = Math.min(min,sum);
                continue;
            }
            for(int d=0;d<2;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;

                if(op!='x') {
                    int newOne = calc(sum,op,Integer.parseInt(map[ni][nj]+""));
                    q.offer(new Node(ni, nj, 'x', newOne));
                }else{
                    q.offer(new Node(ni,nj,map[ni][nj],sum));
                }
            }
        }
    }
    static int calc(int sum,char op, int now){
        int num = 0;
        switch (op){
            case '+': num = sum + now;
                break;
            case '-': num = sum - now;
                break;
            case '*': num = sum * now;
                break;
        }
        return num;
    }

}
