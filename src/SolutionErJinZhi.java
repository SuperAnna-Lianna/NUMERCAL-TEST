/**
 * Created by luairan on 16/7/30.
 */
public class SolutionErJinZhi {

    /****不断的向右移位  判断与操作后是否为1   但有弊端,如果是有符号数,>>操作,会在最左端补1 陷入死循环****/
    public int NumberOf1(int n) {
        int count=0;
        while(n!=0){
            if((n&1)==1)
            count++;
            n=n>>1;
        }
        return count;
    }
    /****将1不断的左移(001,010,100),与二进制数相与操作,判断结果是否为0,如果为0说明那个位置没有1,****/

    public int NumberOf2(int n) {
        int count=0;
        int flag=0;
        while(flag!=0){
            if((n&flag)!=0)
            count++;
            flag=flag<<1;
        }
        return count;
    }

    /****最优解 一个二进制数 和 该数减1 的数相与就会变成0 不断的循环 ****/
    public int NumberOf3(int n) {
        int count=0;
        while(n!=0){
            count++;
            n= (n-1)&n;
        }
        return count;
    }

}
