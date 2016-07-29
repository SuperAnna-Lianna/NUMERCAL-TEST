public class LinkListUtli{
//链表的逆置   现将链表的第一个元素L 和 其他元素p 分离开来(设置L.next.next=null),
//            不断的把p元素当中的节点指向L链表中的头部,同时更新原链表的链表头
//            需要一个临时变量存储 未插入头结点的尾部链表


    //单链表的结点类
    class LNode{
        //为了简化访问单链表，结点中的数据项的访问权限都设为public
        public int data;
        public LNode next;
    }

    public static void reverse(LNode L){  
        //单链表为空或只有头结点或只有一个元素，不用进行逆置操作  
        if(L==null||L.next==null||L.next.next==null)  
            return;
        LNode p=L.next.next;
        L.next.next=null;
            while(p!=null){
                LNode q=p.next;
                //将p插入头结点之后
                p.next=L.next;
                L.next=p;//更新原链表
                p=q;//继续访问下一个元素
            }

        }
}

