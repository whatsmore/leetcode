package com.wcm.tools;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    static TreeNode getTree(Integer[] arr){
        if(arr==null||arr.length==0){
            return null;
        }
        return getTree(new ArrayList<>(Arrays.asList(arr)));
    }
    static TreeNode getTree(List<Integer> arr){
        if(arr==null||arr.isEmpty()){
            return null;
        }
        TreeNode root = new TreeNode(arr.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> newQueue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        boolean left = true;
        while (i<arr.size()){
            if(!queue.isEmpty()){
                TreeNode thisRoot = left?queue.peek(): queue.poll();
               if(arr.get(i)!=null){
                   TreeNode node = new TreeNode(arr.get(i));
                   newQueue.offer(node);
                   if(left){
                       thisRoot.left = node;
                   }else{
                       thisRoot.right = node;
                   }
               }
               left = !left;
               i++;
            }else{
                queue = newQueue;
                newQueue = new LinkedList<>();
            }
        }
        return root;
    }
}
