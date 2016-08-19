package sort;

/**
 * Created by luairan on 16/8/17.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {61, 98, 90, 46, 35, 25, 72, 14, 5, 45, 29, 81, 44};
        QuickSort sort = new QuickSort();
        sort.quick_sort(a, 0, a.length - 1);
        for (int c : a) {
            System.out.println(c);
        }
        System.out.println(a.length);
    }



    public void quick_sort(int[] arrays, int left, int right) {
        if (left >= right) return;

        char sign = 'r';
        int compare = arrays[left];
        int low = left;
        int high = right;

        while (left != right) {
            if (sign == 'r') {
                System.out.println("r:   " + left + "---" + right);
                if (arrays[right] < compare) {
                    arrays[left] = arrays[right];
                    left++;
                    sign = 'l';
                } else {
                    right--;
                }
                continue;
            }
            if (sign == 'l') {
                System.out.println("l: " + left + "---" + right);
                if (arrays[left] > compare) {
                    arrays[right] = arrays[left];
                    right--;
                    sign = 'r';
                } else {
                    left++;
                }
                continue;
            }
        }
        arrays[left] = compare;
        quick_sort(arrays, low, left - 1);
        quick_sort(arrays, left + 1, high);

    }




    public void qSort(int[] a, int start, int end) {
        int i = start + 1;
        int j = end;
        int temp = 0;
        while (i <= j) {
            while ( i <= j&&a[i] <= a[start])
                i++;
            while (j >= i&&a[j] >= a[start])
                j--;
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        if (start < end) {
            temp = a[start];
            a[start] = a[j];
            a[j] = temp;
            qSort(a, start, j - 1);
            qSort(a, j + 1, end);
        }
    }

}
