package practice;

public class ahasuanfa {

    public static int[] array = new int[]{9, 2, 4, 3, 5, 6, 3, 0, 9, 90, 11, 3, 2};

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 2; j >= i; j--) {
                if (array[j] >= array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        quickSort(0, array.length - 1);

        for (int i : array) {
            System.out.println(i);
        }



    }

    public static void quickSort(int left, int right) {
        if (left > right) {
            return;
        }
        int temp = array[left];
        int i = left, j = right;
        while (i != j) {
            while (array[j] >= temp && i < j)
                j--;
            while (array[i] <= temp && i < j)
                i++;
            if (i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        array[left] = array[i];
        array[i] = temp;
        quickSort(left, i - 1);
        quickSort(i + 1, right);
        return;
    }
}
