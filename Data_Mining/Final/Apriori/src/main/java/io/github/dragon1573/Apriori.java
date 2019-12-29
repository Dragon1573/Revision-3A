package io.github.dragon1573;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * <h1>Pseudo Apriori</h1>
 *
 * <p>&emsp;&emsp;Apriori算法是一种用于在数据库记录中挖掘频繁项集的方法。此处的算法以Apriori为基础，对其中的算法进行了简化以方便编程实现。</p>
 *
 * <p>但请注意，由于这种简化，使得算法在面对巨量数据库时会产生指数级的运算量爆炸。</p>
 *
 * @author Dragon1573
 */
public class Apriori {
    private static final int RADIX = 2;
    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("请输入数据库（*.csv）的路径：");
            final File csvFile = new File(scanner.nextLine());
            final List<Set<String>> database = readCsv(csvFile);
            final Set<String> maxItemSet = getAllElements(database);
            final List<Set<String>> subSets = getAllSubsets(maxItemSet);
            System.out.print("请输入最小支持度：");
            final int minimumSupportCount = scanner.nextInt();
            Map<Set<String>, Integer> frequentItemSets = getFrequentItemSets(subSets,
                database, minimumSupportCount
            );
            System.out.println("\n频繁项集为：");
            for (final Set<String> frequentPattern : frequentItemSets.keySet()) {
                System.out.println(frequentPattern.toString() + ": " + frequentItemSets
                    .get(frequentPattern));
            }
        } catch (FileNotFoundException e) {
            System.err.println("[ERROR] 数据库读取异常！");
            e.printStackTrace();
        }
    }

    /**
     * 从CSV文件读取数据记录，时间复杂度为 O(n) 。
     *
     * @param csvFile
     *     CSV文件对象
     *
     * @return 数据库对象
     */
    public static List<Set<String>> readCsv(final File csvFile)
        throws FileNotFoundException {
        List<Set<String>> database = new ArrayList<>();
        try (Scanner scanner = new Scanner(csvFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split(DELIMITER);
                Set<String> transaction = new HashSet<>(Arrays.asList(items));
                database.add(transaction);
            }
        }
        return database;
    }

    /**
     * 获取最长项集，时间复杂度为 O(n) 。
     *
     * @param database
     *     数据库对象
     *
     * @return 由数据库中所有记录包含的所有项组成的最长项集
     */
    public static Set<String> getAllElements(final List<Set<String>> database) {
        Set<String> itemSet = new HashSet<>();
        for (Set<String> transaction : database) {
            // 在重复的添加过程中，
            itemSet.addAll(transaction);
        }
        return itemSet;
    }

    /**
     * @param rawSet
     *     原始的集合
     *
     * @return 所有子集（不包括空集）组成的列表
     */
    public static List<Set<String>> getAllSubsets(final Set<String> rawSet) {
        // 将集合转换为对应的数组，用于按索引提取元素
        final String[] rawList = new String[rawSet.size()];
        rawSet.toArray(rawList);
        List<Set<String>> subSets = new ArrayList<>();
        // 二进制穷举法获取所有子集（不包括空集）
        for (int i = 0b1; i < Math.pow(RADIX, rawSet.size()); i++) {
            final String binaryChoice = String.format("%5s", Integer.toBinaryString(i));
            // 根据二进制串提取元素
            Set<String> subSet = new HashSet<>();
            for (int j = 0; j < binaryChoice.length(); j++) {
                if ('1' == binaryChoice.toCharArray()[j]) {
                    // 当标记为1时，提取元素
                    subSet.add(rawList[binaryChoice.length() - j - 1]);
                }
            }
            subSets.add(subSet);
        }
        return subSets;
    }

    /**
     * 根据数据库统计所有子集的支持度，并忽略未达到最小支持度的项集
     *
     * @param subSets
     *     所有可能的子项集
     * @param database
     *     数据库
     * @param minSup
     *     最小支持度
     *
     * @return 所有频繁项集及其支持度
     */
    public static Map<Set<String>, Integer> getFrequentItemSets(
        final List<Set<String>> subSets, final List<Set<String>> database,
        final int minSup
    ) {
        Map<Set<String>, Integer> frequentSets = new HashMap<>(subSets.size());
        for (final Set<String> itemSet : subSets) {
            // 统计项集的支持度
            int supportCount = 0;
            for (final Set<String> transaction : database) {
                if (transaction.containsAll(itemSet)) {
                    // 项集存在于特定的记录中
                    supportCount++;
                }
            }
            // 检查是否为频繁项集
            if (supportCount >= minSup) {
                frequentSets.put(itemSet, supportCount);
            }
        }
        return frequentSets;
    }
}
