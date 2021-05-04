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
                this.left = null;
                this.right = null;
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
                sb.append(root).append('\n');
                first.left = second;
                sb.append(first).append('\n');
                first.right = third;
                second.left = fourth;
                second.right = fifth;
                sb.append(second).append('\n');
                third.right = sixth;
                sb.append(third).append('\n');
//                System.out.printf("%s ", root.data);
//                System.out.println("Print in order->");
                String []tokens = sb.toString().split("\n");
                for(int i = tokens.length - 1; i >= 0; --i)
                    System.out.println(tokens[i]);

                return (sb.toString());
            }

        }

}
