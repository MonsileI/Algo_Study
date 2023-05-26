package May_third;

public class pr_카드뭉치_Level_1 {
    public static void main(String[] args) {
        String[]cards1 = {"i", "water", "drink"}; String[]cards2 ={"want", "to"}; String[]goal = {"i", "want", "to", "drink", "water"};
        int idx1 = 0; int idx2 = 0; int size = goal.length;
        boolean flag = true;
        for(int i=0;i<size;i++){
            String word = goal[i];
            if(idx1<cards1.length){
                String first = cards1[idx1];
                if(first.equals(word)){ idx1++; continue;}
            }
            if(idx2<cards2.length){
                String second = cards2[idx2];
                if(second.equals(word)) {idx2++;continue;}
            }
            flag = false; break;
        }
        String answer = flag ? "Yes" : "No";
        System.out.println(answer);
    }
}
