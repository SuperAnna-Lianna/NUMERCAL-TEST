import java.util.* ;
//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

public class SolutionErChaShu {
//二叉树  递归遍历方式: 先序遍历 (根左右),中序遍历(左根右)
//解题思路:  先序遍历序列的第一位是根节点, 去中序遍历序列中找到该节点,左右划分为根节点的左子树,右子树.
//          得到左右子树的先序遍历序列,中序遍历序列,
//          递归

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
        public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre.length==0||in.length==0){
            return null;
        }
        TreeNode treeNode=new TreeNode(pre[0]);
        for(int i=0;i<pre.length;i++){
            if(pre[0]==in[i]){
                treeNode.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1, i+1),Arrays.copyOfRange(in,0,i));
            	treeNode.right=reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return treeNode;
    }
}
