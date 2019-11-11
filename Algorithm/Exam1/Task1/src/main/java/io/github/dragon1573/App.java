package io.github.dragon1573;

import java.util.Scanner;
import java.util.Stack;

/**
 * The Main Class
 *
 * @author Dragon1573
 */
public class App {
    /**
     * The Algorithm function
     *
     * @param decimal
     *     - A decimal number
     * @param base
     *     - The target base of result number
     *
     * @return String
     */
    static String dec2Any(int decimal, int base) {
        Stack<Integer> stack = new Stack<>();
        while (decimal != 0) {
            stack.push(decimal % base);
            decimal /= base;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            if (digit < 10) {
                builder.append(digit);
            } else {
                builder.append(Character.toChars(55 + digit));
            }
        }
        return builder.toString();
    }

    /**
     * The Main Function
     *
     * @param args
     *     - Command Line Parameters
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入整数数值：");
        int decimal = scanner.nextInt();
        System.out.print("请输入目标进制（2～36）：");
        int base = scanner.nextInt();
        scanner.close();
        String result = dec2Any(decimal, base);
        System.out.println("转换为" + base + "进制的结果为：" + result);
    }
}
