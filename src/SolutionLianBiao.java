import java.util.ArrayList;

public class SolutionLianBiao {
    
          public class ListNode {
              int val;
              ListNode next = null;
      
              ListNode(int val) {
                  this.val = val;
              }
          }
      

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList list=new ArrayList<Integer>();
            ListNode testNode=listNode;
            if(testNode!=null){
                if(testNode.next!=null){
                    list= printListFromTailToHead(testNode.next);
                }
                list.add(testNode.val);
            }
            return list;
        }
}
