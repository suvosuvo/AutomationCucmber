package BinaryTree;
import java.util.Random;

public class BinaryTreeNew {

        private TreeNode root;
        private class TreeNode {
            private int data;
            private TreeNode left;
            private TreeNode right;
            public TreeNode(int data){
                this.data=data;
            }

            public String createBinary(){
                TreeNode first = new TreeNode(new Random().nextInt(99-9)+1);
                TreeNode second = new TreeNode(new Random().nextInt(99-9)+1);
                TreeNode third = new TreeNode(new Random().nextInt(99-9)+1);
                TreeNode fourth = new TreeNode(new Random().nextInt(99-9)+1);
                TreeNode fifth = new TreeNode(new Random().nextInt(99-9)+1);
                TreeNode sixth = new TreeNode(new Random().nextInt(99-9)+1);
                StringBuilder sb = new StringBuilder();
                root = first;
                sb.append(root);
                first.left = second;
                sb.append(first);
                first.right = third;
                second.left = fourth;
                second.right = fifth;
                sb.append(second);
                third.right = sixth;
                sb.append(third);
//                System.out.printf("%s ", root.data);
                return (sb.toString());
            }

        }

}
