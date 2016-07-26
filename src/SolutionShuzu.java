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
}
//解题思路:  1.分析题目逻辑, 数字的左上一定小于该数,数字的右下一定大于该数.
//