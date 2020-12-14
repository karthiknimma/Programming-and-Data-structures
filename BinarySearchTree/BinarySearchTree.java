package com.KarthikNimma;

public class BinarySearchTree {
    TreeNode root;

    BinarySearchTree() {
        root = null;
    }

    //The following method prints the elements in preOrder which is CurrentNode - Left - Right
    void preOrder() {
        preOrderRecursion(root);
    }

    void preOrderRecursion(TreeNode r) {
        if (r != null) {
            System.out.println(r.county_info.toString());
            preOrderRecursion(r.left);
            preOrderRecursion(r.right);
        }
    }

    //The following method prints the elements in inOrder which is Left - Node - Right
    void inOrder() {
        inorderRecursion(root);
    }

    void inorderRecursion(TreeNode r) {
        if (r != null) {
            inorderRecursion(r.left);
            System.out.println(r.county_info.toString());
            inorderRecursion(r.right);
        }
    }
    boolean insert(final County info) {
        return insertRecursion(root, root, info);
    }

    boolean insertRecursion(TreeNode parent, TreeNode current, final County info) {
//        IF the BSt is empty insert at the root
        if (this.root == null) {
            root = new TreeNode(info);
            System.out.println("Insertion Successful! " + info.name);
            return true;
        }
        if (current == null) {
            TreeNode newNode = new TreeNode(info);
            if (info.FIPS[0] < parent.county_info.FIPS[0]) {
                parent.left = newNode;
                System.out.println("Insertion Successful! " + info.name);
                return true;
            } else {
                parent.right = newNode;
                System.out.println("Insertion Successful! " + info.name);
                return true;
            }
        }
        if (current.county_info.FIPS[0] == info.FIPS[0]) {
            System.out.println("Cant insert Duplicate Node!");
            return false;
        } else if (current.county_info.FIPS[0] > info.FIPS[0])
            return insertRecursion(current, current.left, info);
        else
            return insertRecursion(current, current.right, info);
    }

    void delete(County c) {
        deleteNode(this.root,c);
        System.out.println("\nSuccessfully deleted: "+ c.name);
    }


    TreeNode deleteNode(TreeNode node, County c) {
        if (node == null) {
            return null;
        }
        if (c.FIPS[0] < node.county_info.FIPS[0]) {
            node.left = deleteNode(node.left, c);
        } else if (c.FIPS[0] > node.county_info.FIPS[0]) {
            node.right = deleteNode(node.right, c);
        } else {
            if (node.left == null || node.right == null) {
                TreeNode temp = null;

                if (node.left == null)
                    temp = node.right;
                else
                    temp = node.left;

                if (temp == null)
                    return null;
                else
                    return temp;
            } else {
                TreeNode successor = getSuccessor(node);
                node.county_info = successor.county_info;
                node.right = deleteNode(node.right, successor.county_info);
                return node;
            }
        }
        return node;
    }

    public TreeNode getSuccessor(TreeNode node) {

        TreeNode temp = node.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

}


