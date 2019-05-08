package sort;

import java.io.InputStream;
import java.util.*;

/**
 * 蜜蜂采花，输入五个点的坐标，算出最短路径长度
 *
 * */
public class BeeRoad {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        Scanner scanner = new Scanner(inputStream);
        Map<String, Point> points = new HashMap<>();
        String[] names = new String[]{"A", "B", "C", "D", "E"};
        zuhe("ABCDE".toCharArray(), "ABCDE".length(), 0);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] array = line.split(" ");
            for (int i = 0; i < 5; i++) {
                Point point = new Point(Integer.valueOf(array[i * 2]), Integer.valueOf(array[i * 2 + 1]));
                points.put(names[i], point);
            }
            break;
        }
        Point zero = new Point(0, 0);
        double min = 0;
        for (String str : list) {
            char[] route = str.toCharArray();
            double sum = getPathLength(zero, points.get(route[0] + "")) +
                    getPathLength(points.get(route[0] + ""), points.get(route[1] + "")) +
                    getPathLength(points.get(route[1] + ""), points.get(route[2] + "")) +
                    getPathLength(points.get(route[2] + ""), points.get(route[3] + "")) +
                    getPathLength(points.get(route[3] + ""), points.get(route[4] + "")) +
                    getPathLength(points.get(route[4] + ""), zero);
            if (min == 0) {
                min = sum;
            }
            if (min >= sum) {
                min = sum;
            }
        }
        System.out.println(Math.round(min));
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static double getPathLength(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static void zuhe(char[] array, int n, int k) {
        if (n == k) {
            String str = new String(array);
            list.add(str);
        } else {
            for (int i = k; i < n; i++) {
                swap(array, k, i);
                zuhe(array, n, k + 1);
                swap(array, i, k);
            }
        }
    }

    public static void swap(char[] a, int x, int y) {
        char temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
