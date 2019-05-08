package programming;

public class AminoProgrammingWithTest {
    public static void main(String[] args) {

        String firstUnitTest = "";
        String secondUnitTest = "17 2.168.5.1";
        String thirdUnitTest = "172  .  168   . 5  .1  ";
        String fourthUnitTest = "288.288.1.2";
        String fifthUnitTest = "17a.b.c.d";

        if (verifyIpv4Str(firstUnitTest)) {
            System.out.println("firstUnitTest \"\" run result : " + get32NumFromIpv4(firstUnitTest));
        } else {
            System.out.println("firstUnitTest \"\" run result : please input correct ipv4!");
        }

        if (verifyIpv4Str(secondUnitTest)) {
            System.out.println("firstUnitTest \"17 2.168.5.1\" run result : " + get32NumFromIpv4(secondUnitTest));
        } else {
            System.out.println("secondUnitTest \"17 2.168.5.1\" run result : please input correct ipv4!");
        }

        if (verifyIpv4Str(thirdUnitTest)) {
            System.out.println("firstUnitTest \"172  .  168   . 5  .1  \" run result : " + get32NumFromIpv4(thirdUnitTest));
        } else {
            System.out.println("thirdUnitTest \"172  .  168   . 5  .1  \" run result : please input correct ipv4!");
        }

        if (verifyIpv4Str(fourthUnitTest)) {
            System.out.println("firstUnitTest \"288.288.1.2\" run result : " + get32NumFromIpv4(fourthUnitTest));
        } else {
            System.out.println("fourthUnitTest \"288.288.1.2\" run result : please input correct ipv4!");
        }

        if (verifyIpv4Str(fifthUnitTest)) {
            System.out.println("firstUnitTest \"17a.b.c.d\" run result : " + get32NumFromIpv4(fifthUnitTest));
        } else {
            System.out.println("fifthUnitTest \"17a.b.c.d\" run result : please input correct ipv4!");
        }

    }

    public static Long get32NumFromIpv4(String str) {
        String[] ipv4Arrays = str.split("\\.");
        int result = Integer.valueOf(ipv4Arrays[0].trim()) << 24 | Integer.valueOf(ipv4Arrays[1].trim()) << 16 |
                Integer.valueOf(ipv4Arrays[2].trim()) << 8 | Integer.valueOf(ipv4Arrays[3].trim()) << 0;
        return (Long.parseLong(Integer.toBinaryString(result), 2));
    }

    public static boolean verifyIpv4Str(String str) {
        String part = "\\s*(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])\\s*";
        String pattern = part + "(\\." + part + "){3}";
        if (str.matches(pattern)) {
            return true;
        }
        return false;
    }
}
