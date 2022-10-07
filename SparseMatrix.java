package dataStructure;

public class SparseMatrix {
    public static void main(String[] args) {
        int chessArray1[][] = new int[11][11];
        //无子放0，黑子放1，白子放2
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;

        //棋盘初始化，并打印输出
        int sum = 0;
        for (int[] row : chessArray1) {
            for (int data : row) {
                if (data > 0)
                    sum++;
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println(sum);

        //将矩阵转为稀疏矩阵
        int sparseArray[][] = new int[sum + 1][3];
        //第一行存放长宽和非0元个数
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[1][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1.length; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }

        //输出稀疏矩阵
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将稀疏矩阵还原成原矩阵
        int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //输出转换后的原矩阵
        for (int[] row : chessArray1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}

