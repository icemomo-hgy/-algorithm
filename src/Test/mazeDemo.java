package Test;
//迷宫递归
public class mazeDemo {
    public static void main(String[] args) {
        //初始化迷宫
        int[][] map = new int[8][8];
        for (int i = 0; i <map[0].length ; i++) {
            map[0][i] = 1;
            map[map.length-1][i] = 1;
        }
        for (int i = 0; i <map.length ; i++) {
            map[i][0] = 1;
            map[i][map.length-1] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
        map[2][3] = 1;

            getWay(map,1,1);

        for (int[] i:map) {
            for (int s:i) {
                System.out.print(s);
            }
            System.out.println("");
        }


    }
    public static boolean getWay(int[][] map, int i, int j){
        if(map[6][6]==2){
            return true;
        }else {
            if(map[i][j]==0){
                map[i][j] = 2;
                if(getWay(map,i+1,j)){
                    return true;
                }else if(getWay(map,i,j+1)){
                    return true;
                }else if(getWay(map,i-1,j)){
                    return true;
                }else if(getWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false;
            }

        }


    }


}
