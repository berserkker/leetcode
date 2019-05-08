package programming;

import java.io.InputStream;
import java.util.Scanner;

/**
 * 有效的IPv地址，装换成整数
 * */
public class AminoProgramming {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        Scanner sc = new Scanner(inputStream);
        String ipv4 = "";
        while (sc.hasNext()) {
            ipv4 = sc.nextLine();
            if (!verifyIpv4Str(ipv4)) {
                System.out.println("please input correct ipv4!");
                continue;
            }
            break;
        }

        String[] ipv4Arrays = ipv4.split("\\.");
        int result = Integer.valueOf(ipv4Arrays[0].trim()) << 24 | Integer.valueOf(ipv4Arrays[1].trim()) << 16 |
                Integer.valueOf(ipv4Arrays[2].trim()) << 8 | Integer.valueOf(ipv4Arrays[3].trim()) << 0;
        System.out.println(Long.parseLong(Integer.toBinaryString(result), 2));

    }

    public static boolean verifyIpv4Str(String str) {
        String pattern = "(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])\\s*\\.\\s*(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])\\s*\\." +
                "\\s*(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])\\s*\\.\\s*(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])\\s*$";
        if (str.matches(pattern)) {
            return true;
        }
        return false;
    }
}
