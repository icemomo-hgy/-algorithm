package Test;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: Test
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/9 15:08
 * @Description: 八皇后问题
 * @since JDK 1.8
 */
public class EightQueen {
    int max  = 8;
    int [] array = new int[max];
    static int current = 0;

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.aside(0);
        System.out.println(current);
    }

        public void aside(int n){
        if(n == max){
            look();
            current++;
            return;
        }else {
            for (int i = 0; i < max; i++) {
                array[n] = i;
                if(cheek(n)){
                    aside(n+1);
                }
            }
        }

        }
        public  boolean cheek(int n ){
            for (int i = 0; i < n; i++) {
                if (array[i] == array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                    return false;
                }

            }
            return true;
        }
        public void  look(){

            for (int i: array) {
                System.out.print(i);
            }
            System.out.println("");
        }

}
