package Febrary_third;

import java.io.*;
import java.util.*;
public class bj_13422_도둑_Gold_4 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); //총 집 개수
            int M = Integer.parseInt(st.nextToken()); //털러갈 집 개수
            int K = Integer.parseInt(st.nextToken()); //방범기가 작동하는 최소 금액
            int[] hs = new int[N]; //집들 배열
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) hs[i] = Integer.parseInt(st.nextToken());

            //첫번째 집을 선택하지 않았을 때,
            if(N==1){
                if(hs[0]<K) sb.append(1).append("\n");
                else sb.append(0).append("\n");
                continue;
            }
            int L = 1;
            int R = 1;
            int answer = 0;
            int money = hs[1];
            int cnt = 1;

            while (R < N ) {
                //조건 만족
                //M이 cnt랑 같음
                if (M == cnt) {
                    //조건 만족
                    if (money < K) answer++;
                    if(R==N-1) break;
                    R++;
                    money += hs[R];
                    money -= hs[L];
                    L++;

                } else {
                    R++;
                    if(R==N) break;
                    money += hs[R];
                    cnt++;
                }
            }
            //첫번쨰 집을 선택할 경우
            int[] hs2 = new int[M + M - 1];

            int idx = 0;
            for (int i = N - M + 1; i < N; i++) hs2[idx++] = hs[i];
            hs2[idx++] = hs[0];
            for (int i = 1; i < M; i++) hs2[idx++] = hs[i];

            L = 0;
            R = 0;
            money = hs2[0];
            cnt = 1;
            while (R < M + M - 1) {
                //조건 만족
                //M이 cnt랑 같음

                if (M == cnt) {
                //조건 만족
                    if (money < K) answer++;
                    if(R==M+M-2) break;
                    R++;
                    money += hs2[R];
                    money -= hs2[L];
                    L++;

                } else {
                    R++;
                    if(R==M+M-1) break;
                    money += hs2[R];
                    cnt++;
                }
            }
            if(N==M) {
                if(1<=answer) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
