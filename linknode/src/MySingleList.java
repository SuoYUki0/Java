public class MySingleList {

    static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }
    public ListNode head;
    public void createList() {

        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(23);
        ListNode node3 = new ListNode(34);
        ListNode node4 = new ListNode(45);
        ListNode node5 = new ListNode(56);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        this.head = node1;

    }
    public void display(){
        ListNode cur=head;
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    public void display(ListNode newHead){
        ListNode cur=newHead;
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    public int size(){
        ListNode cur=head;
        int count=0;
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        return  count;
    }
    public boolean contains(int key){
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return  false;
    }
    public void addFirst(int data){
        ListNode node =new ListNode(data);
        node.next=head;
        head=node;
    }
    public void addLast(int data){
        ListNode node=new ListNode(data);
        ListNode cur=head;
        if(cur==null){
            head=node;
            return;
        }
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
    }
    public void addIndex(int index,int data){
        if(index<0||index>size()){
            System.out.println("index不合法");
            return;
        }
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==size()){
            addLast(data);
            return;
        }
        ListNode cur=findIndexSubOne(index);
        ListNode node=new ListNode(data);
        node.next=cur.next;
        cur.next=node;
    }

    private ListNode findIndexSubOne(int index) {
        ListNode cur=head;
        while (index!=1){
            cur=cur.next;
            index--;
        }
        return cur;
    }
    public void remove(int key){
        if(head==null){
            return;
        }
        if(head.val==key){
            head.next=head;
            return;
        }
        ListNode cur = searchPrev(key);
        if(cur==null){
            System.out.println("没有删除数字");
            return;
        }
        ListNode del=cur.next;
        cur.next=del.next;
    }

    public ListNode searchPrev(int key) {
        ListNode cur=head;
        while (cur.next!=null){
            if(cur.next.val==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    //删除链表中等于给定值 val 的所有节点
    public void removeAllKey(int key){
        if(head==null){
            return;
        }
        if(head.val==key){
            head=head.next;
        }
        ListNode cur=head.next;
        ListNode prev=head;
        while(cur!=null){
            if(cur.val==key){
                prev.next=cur.next;
                cur=cur.next;
            }
            else if(cur.val!=key){
                prev=cur;
                cur=cur.next;
            }
        }
    }
    public void clear(){
        this.head=null;
    }
    //反转一个单链表
    public ListNode reverseList(){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode cur=head.next;
        head.next=null;
        while (cur!=null){
            ListNode curNext= cur.next;
            cur.next=head;
            head=cur;
            cur=curNext;
        }
        return head;
    }
    // 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结
    //点
    public ListNode middleNode(){
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;

    }
    //. 输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(int k){
        if(k<=0||head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        //o o o o o o
        for(int i=0;i<k-1;i++){
            fast=fast.next;
            if(fast==null){
                return null;
            }
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;

    }
    public boolean chkPalindrom(ListNode head){
        //找到中间位置
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //翻转
        ListNode cur=slow.next;
        while (cur!=null){
            ListNode curNext= cur.next;
            cur.next=slow;
            slow=cur;
            cur=curNext;
        }
        //判断回文
        while (head!=slow){
            if(head.val!= slow.val){
                return false;

            }
            if(head.next==slow){
                return true;
            }
            head=head.next;
            slow=slow.next;
        }
        return true;
    }
    public boolean hasCycle(){
        if(head==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;


    }
    public ListNode detectCycle(){
        if(head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null&&fast.next==null){
            return null;
        }
        fast=head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }

}