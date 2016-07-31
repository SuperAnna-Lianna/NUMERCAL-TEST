import static java.lang.Integer.max;

/**
 * Created by luairan on 16/7/30.
 */
public class BeiBao {
    //M张券   N件奖品
    public int a(int M,int N){
        int[] need={2,3,1,4,6,5};
        int[] value={5,6,5,1,19,7};
        if(N<1){
            return 0;
        }
        if (M<0){
            return 0;
        }
        return max(a(M,N-1),a(M-need[N-1],N-1)+value[N-1]);
    }

    public int getcurrentVlue(int i,int j){
        int[] w={2,3,1,4,6,5};
        int[] v={5,6,5,1,19,7};
        if(i==0){
            if(j>=0) return 0;
        }
        if(j<0) return Integer.MIN_VALUE;
        return max (getcurrentVlue(i-1, j),getcurrentVlue(i-1, j-w[i-1])+v[i-1]);
    }

    public static void main(String[] args) {
        System.out.println(new BeiBao().getcurrentVlue(10,6));
    }

}
