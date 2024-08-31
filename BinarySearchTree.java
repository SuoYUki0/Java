public class BinarySearchTree {
    public static class Node {
        int key;
        Node left;
        Node right;
        public Node(int key) {
            this.key = key;
        }
    }
    private Node root = null;
    /**
     * 在搜索树中查找 key，如果找到，返回 key 所在的结点，否则返回 null
     * @param key
     * @return
     */
    public Node search(int key) {
        Node cur = root;
        while (cur != null) {
            if (key == cur.key) {
                return cur;
            } else if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }
    /**
     * 插入
     * @param key
     * @return true 表示插入成功, false 表示插入失败
     */
    public boolean insert(int key){
        if(root==null){
            root=new Node(key);
            return true;
        }
        Node cur=root;
        Node parent=null;
        while (cur!=null){
            if(key== cur.key){
                return false;
            }else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        Node node=new Node(key);
        if(key< parent.key){
            parent.left=node;
        }else{
            parent.right=node;
        }
        return true;

    }
    public void remove(int key){
        Node parent=null;
        Node cur=root;
        while (cur!=null){
            if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }else if(key>cur.key){
                parent=cur;
                cur=cur.right;
            }else{
                removeNode(parent,cur);
                return;
            }
        }
    }

    private void removeNode(Node parent, Node cur) {
        if(cur.left==null){
            if(cur==root){
                root=cur.right;
            }else if(cur==parent.left){
                parent.left=cur.right;
            }else{
                parent.right=cur.right;
            }
        }else if(cur.right==null){
            if(cur==root){
                root=cur.left;
            }else if(cur==parent.left){
                parent.left=cur.left;
            }else{
                parent.right=cur.left;
            }
        }else{
            Node target=cur.right;
            Node targetP=cur;
            while (target.left!=null){
                targetP=target;
                target=target.left;
            }
            cur.key=target.key;
            if(target==targetP.left){
                targetP.left=target.right;
            }else{
                targetP.right=target.right;
            }
        }
    }


}
