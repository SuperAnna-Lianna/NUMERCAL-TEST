public class LinkListUtli{  
    public static void reverse(LNode L){  
        //单链表为空或只有头结点或只有一个元素，不用进行逆置操作  
        if(L==null||L.next==null||L.next.next==null)  
            return;  
        LNode p=L.next.next;//令p指向线性表中第2个元素a2   
        L.next.next=null;//令线性表中第1个元素a1的next为空  
        while(p!=null){  
            LNode q=p.next;  
            //将p插入头结点之后  
            p.next=L.next;  
            L.next=p;  
            p=q;//继续访问下一个元素  
        }  
          
    }  
}  
