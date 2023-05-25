package May_Fourth.pr_;

public class pr_방금그곡_Level_2 {
    static class Music {
        int idx; int range; String title; String Melody;
        @Override
        public String toString() {
            return "Music{" +
                    "idx=" + idx +
                    ", range=" + range +
                    ", title='" + title + '\'' +
                    ", Melody='" + Melody + '\'' +
                    '}';
        }
        public Music(int idx, int range, String title, String melody) {
            this.idx = idx;
            this.range = range;
            this.title = title;
           this.Melody = melody;
        }
    }
    public static void main(String[] args) {
        String m = "ABC";
        String [] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String answer = "";
        int maxTime = 0;
        int minIdx = 987654321;
        int size = m.length();
        String cm = "";
        for(int i=0;i<size;i++){
            char ch = m.charAt(i);
            if(ch=='#') continue;
            if(i!=size-1 && m.charAt(i+1)=='#') cm += Character.toLowerCase(ch);
            else cm += ch;
        }
        size = musicinfos.length;
        Music[] music = new Music[musicinfos.length];
        for(int i=0;i<size;i++){
            String str = musicinfos[i];
            String[]tmp = str.split(",");
            int time = change(tmp[0], tmp[1]);
            String melody = tmp[3];
            int mSize = melody.length();
            String cMelody = "";
            for(int j=0;j<mSize;j++){
                char ch = melody.charAt(j);
                if(ch=='#') continue;
                if(j!=mSize-1 && melody.charAt(j+1)=='#') cMelody += Character.toLowerCase(ch);
                else cMelody += ch;
            }
            music[i] = new Music(i,time,tmp[2],cMelody);
        }
        for(int i=0;i<size;i++){
            Music mu = music[i];
            String mel = mu.Melody;
            int time = mu.range;
            String tmp = "";
            for(int j=0;j<time;j++) {
                int idx = j % mel.length();
                tmp += mel.charAt(idx);
            }
            if(tmp.contains(cm)){
                if(maxTime < time){
                    answer = mu.title;
                    maxTime = time;
                    minIdx = mu.idx;
                }else if(maxTime==time){
                    if(mu.idx<minIdx){
                        answer = mu.title;
                        maxTime = time;
                        minIdx = mu.idx;
                    }
                }
            }
        }
        answer = answer.isEmpty() ? "(None)" : answer;
        System.out.println(answer);
    }
    static int change(String start, String end){

        String[]tmp = start.split(":");
        int startTime = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
        tmp = end.split(":");
        int endTime = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);

        return endTime - startTime;
    }
}
