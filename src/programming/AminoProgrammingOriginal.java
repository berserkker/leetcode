package programming;

public class AminoProgrammingOriginal {
    public static long ipv42Num(String ipv4) {
        int len = ipv4.length();
        if (len == 0) {
            System.out.println("error ipv4 string");
            return 0;
        }
        long result = 0l, temp = 0l;
        for (int i = 0; i < len; i++) {
            if (ipv4.charAt(i) >= '0' && ipv4.charAt(i) <= '9') {
                temp = temp * 10 + (ipv4.charAt(i) - '0');
            } else if (ipv4.charAt(i) == '.') {
                if (temp > 255) {
                    System.out.println("error ipv4 string");
                    return 0;
                }
                result = result << 8;
                result += temp;
                temp = 0;
            } else if (ipv4.charAt(i) == ' ' && temp != 0 &&
                    (i + 1 < len && ipv4.charAt(i + 1) != '.'
                            && ipv4.charAt(i + 1) != ' ')) {
                System.out.println("error ipv4 string");
                return 0;
            }
        }
        result = result << 8;
        result += temp;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(ipv42Num("172 . 168.5.1"));
        System.out.println(ipv42Num("17  2    . 168.5.1"));
        System.out.println(ipv42Num("288.255.255.255"));
        System.out.println(ipv42Num("172   .168   .5.1"));
        System.out.println(ipv42Num(""));
        System.out.println(ipv42Num("abc"));
        System.out.println(ipv42Num("   172   .168   .5  .  1  "));
    }
}
