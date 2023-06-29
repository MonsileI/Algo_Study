package January_Fourth;

import java.util.*;
import java.io.*;
public class bj_12100_2048_Gold_2 {
    static int answer,N,tmp[];
    static Node[][]map;
    static class Node {
        int num; boolean check;

        public Node(int num, boolean check) {
            this.num = num;
            this.check = check;
        }
    }
    //0 위 1 아래 2 왼쪽 3 오른쪽
    static void calc(){

        Node[][]copyMap = new Node[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++){
                copyMap[i][j] = new Node(map[i][j].num, map[i][j].check);
            }
        }
        int cnt = 0;

        while(true){
            switch (tmp[cnt++]){
                case 0 :
                   for(int j=0;j<N;j++){
                        for(int i=1;i<N;i++){
                           if(copyMap[i][j].num!=0){
                               while(true){
                                   int ni = i -1;
                                   if(ni<0) break;
                                   else if(copyMap[ni][j].num==0) {
                                       copyMap[ni][j] = new Node(copyMap[i][j].num,copyMap[i][j].check);
                                       copyMap[i][j].num = 0;
                                       copyMap[i][j].check = false;
                                       i = ni;
                                   }else if(copyMap[ni][j].num!=0){
                                       if(!copyMap[ni][j].check && copyMap[i][j].num==copyMap[ni][j].num){
                                           copyMap[ni][j].check = true;
                                           copyMap[ni][j].num *= 2;
                                           copyMap[i][j].num = 0;
                                           copyMap[i][j].check = false;
                                       }
                                       break;
                                   }
                               }
                           }
                       }
                       for(int i=0;i<N;i++) copyMap[i][j].check = false;
                   }

                    break;
                case 1 :
                    for(int i=0;i<N;i++){
                        for(int j=N-2;-1<j;j--){
                            if(copyMap[i][j].num!=0){
                                while(true){
                                    int nj = j +1;
                                    if(N-1<nj) break;
                                    else if(copyMap[i][nj].num==0) {
                                        copyMap[i][nj] = new Node(copyMap[i][j].num,copyMap[i][j].check);
                                        copyMap[i][j].num = 0;
                                        copyMap[i][j].check = false;
                                        j = nj;
                                    }else if(copyMap[i][nj].num!=0){
                                        if(!copyMap[i][nj].check && copyMap[i][j].num==copyMap[i][nj].num){
                                            copyMap[i][nj].check = true;
                                            copyMap[i][nj].num *= 2;
                                            copyMap[i][j].num = 0;
                                            copyMap[i][j].check = false;
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        for(int j=0;j<N;j++) copyMap[i][j].check = false;
                    }
                    break;
                case 2 :
                    for(int j=0;j<N;j++){
                        for(int i=N-2;-1<i;i--){
                            if(copyMap[i][j].num!=0){
                                while(true){
                                    int ni = i +1;
                                    if(N-1<ni) break;
                                    else if(copyMap[ni][j].num==0) {
                                        copyMap[ni][j] = new Node(copyMap[i][j].num,copyMap[i][j].check);
                                        copyMap[i][j].num = 0;
                                        copyMap[i][j].check = false;
                                        i = ni;
                                    }else if(copyMap[ni][j].num!=0){
                                        if(!copyMap[ni][j].check && copyMap[i][j].num==copyMap[ni][j].num){
                                            copyMap[ni][j].check = true;
                                            copyMap[ni][j].num *= 2;
                                            copyMap[i][j].num = 0;
                                            copyMap[i][j].check = false;
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        for(int i=0;i<N;i++) copyMap[i][j].check = false;
                    }
                    break;
                case 3 :
                    for(int i=0;i<N;i++){
                        for(int j=1;j<N;j++){
                            if(copyMap[i][j].num!=0){
                                while(true){
                                    int nj = j -1;
                                    if(nj<0) break;
                                    else if(copyMap[i][nj].num==0) {
                                        copyMap[i][nj] = new Node(copyMap[i][j].num,copyMap[i][j].check);
                                        copyMap[i][j].num = 0;
                                        copyMap[i][j].check = false;
                                        j = nj;
                                    }else if(copyMap[i][nj].num!=0){
                                        if(!copyMap[i][nj].check && copyMap[i][j].num==copyMap[i][nj].num){
                                            copyMap[i][nj].check = true;
                                            copyMap[i][nj].num *= 2;
                                            copyMap[i][j].num = 0;
                                            copyMap[i][j].check = false;
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        for(int j=0;j<N;j++) copyMap[i][j].check = false;
                    }
                    break;
            }
            if(cnt==4) break;
        }

        int max = 0;
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) max = Math.max(max,copyMap[i][j].num);
        answer = Math.max(answer,max);
    }
    static void perm(int depth){
        if(depth==5){
            calc();
            return;
        }
        for(int i=0;i<4;i++){
            tmp[depth] = i;
            perm(depth+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        map = new Node[N][N];
        tmp = new int[5];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = new Node(Integer.parseInt(st.nextToken()),false);
            }
        }
        answer = 0;
        perm(0);
        System.out.println(answer);
    }
}
