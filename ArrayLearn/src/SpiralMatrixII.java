public class SpiralMatrixII {
    public int[][] generateMatrix(int n)
    {
        //首先创建指定维数的数组
        int[][] arr=new int[n][n];
        int val=1;
        //每一圈的起始点的x，y值
        int startX=0;
        int startY=0;

        int loop=1;// 每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理
        int offset=1;// 需要控制每一条边遍历的长度，每次循环右边界收缩一位
        int i,j;

        while(loop<=n/2)
        {
            //顶部：左闭右开，所以判断循环结束时， j 不能等于 n - offset
            for(j=startY;j<n-offset;j++)
            {
                arr[startX][j]=val++;
            }
            //右列:左闭右开，所以判断循环结束时， i 不能等于 n - offset
            for(i=startX;i<n-offset;i++)
            {
                arr[i][j]=val++;
            }
            //底部:左闭右开，所以判断循环结束时， j != startY
            for(;j>startY;j--)
            {
                arr[i][j]=val++;
            }
            //左列:左闭右开，所以判断循环结束时， i != startX
            for(;i>startX;i--)
            {
                arr[i][j]=val++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }
        if (n%2==1)// n 为奇数时，单独处理矩阵中心的值
        {
            arr[startX][startY]=val;
        }
        return arr;
    }

    public static void main(String[] args)
    {
        SpiralMatrixII sm=new SpiralMatrixII();
        int[][] arr=sm.generateMatrix(3);
        System.out.println("[");
        for (int i=0;i<arr.length;i++)
        {
            System.out.print("[ ");
            for (int j=0;j<arr[i].length;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(" ]");
        }
        System.out.println("]");

        int[][] arr2=sm.generateMatrix(4);
        System.out.println("[");
        for (int i=0;i<arr2.length;i++)
        {
            System.out.print("[ ");
            for (int j=0;j<arr2[i].length;j++)
            {
                System.out.print(arr2[i][j]+" ");
            }
            System.out.println(" ]");
        }
        System.out.println("]");
    }
}

/*笔记：
这道题关键坚持循环不变量原则。
填充分四种情况讨论：
                填充上行从左到右
                填充右列从上到下
                填充下行从右到左
                填充左列从下到上
每条边遵循左闭右开原则。
奇数最中间元素单独处理。
**/