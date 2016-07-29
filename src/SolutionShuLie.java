public class SolutionShuLie {
    public int Fibonacci(int n) {
       int one=0;
       int two=1;
        int sumleft=0;
        if(n<2){
            return n;
        }
        for(int i=2;i<=n;i++){
            sumleft=one+two;
            one=two;
            two=sumleft;
        }
        return sumleft;
    }
}
//大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
//1.递归  n(0-开始)    n>1 时fn=f(n-1)+f(n-2)
//2.递归效率低  有大量的重复计算
//3.采用循环  f2=f0+f1   f0=f1  f1=f2  return f2;