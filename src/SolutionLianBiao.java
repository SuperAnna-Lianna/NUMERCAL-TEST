import java.util.ArrayList;
//输入一个链表，从尾到头打印链表每个节点的值。
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
//解题思路:  链表中的属性:本身,和他下一个结点
//         1.栈的形式(先进后出)   2.递归:  每次都去找结点的next结点,先保存后面的结点再保存自己的结点
//递归特点:重复执行,跳出重复的条件