package Leetcode;

import java.lang.reflect.Array;

/**
 * description: 稀疏数组  将棋盘的二维数组压缩
 * author: 黄冠瑛
 * date: 2022/9/9 14:02
 */
public class simpleArray {
    //二维数组 转 稀疏数组
    public static int[][] getSimpleArrat(int[][] array){
        //非0 的总数
        int sum=0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                    if(array[i][j]!=0){sum++;}
            }
        }
        //创建稀疏数组
        int[][] simpleArray=new int[sum+1][3];
        //稀疏数组第一行记录数组的长度信息
        simpleArray[0][0] =  array.length;
        simpleArray[0][1] =  array[0].length;
        simpleArray[0][2] = sum;
        for (int i = 0,count=1; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j]!=0){
                    simpleArray[count][0] = i;
                    simpleArray[count][1] = j;
                    simpleArray[count][2] = array[i][j];
                    count++;
                }
            }
        }
        return simpleArray;
    }


    //稀疏数组 装二维数组
    public static  int[][] getArray(int[][] array){
        int[][] resArray = new int[array[0][0]][array[0][1]];

        for (int i = 1; i < array.length; i++) {
                    resArray[array[i][0]][array[i][1]] =array[i][2];
        }

        return resArray;

    }
    private static void showArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]+",");
            }
            System.out.println();
        }
    }


    //测试
    public static void main(String[] args) {
       int[][] array = new int[10][10];
       //生成棋盘数组
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if((i==0&&j==1)||(i==2&&j==1)||(i==4&&j==4)||(i==5&&j==1)){
                    array[i][j]=1;
                }
            }
        }

        //遍历原始数组
//       showArray(array);
        int[][] simpleArrat = getSimpleArrat(array);
        //遍历稀疏数组
        showArray(simpleArrat);
        //还原数组 并遍历
        int[][] array1 = getArray(simpleArrat);
        showArray(array1);
    }
}
