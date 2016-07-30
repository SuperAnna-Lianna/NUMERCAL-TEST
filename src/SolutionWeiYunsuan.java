
public class SolutionWeiYunsuan {
    //在excel中,用A表示 1 列,B 表示2 列.....z表示26列.AA表示27列,AB表示28列...请输入一个函数,如数字母,输出他是第几列

    //解题思路: 用A-Z表示成二十六进制数  转化为 十进制数(用0-9表示的).
    //         char形的A-Z转换为数字1-26, 采用change()方法,类比acsii码值递增
    public int change(char a){
        if(a=='A'){
            return 1;
        }
        return a-'A'+1;
    }

    public int getConlum(String string){
        int col=0;
        char[] charSet=string.toCharArray();
        for(int i=0;i<string.length();i++){
            col+=Math.pow(26,i)*change(charSet[string.length()-i-1]);
        }
        return col;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionWeiYunsuan().getConlum("BB"));
    }
}
