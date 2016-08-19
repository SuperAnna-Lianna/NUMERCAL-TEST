package sort;

/**
 * Created by luairan on 16/8/16.
 */
public class BubbleSort {
    public static void main(String[] args) {
        Integer[] a={1,9,3,5,7,3,5,4,2,8,4};
        for (int j=0;j<a.length-1;j++){
            for (int i=0;i<a.length-j-1;i++){
                if(a[i]>a[i+1]){
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                }
          }

        }
        for (Integer c:a){
            System.out.println(c);
        }
    }
}
