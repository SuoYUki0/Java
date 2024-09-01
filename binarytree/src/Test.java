public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();

        boolean flg = binaryTree.find(root,'E');

        binaryTree.preOrder(root);
        System.out.println();
        binaryTree.preOrder(root);
        System.out.println("=====");
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.println();
        System.out.println("===");
        binaryTree.postOrder(root);
        System.out.println();
        binaryTree.postOrder(root);


        /*boolean flg = binaryTree.isCompleteTree(root);
        System.out.println(flg);
*/


       /* Queue<BinaryTree.TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        queue.offer(null);
        queue.offer(null);
        queue.offer(null);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());*/

        /*boolean flg = binaryTree.find(root,'E');
        if(flg == true) {
            System.out.println("找到了这个节点");
        }else {
            System.out.println("没有你要找的节点");
        }
        }*/

        /*binaryTree.nodeSize(root);
        System.out.println("节点的个数1："+binaryTree.size);
        System.out.println("节点的个数2："+binaryTree.nodeSize2(root));

        //System.out.println("叶子节点的个数："+binaryTree.getLeafSize(root));

        binaryTree.getLeafSize(root);

        System.out.println("叶子节点的个数："+ binaryTree.leafSize);
*/

        System.out.println("树的高度："+binaryTree.getHeight(root));

        /*System.out.println("===");
        binaryTree.preOrder(root);
        System.out.println("===");
        List<BinaryTree.TreeNode> ret = binaryTree.preOrder2(root);
        for(BinaryTree.TreeNode x : ret) {
            System.out.print(x.val+" ");
        }
        System.out.println("===");

        binaryTree.inOrder(root);
        System.out.println("===");
        binaryTree.postOrder(root);
        System.out.println("===");*/
    }
}