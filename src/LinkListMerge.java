/**
 * Created by luairan on 16/7/31.
 */
public class LinkListMerge {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode mergeAll(ListNode list1,ListNode list2) {
        ListNode sum;
        //排除list为空的的情况下出现空指针
        if(list1==null||list2==null){
            return list1==null?list2:list1;
        }
        if(list1.val<list2.val){
            ListNode temp=list1.next;
            list1.next=null;
            sum=list1;
            list1=temp;
        }else{
            ListNode temp=list2.next;
            list2.next=null;
            sum=list2;
            list2=temp;
        }
        ListNode sum2=sum;
        //取出（next置空）较小的值，更新原list（已删除较小值得list），更新sum到下个指针继续循环
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                ListNode temp=list1.next;//暂存下个list
                list1.next=null;
                sum.next=list1;
                list1=temp;
                sum=sum.next;
            }else{
                ListNode temp=list2.next;
                list2.next=null;
                sum.next=list2;
                list2=temp;
                sum=sum.next;
            }
        }


        if(list1==null){
            sum.next=list2;
        }else{
            sum.next=list1;
        }
        return sum2;

    }

    public static void main(String[] args) {
        //新建两个链表
        ListNode listNode = new ListNode(0);//指向头结点
        ListNode tem = listNode;//遍历新增结点
        ListNode listNode2 = new ListNode(2);
        ListNode tem2 = listNode2;

        //新建链表
        for (int i = 1; i < 10; i++) {
            ListNode newNode=new ListNode(i+2);
            tem.next=newNode;
            tem=tem.next;
            ListNode newNode2=new ListNode(i*3);
            tem2.next=newNode2;
            tem2=tem2.next;
        }

        ListNode query1=  listNode;//遍历查询结点
        ListNode query2=  listNode2;

        while(query1!=null){
            System.out.println(query1.val  +"  "+ query2.val);
            query1=query1.next;
            query2=query2.next;
        }


        ListNode mergeAll=   mergeAll(listNode,listNode2);


        while(mergeAll!=null){
            System.out.print(mergeAll.val+"  "  );
            mergeAll=mergeAll.next;
        }

    }


}
