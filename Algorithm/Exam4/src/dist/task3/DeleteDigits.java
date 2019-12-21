package task3;

import java.util.Scanner;

/**
 * 删数问题
 *
 * @author Dragon1573
 */
public class DeleteDigits {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("输入一个长正整数：");
            final String string = scanner.nextLine();
            System.out.print("输入需要删除的个数：");
            final int n = scanner.nextInt();
            System.out.println("最小值为：" + delete(string, n));
        }
    }

    /**
     * @param string
     *     数字字符串
     * @param n
     *     删除长度
     *
     * @return 最小数值
     */
    public static String delete(final String string, final int n) {
        if (n == 0) {
            return string;
        } else if (string.length() < n) {
            throw new IllegalArgumentException("删除长度越界！");
        } else if (string.length() == n) {
            throw new IllegalArgumentException("空数值");
        } else {
            int t = n, i = 0;
            char[] chars = string.toCharArray();
            while (t > 0 && i < string.length() - 1) {
                if (chars[i] > chars[i + 1]) {
                    if (chars.length - 1 - i >= 0) {
                        System.arraycopy(chars, i + 1, chars, i, chars.length - 1 - i);
                    }
                    i = -1;
                    t--;
                }
                i++;
            }
            return new String(chars).substring(0, chars.length - n);
        }
    }
}
