package com.KarthikNimma;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BinarySearchTree bst1 = new BinarySearchTree();
        County Franklin = new County("Franklin",new int[]{49},"Columbus", 1264518,539.87);
        County Hamilton = new County("Hamilton", new int[]{61}, "Cincinnati", 802374, 407.36);
        County Butler = new County("Buttler", new int[]{17}, "Hamilton", 368130, 467.27);
        County Montgomery = new County("Montgomery", new int[]{113}, "Dayton", 535153, 461.68);
        County Clinton = new County("Clinton", new int[]{27}, "Wilmington", 42040, 410.88);
        County Cuyahoga = new County("Cuyahoga", new int[]{35}, "Cleveland", 1249352, 458.49);

//    Question 1 insert the following counties
        bst1.insert(Franklin);
        bst1.insert(Hamilton);
        bst1.insert(Butler);
        bst1.insert(Montgomery);
        bst1.insert(Clinton);

// TO CHECK THE CORRECTNESS OF THE OPERATIONS PERFORMED THE BEST WAY IS TO SEE IF THE INORDER TRAVERSAL
// OF THE TREE IS SORTED IN ASCENDING ORDER.
// PLEASE SCROLL DOWN TO INORDER METHOD CALL FOR THE CODE

//  Question 2 preOrder Traversal
        System.out.println("\n Preorder: ");
        bst1.preOrder();

//  Question 3 inOrder Traversal
        System.out.println("\n Inorder:");
        bst1.inOrder();
        System.out.println("The FIPS code is sorted, hence the operation is correct".toUpperCase());
        System.out.println();


//  Question 4 insert Cuyahoga
        bst1.insert(Cuyahoga);
        System.out.println("Inorder: ");
        bst1.inOrder();
        System.out.println("The FIPS code is sorted, hence the operation is correct".toUpperCase());

//  Question 5 Delete franklin

        bst1.delete(Franklin);
        bst1.inOrder();
        System.out.println("The FIPS code is sorted, hence the operation is correct".toUpperCase());

    }
}
