import java.util.Scanner;

public class QuickSorting {

    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements of your array: ");
        n=scan.nextInt();
        int[] array = new int[n];
        System.out.println("Please enter the elements of your array");
        for(int i=0; i<n; i++)
        {
            array[i] = scan.nextInt();
        }
        scan.close();
        QuickSorting quicksorting = new QuickSorting();
        quicksorting.quickSort(array,0,n-1);							//calling the quickSort recursive function that performs the Quick sort
	System.out.print("The sorted array is as follows: ");
	for(int i=0; i<array.length;i++){							//printing the sorted array elements
            System.out.print(array[i] + " ");
        }

    }

    /* The method below partitions the array such that all elements to the left of the chosen pivot are smaller than it
       and all the elements to the right of the pivot are larger than it*/

    int partitioning(int[] array, int small, int big){
        int pivot = array[(small+big)/2];                         						 // we choose the central element as the pivot in this case

        while(small<=big){
            while(array[small]<pivot){
                small++;                      								//increment position of the left element if value is smaller than pivot element
            }
            while(array[big]>pivot){
                big--;                      								//decrement position of the right element if value is larger than pivot element
            }
            if(small<=big){                								 /*swapping the big and small elements if the small element is larger than pivot and
                                                							   big element smaller than pivot*/
                int temporary = array[small];
                array[small] = array[big];
                array[big] = temporary;
		small++;
		big--;
            }
        }
        return small;
    }

    // The method that follows is a recursive method that uses partitioning to implement the Quick Sort process on the array

    void quickSort(int[] array, int small, int big){
        int newpivot = partitioning(array,small,big);     //calls the partitioning method and assigns the value to newpivot
        if(small<newpivot-1){
            quickSort(array,small,newpivot-1);
        }
        if(newpivot<big){
            quickSort(array,newpivot,big);
        }

    }



}