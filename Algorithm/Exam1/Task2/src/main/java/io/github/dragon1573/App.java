package io.github.dragon1573;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Hello world!
 *
 * @author Dragon1573
 */
public class App {
    /**
     * <p>The queuing crowd.</p>
     *
     * <p>
     * Here, {@link java.util.Queue} is an interface and could be used directly. Fortunately, {@link
     * java.util.LinkedList} provides an available class which can be used as a queue.
     * </p>
     */
    private static Queue<Integer> queue = new LinkedList<>();
    /**
     * A customer counter.
     */
    private static int number = 0;

    /**
     * Take a number from the system.
     *
     * @return String[]
     */
    static int[] takeNumber() {
        ++number;
        queue.add(number);
        System.out.println("您的排队号码为：" + number + "，当前还有" + (queue.size() - 1) + "人在前面等待。");
        return new int[] {number, queue.size() - 1};
    }

    /**
     * A number is called by the system.
     *
     * @return int
     */
    static int callNumber() {
        if (queue.isEmpty()) {
            System.err.println("列表空，请先取号！");
            return -1;
        } else {
            System.out.println("请" + queue.peek() + "号顾客用餐！");
            return queue.remove();
        }
    }

    /**
     * The main function.
     *
     * @param args
     *     - Command line parameters
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎使用顾客叫号系统！");
            System.out.println("1. 取号\t2. 叫号\t3. 退出");
            int choice = scanner.nextInt();
            if (choice == 1) {
                takeNumber();
            } else if (choice == 2) {
                callNumber();
            } else {
                break;
            }
            System.out.println();
        }
        scanner.close();
        System.out.println("感谢您使用本系统，再见！");
        // 清理静态成员变量
        queue.clear();
        queue = null;
        number = 0;
    }
}
