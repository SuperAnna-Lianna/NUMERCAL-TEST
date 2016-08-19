package sort;

/**
 * Created by luairan on 16/8/16.
 */
public class SelectionSort {
    public static void main(String[] args) {
        Integer[] a={1,9,3,5,7,3,5,4,2,8,4};
        for (int i=0;i<a.length-1;i++){
            int max=a[i];
            for (int j=i;j<a.length;j++){
                if(a[j]>max){
                    max=a[j];
                    int tmp=a[j];
                    a[j]=a[i];
                    a[i]=tmp;
                }
            }
        }
        for (Integer c:a){
            System.out.println(c);
        }
    }
}
