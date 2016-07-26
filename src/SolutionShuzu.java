//题目:在一个二维数组中，每一行都按照从左到右递增的顺序排序，
// 每一列都按照从上到下递增的顺序排序。请完成一个函数，
// 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
public class SolutionShuzu {
    public boolean Find(int [][] array,int target) {
        int row=array.length-1;
        int col=0;
        while(row>=0&&col<array[0].length){
            if(array[row][col]>target){
                row--;
            }else if(array[row][col]<target){
                col++;
            }else if (array[row][col]==target){
                return true;
            }
        }
        return false;
    }

    public boolean Find2(int [][] array,int target) {
        int row=0;
        int col=array[0].length-1;
        while(col>=0&&row<array.length){
            if(array[row][col]>target){
                col--;
            }else if(array[row][col]<target){
                row++;
            }else if (array[row][col]==target){
                return true;
            }
        }
        return false;
    }
}
//解题思路:  1.分析题目逻辑, 数字的左上(包含所在行列)一定小于该数,数字的右下(包含所在行列)一定大于该数.
//          2.分析查找过程,当要查找的数字大于该数时 查找右方及左下方.小于该数时 查找左方及右上方.
//          3.确定开始查找的点,根据1,左下角的数字开始查找,比较容易排除了比其小的值.右上角开始查找,比较容易排除右下的值.
//          4.不断缩小范围,最后确定是否存在