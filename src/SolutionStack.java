import java.util.Stack;

public class SolutionStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(new Integer(node));
    }
    
    public int pop() {
          if(stack2.isEmpty()){
        while(!stack1.isEmpty()){
     	  stack2.push(stack1.pop());
            }
          }
     return  stack2.pop().intValue();
    }
}

//思路:  思路很简单: 栈先进后出,队列先进先出, stack2作为中间转换栈
//       注意一个坑: int,Integer之间相互转换   int->Integer   new  Integer(**)      Integer->int   .intValue()