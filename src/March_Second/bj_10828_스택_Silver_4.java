    package March_Second;

    import java.util.*;
    import java.io.*;
    public class bj_10828_스택_Silver_4 {
        public static void main(String[] args) throws Exception {
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            Stack<Integer> st = new Stack<>();
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<N;i++){
                String act = br.readLine();
                String[]tmp = act.split(" ");
                if(tmp[0].equals("push")){
                    int num = Integer.parseInt(tmp[1]);
                    st.push(num);
                }else{
                    switch (tmp[0]){
                        case "pop": if(st.isEmpty()) sb.append(-1).append("\n");
                                    else sb.append(st.pop()).append("\n");
                            break;
                        case "size": sb.append(st.size()).append("\n");
                            break;
                        case "empty": if(st.isEmpty()) sb.append(1).append("\n");
                                      else sb.append(0).append("\n");
                            break;
                        case "top": if(st.isEmpty()) sb.append(-1).append("\n");
                                    else sb.append(st.peek()).append("\n");
                            break;
                    }
                }
            }

            System.out.println(sb.toString());
        }
    }
