package com.KarthikNimma;

public class TreeNode {
    County county_info;
    TreeNode left;
    TreeNode right;

    TreeNode(){
        county_info = new County();
        left = null;
        right = null;
    }
    TreeNode(County county_info){
        this.county_info = county_info;
        this.right = this.left = null;
    }
}

