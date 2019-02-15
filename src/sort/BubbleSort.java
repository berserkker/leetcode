package sort;

public class BubbleSort {
    private static int[] array = new int[]{9, 1, 5, 8, 1, 10, 3, 7, 4, 6, 2, 11, 0};
    private static int length = array.length;

    /**
     * 冒泡排序 最坏时间复杂度n^2 交换n^2次  最好时间复杂度n 没有交换
     * <p>
     * 从最后开始排序，把最小的浮上去，然后第一个是最小的，继续比较剩下的，以此类推
     */
    public static int[] bubbleSort() {
        boolean flag = true;
        for (int i = 0; i < length && flag; i++) {
            for (int j = length - 2; j >= i; j--) {
                flag = false;
                //有数据交换才继续排序，没有数据交换说明已经是有序的了
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
        }
        return array;
    }

    /**
     * 简单选择排序 最坏和最好时间复杂度都为n^2  最坏交换n-1次 最好交换0次
     * <p>
     * 从第一位开始，存储一个最小值序号，与后面n-1位比较，小的话最小值重新赋值为那个小的序号，最后将两个值作交换
     */
    public static int[] simpleChooseSort() {
        int min;
        for (int i = 0; i < length - 1; i++) {
            min = i;
            for (int j = i + 1; j < length - 1; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }

    /**
     * 直接插入排序 最好时间复杂度O(n) 最坏时间复杂度O(n^2) 空间复杂度O(1)
     * <p>
     * 从第一位开始，取下一个元素比较后形成一个有序的数组，再取第三个元素从前面的有序数组的最后一位开始比较，若比其小，
     * 则将被比较元素后移，直到找到要插入的位置
     */
    public static int[] straightInsertSort() {
        //外循环从第二个元素开始
        for (int i = 1; i < length; i++) {
            int key = array[i];
            int j;
            //从前面数组的最后一个元素开始比较
            for (j = i - 1; j >= 0; j--) {
                //如果该元素比未比较的元素大，则将该元素右移，继续比较  否则停止比较，即找到了在有序数组中的位置
                if (array[j] > key) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            //将该元素插入有序数组
            array[j + 1] = key;
            /*int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;*/
        }
        return array;

    }

    public static void main(String[] args) {
//        System.out.println("-----------冒泡排序------------");
//        printArray(bubbleSort());
//        System.out.println("-----------选择排序------------");
//        printArray(simpleChooseSort());
        System.out.println("-----------直接插入排序------------");
        printArray(straightInsertSort());
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }
}
