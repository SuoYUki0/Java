import java.util.*;

public class BinaryTree {
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }


    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }
    public  void  preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
    public void postOrder(TreeNode root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }
    public int size=0;
    public void nodeSize(TreeNode root){
        if(root==null){
            return;
        }
        nodeSize(root.left);
        size++;
        nodeSize(root.right);
    }
    public int nodeSize2(TreeNode root){
        if(root==null){
            return 0;
        }
        return nodeSize2(root.left)+nodeSize2(root.right)+1;

    }
    public int leafSize=0;
    public void getLeafSize(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            leafSize++;
        }
        getLeafSize(root.left);
        getLeafSize(root.right);
    }
    public int getKLevelNOdeCount(TreeNode root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelNOdeCount(root.left,k-1)+getKLevelNOdeCount(root.right,k-1);
    }
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=-getHeight(root.right);
        return (leftHeight>rightHeight?leftHeight+1:rightHeight+1);
    }
    public boolean find(TreeNode root,char key){
        if(root==null){
            return false;
        }
        if(root.val==key){
            return true;
        }
        boolean leftVal=find(root.left,key);
        if(leftVal==true){
            return true;
        }
        boolean rightVAl=find(root.right,key);
        if (rightVAl==true){
            return true;
        }
        return false;
    }
    //检查两颗树是否相同
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q!=null||p!=null&&q==null){
            return false;
        }
        if(p==null&&q==null){
            return true;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    //另一颗树的子树
    public boolean isSubTree(TreeNode root,TreeNode subRoot){
        if(root==null){
            return false;
        }
        if(isSameTree(root,subRoot)){
            return true;
        }
        if (isSameTree(root.left,subRoot)){
            return true;
        }
        if(isSameTree(root.right,subRoot)){
            return true;
        }
        return false;
    }
    //翻转二叉树
    public TreeNode invertTree(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    //判断一颗二叉树是否是平衡二叉树。
    public boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return Math.abs(leftHeight-rightHeight)<=1&&isBalanced(root.left)&&isBalanced(root.right);

    }
    //对称二叉树
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }

    private boolean isSymmetricChild(TreeNode p, TreeNode q) {
        if(p==null&&q!=null||p!=null&&q==null){
            return false;
        }
        if(p==null&&q==null){
            return true;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSymmetricChild(p.left,q.right)&&isSymmetricChild(p.right,q.left);
    }
    //二叉树的分层遍历
    public List<List<TreeNode>> levelOder(TreeNode root){
        List<List<TreeNode>> ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        Queue <TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<TreeNode> tmp=new ArrayList<>();
            while (size!=0){
                TreeNode cur=queue.poll();
                tmp.add(cur);
                size--;
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }

            }
            ret.add(tmp);

        }
        return ret;
    }
    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root){
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur!=null){
                queue.offer(root.left);
                queue.offer(root.right);

            }
            else{
                break;
            }

        }
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur!=null){
                return false;
            }
        }
        return true;

    }
//    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先 。
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return null;
        }
        if (root==p||root==q){
            return root;
        }
        TreeNode leftTree=lowestCommonAncestor(root.left,p,q);
        TreeNode rightTree=lowestCommonAncestor(root.right,p,q);
        if(leftTree!=null&&rightTree!=null){
            return root;
        }
        else if(leftTree!=null){
            return leftTree;

        }
        else{
            return rightTree;
        }
    }
    private boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> stack){
        if(root==null||node==null){
            return false;
        }
        stack.push(root);
        if(root==node){
            return true;
        }
        boolean flg1=getPath(root.left,node,stack);
        boolean flg2=getPath(root.right,node,stack);
        if(flg1){
            return true;
        }
        if (flg2){
            return true;
        }
        stack.pop();
        return false;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return null;
        }
        Stack<TreeNode> stackP=new Stack<>();
        Stack<TreeNode> stackQ=new Stack<>();
        getPath(root,p,stackP);
        getPath(root,q,stackQ);
        int sizeP=stackP.size();
        int sizeQ=stackQ.size();
        if(sizeP>sizeQ){
            int size=sizeP-sizeQ;
            while (size!=0){
                stackP.pop();
                size--;
            }
        }else{
            int size=sizeQ-sizeP;
            while (size!=0){
                stackQ.pop();
                size--;
            }
        }
        while (!stackP.isEmpty()&&!stackQ.isEmpty()){
            if(stackP.peek().equals(stackQ.peek())){
                return stackP.peek();
            }
            stackP.pop();
            stackQ.pop();
        }
        return null;
    }
}