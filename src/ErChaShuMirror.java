/**
 * Created by luairan on 16/7/31.
 */
public class ErChaShuMirror {
    /*二叉树的镜像定义：源二叉树
              8
            /  \
            6   10
            / \  / \
            5  7 9 11
    镜像二叉树
              8
            /  \
            10   6
            / \  / \
            11 9 7  5
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
        public void Mirror(TreeNode root) {
            TreeNode middle=null;
            if(root!=null){
                Mirror(root.left);
                Mirror(root.right);
                middle=root.left;
                root.left=root.right;
                root.right=middle;

            }
        }
}
