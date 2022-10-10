
import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // Run logic untill queue is empty 
        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> op = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.remove();
                op.add(curr.val);

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

            }

            ans.add(op);
        }

        return ans;

    }

}

/*
**************** Logic ****************
Solution 1 : Use Preorder traversal
Solution 2 : Use Queue
*/
