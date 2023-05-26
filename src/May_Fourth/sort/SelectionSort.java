package May_Fourth.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[]arr = {10,3,2,6,7,9};
        int N = arr.length;
        int least = 0; int temp = 0;
        //마지막 원소는 최댓값을 보장하기 때문에 n-1만큼 돈다.
        for(int i=0;i<N-1;i++){
            least = i;

            //최솟값 탐색
            for(int j=i+1;j<N;j++){
                if(arr[j]<arr[least]){
                    least = j;
                }
            }
            temp = arr[least];
            arr[least] = arr[i];
            arr[i] = temp;
        }
        for(int num : arr) System.out.print(num+", ");
    }
}
