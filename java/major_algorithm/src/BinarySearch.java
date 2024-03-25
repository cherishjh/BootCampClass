import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
//      정렬이 되어 있어야 탐색이 가능
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        int find = 15;
        int index=0;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (arr[middle] == find) {
                index=middle;
                break;
            }
            else if(arr[middle]>find){
                end=middle-1;
            }
            else if(arr[middle]<find){
                start=middle+1;
            }
        }
        System.out.println(index);
    }
}