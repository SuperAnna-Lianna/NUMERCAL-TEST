public class LinkListUtli {
//链表的逆置   现将链表的第一个元素L 和 其他元素p 分离开来(设置L.next.next=null),
//            不断的把p元素当中的节点指向L链表中的头部,同时更新原链表的链表头
//            需要一个临时变量存储 未插入头结点的尾部链表


    public static LNode reverse(LNode head) {
        //单链表为空或只有头结点或只有一个元素，不用进行逆置操作
        if (head == null || head.next == null)
            return head;

        LNode work = head;
        LNode current = work.next;
        work.next = null;
        while (current != null) {
            LNode temp = current.next;
            //将p插入头结点之后
            current.next = work;
            work = current;//更新原链表
            current = temp;//继续访问下一个元素
        }
        return work;
    }




    public static void main(String[] args) {

        LNode lNode = new LNode();

        LNode head = lNode;

        lNode.data = 0;
        for (int i = 1; i < 10; i++) {
            LNode pre = lNode;
            lNode = new LNode();
            lNode.data = i;
            pre.next = lNode;
        }

        LNode work = head;
        while (work != null) {
            System.out.print(work.data + " ");
            work = work.next;
        }

        work = head;
        work = reverse(work);
        System.out.println();
    }



    //单链表的结点类
    static class LNode {
        //为了简化访问单链表，结点中的数据项的访问权限都设为public
        public int data;
        public LNode next;
    }
}

