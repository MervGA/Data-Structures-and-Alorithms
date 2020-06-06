import java.util.Scanner;
public class BinarySearchTreeMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        CreateBinaryTree cbt = new CreateBinaryTree();
        Node tree=cbt.createBinaryTree();
        System.out.println("\nA Binary Search Tree has been Created! If you'd like to interact with the tree, you are requested to make use of the Menu below.");
        BinaryTreeOperations ob = new BinaryTreeOperations();

        while(true) {
            System.out.println("\n\tMENU  ");
            System.out.println("\nEnter 1. Add an element");
            System.out.println("Enter 2. Delete an element");
            System.out.println("Enter 3. Search a node");
            System.out.println("Enter 4. Find the maximum element");
            System.out.println("Enter 5. Find the minimum element");
            System.out.println("Enter 6. Find  the successor");
            System.out.println("Enter 7. Find the predecessor");
            System.out.println("Enter 8. Exit Program");
            System.out.println("\nEnter your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1 -> {
                    int add;
                    System.out.println("Enter the integer value that you'd like to add to the tree: ");
                    add = scan.nextInt();
                    ob.add(tree, add);
                    System.out.println("The element with value " + add + " has been successfully added to the tree!");
                }
                case 2 -> {
                    int del;
                    System.out.println("Enter the integer value that you'd like to delete from the tree: ");
                    del = scan.nextInt();
                    ob.del(tree, del);
                    System.out.println("The element with integer value " + del + " has been successfully deleted from the tree!");
                }
                case 3 -> {
                    System.out.println("Enter the element you would like to find: ");
                    int find = scan.nextInt();
                    Node search = ob.search(tree, find);
                    if (search != null)
                        System.out.println("The element " + find + " was found at node address: " + search);
                    else
                        System.out.println("Element not found in tree!");
                }
                case 4 -> {
                    int max = ob.findMax(tree);
                    System.out.println("\nThe maximum value in the Binary Tree is: " + max);
                }
                case 5 -> {
                    int min = ob.findMinimum(tree);
                    System.out.println("The minimum value in the Binary tree is: " + min);
                }
                case 6 -> {
                    System.out.println("Enter the element of which you would like to find the successor: ");
                    int d = scan.nextInt();
                    int success = ob.successor(tree, d);
                    System.out.println("\nThe Successor of " + d + " is: " + success);
                }
                case 7 -> {
                    System.out.println("Enter the element of which you would like to find the predecessor: ");
                    int pre = scan.nextInt();
                    int predecessor = ob.predecessor(tree, pre);
                    System.out.println("The predecessor of " + pre + " is: " + predecessor);
                    System.out.print(predecessor);
                }
                case 8 -> {
                    System.out.println("Thank you for using the Menu!! Exiting Program...");
                    System.exit(0);
                }
                default ->
                    System.out.println("Invalid option entered! Please try again!");

            }
        }
    }
}
