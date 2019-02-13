package sort;

public class BubbleSort {
    private static int[] array = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2, 11, 0};

    /**
     * 冒泡排序 最坏时间复杂度n^2 最好时间复杂度n
     *
     * 从最后开始排序，把最小的浮上去，然后第一个是最小的，继续比较剩下的，以此类推
     *
     * */
    public static int[] bubbleSort() {
        boolean flag = true;
        for (int i = 0; i < array.length && flag; i++) {
            for (int j = array.length - 2; j >= i; j--) {
                flag = false;
                //有数据交换才继续排序，没有数据交换说明已经是有序的了
                if (array[j] >= array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println("-----------冒泡排序------------");
        printArray(bubbleSort());
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }
}
