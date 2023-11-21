package Algorithm_eighteenth_week_2023_11.bj;

import java.util.*;
import java.io.*;
/*
1. 처음 상어 크기는 2
2. 자기보다 작은 먹이만 먹을 수 있다.
3. 같은 크기의 상어는 지나갈 순 있다.
4. 자기 크기만큼 먹이량을 먹어야 크기가 1 증가한다. ex) 2이면 2마리 먹어야 증가.
5. 먹을 수 있는 먹이가 없으면 멈춘다.
TodoList
1. 먹이 클래스를 만들어서 sort 해준다. (크기 - i - j 순으로)
2. 먹을 수 있는 먹이를 최단거리를 구해 가장 가까운 애를 먹는다고 가정하고, 몇마리 먹었는지 변수, 크기 변수를 따로 지정
3. 먹은 먹이는 -1 처리 한다. (작거나 같으면 이동 가능하게 만든다.)

* */
public class bj_16236_아기상어_Gold_3 {
    static class Feed implements Comparable<Feed>{
        int i; int j; int size;

        public Feed(int i, int j, int size) {
            this.i = i;
            this.j = j;
            this.size = size;
        }

        @Override
        public int compareTo(Feed o) {
            return size-o.size;
        }
    }
    static int[][]map;
    static int N;
    static List<Feed> list;
    static int si,sj,sSize;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st = null;
        list = new ArrayList<>();
        si =0 ; sj =0; sSize = 2; int eat = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9) {
                    si = i;
                    sj = j;
                    map[i][j] = 0;
                }
                if(map[i][j]!=0) list.add(new Feed(i,j,map[i][j]));
            }
        }
        int ans = 0;
        while(true){
            int checkListNumber = -1;
            Collections.sort(list);
            int tmp = 987654321; //이동거리
            int fi = 987654321; int fj = 987654321;
            for(int i=0;i<list.size();i++){
                if(list.get(i).size==-1) continue;
                if(sSize<=list.get(i).size) break;
                int range = bfs(i);
                if(range<tmp) {
                    tmp = range;
                    checkListNumber = i;
                    fi = list.get(i).i;
                    fj = list.get(i).j;
                }else if(range==tmp) {
                    if(list.get(i).i<fi){
                        tmp = range;
                        checkListNumber = i;
                        fi = list.get(i).i;
                        fj = list.get(i).j;
                    }else if(list.get(i).i==fi){
                        if(list.get(i).j<fj){
                            tmp = range;
                            checkListNumber = i;
                            fi = list.get(i).i;
                            fj = list.get(i).j;
                        }
                    }
                }
            }
            if(checkListNumber==-1) break;
            if(tmp==987654321)break;

            si = list.get(checkListNumber).i; sj = list.get(checkListNumber).j;
            list.get(checkListNumber).size = -1;
            eat++;
            if(eat==sSize) {
                sSize++;
                eat = 0;
            }
            ans += tmp;
        }

        System.out.println(ans==987654321 ? 0 : ans);
    }

    static int bfs(int idx){

        Queue<int[]> q= new ArrayDeque<>();
        int y = si; int x = sj;
        int gi = list.get(idx).i; int gj = list.get(idx).j;
        q.offer(new int[]{y,x,0});
        boolean[][]visited = new boolean[N][N];
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            if(i==gi&&j==gj) return cnt;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]<=sSize){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
             }

        }

        return 987654321;
    }
}
