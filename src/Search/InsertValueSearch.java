package Search;

import java.util.ArrayList;

/**
 * @BelongsProject: 数据结构
 * @BelongsPackage: Search
 * @Auther: i.gy@outlook.com
 * @Date: 2022/5/22 16:10
 * @Description:
 * @since JDK 1.8
 */
public class InsertValueSearch {
    ArrayList<Integer> InSertValueSearchDemo(int[]array,int left,int right,int value){
        int mid = left + (right - left)* (value - array[left])/ (array[right]-array[left]);
        System.out.println("执行了");
        if(left>right||value<array[0]|| value>array[array.length-1]){
            return null;
        }
        if(value>array[mid]){
            return InSertValueSearchDemo(array,mid+1,right,value);
        }else if(value<array[mid]){
            return InSertValueSearchDemo(array,left,mid-1,value);
        }else {
            ArrayList arrayList = new ArrayList();
            int temp = mid-1;
            if(temp>=0&&array[temp]==value){
                arrayList.add(temp);
                temp--;
            }
            arrayList.add(mid);
            temp = mid+1;
            if(temp<=right&&array[temp]==value){
                arrayList.add(temp);
                temp++;
            }
            return arrayList;
        }

    }

    public static void main(String[] args) {
        int[]arr = new int[100];
        for (int i = 0; i < 100; i++) {
            if (i == 31){continue;}
            arr[i]=i;
        }
        InsertValueSearch insertValueSearch = new InsertValueSearch();
        ArrayList<Integer> integers = insertValueSearch.InSertValueSearchDemo(arr, 0, arr.length - 1, 31);
        System.out.println(integers);
    }
}
