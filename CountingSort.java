import java.util.Scanner;

public class CountingSort{
    public static void main(String[] args) {
        int n,i;
        int max=0;
        Scanner scan=new Scanner(System.in);
        System.out.println("Please enter the number of elements of your array: ");
        n=scan.nextInt();
        int[] arr = new int[n];
        System.out.println("Please enter the elements(positive integers) of your array: ");
        for(i=0; i<n; i++){
            arr[i]=scan.nextInt();
            if(arr[i]<0){
                System.out.println("Invalid input entered! Inputs should be positive integers only! Please try again: ");
                i--;
            }
        }
        scan.close();
        for(i=0; i<n; i++){
            if(arr[i]>max)
                max=arr[i];

        }
        int[] count = new int[max+1];
        for(i=0; i<max; i++){
            count[i]=0;
        }
        for(i=0; i<n; i++){
            count[arr[i]]++;
        }
        for(i=1; i<=max; i++){
            count[i] = count[i] + count[i-1];
        }
        int[] sortArr = new int[n];
        for(i=n-1; i>=0; i--){
         sortArr  [count [arr[i]]-1] = arr[i];
         count[arr[i]]--;
        }
        System.out.println("The count sorted array is: ");
        for(i=0; i<arr.length; i++){
            System.out.print(sortArr[i] + " ");
        }
    }
}
