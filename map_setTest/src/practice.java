import java.util.*;

public class practice {
    //1. 只出现一次的数字
    public int singleNumber(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                set.remove(nums[i]);
            }

        }
        for (int i = 0; i < nums[i]; i++) {
            if(set.contains(nums[i])){
                return nums[i];
            }

        }
        return -1;
    }

    //2. 复制带随机指针的链表
//    public Node copyRandomList(Node head){
//        HashMap<Node,Node> map=new HashMap<Node, Node>();
//        //1. 第一次遍历链表
//        Node cur=head;
//        while (cur!=null){
//            Node node=new Node(cur.val);
//            map.put(cur.node);
//            cur=cur.next;
//        }
//        //2. 再次遍历链表
//        cur=head;
//        while (cur!=null){
//            map.get(cur).next=map.get(cur.next);
//            map.get(cur).random=map.get(cur.random);
//            cur=cur.next;
//        }
//        return map.get(head);
//    }

    //3. 宝石与石头
    public int numJewelsInStone(String jewels,String stones){
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            char ch = jewels.charAt(i);
            set.add(ch);
        }
        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if(set.contains(ch)){
                count++;
            }

        }
        return count;

    }
    //4. 坏键盘打字
    public static void func(String str1,String str2){
        HashSet<Character> set1=new HashSet<>();
        HashSet<Character> setBroken=new HashSet<>();
        for (char ch:
             str2.toUpperCase().toCharArray()) {
            set1.add(ch);

        }
        for (char ch:
             str1.toUpperCase().toCharArray()) {
            if(!set1.contains(ch)&&!setBroken.contains(ch)){
                System.out.println(ch);
                setBroken.add(ch);

            }

        }
    }
    //5. 前K个高频单词
    public static List<String> topKFrequent(String[] words,int k){
        //1. 需要去统计 每个单词出现的次数
        Map<String,Integer> map=new HashMap<>();
        for (String word:
             words) {
            if(map.get(word)==null){
                map.put(word,1);
            }else{
                int val=map.get(word);
                map.put(word,val+1);
            }

        }
        //2. 通过上述代码 我们已经得到了，每个单词出现的次数，存储到了map当中
        // 也就是说，如果看哪个单词出现的频率，接下来要遍历的是map
        //2.1 创建小根堆
        PriorityQueue<Map.Entry<String,Integer>> minHeap=new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue())==0){
                    return o2.getKey().compareTo(o1.getKey());//根据key变成大根堆
                }
                //默认根据频率来创建小根堆
                return o1.getValue().compareTo(o2.getValue());

            }
        });
        //3. 遍历map 把每个单词及频率获取到，存放到小根堆当中。以TOPK的问题去解决。
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            //entry ==> hello - 3
            if(minHeap.size() < k) {
                minHeap.offer(entry);// 扣5
            }else {
                //此时堆 放满了 ，需要每次和堆顶元素进行比较
                Map.Entry<String,Integer> top = minHeap.peek();
                //频率相同
                if(top.getValue().compareTo(entry.getValue()) == 0) {
                    if(top.getKey().compareTo(entry.getKey()) > 0) {
                        //堆顶是def-3, entry是 abc - 3. 出堆
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                }else {
                    //频率不相同
                    // 堆顶是def-3, entry是 abc - 6. 出堆
                    if(entry.getValue().compareTo(top.getValue()) > 0) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                    // 堆顶是def-3, entry是 abc - 2. 不动
                }
            }
        }
        //3  4  8
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<String,Integer> tmp = minHeap.poll();
            ret.add(tmp.getKey());//def ab gh
        }
        Collections.reverse(ret);//gh  ab  def
        return ret;
    }




}
