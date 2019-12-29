package com.zhyoulun.apriori;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Apriori频繁模式挖掘算法
 *
 * @author zhyoulun
 * @author Dragon1573
 */
public class Apriori {
    private static final String SEPARATOR = ",";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("请输入数据库文件路径：");
            List<Set<String>> database = readCsv(scanner.nextLine());
            System.out.print("请输入最小支持度：");
            Map<Set<String>, Integer> frequentPatterns = apriori(
                database, scanner.nextInt());
            System.out.println("所有的频繁项集为：");
            for (Set<String> pattern : frequentPatterns.keySet()) {
                System.out.println(
                    pattern.toString() + "：" + frequentPatterns.get(pattern));
            }
        }
    }

    /**
     * 从CSV文件中读取数据
     *
     * @param path
     *     数据库文件路径
     *
     * @return 数据库对象
     */
    public static List<Set<String>> readCsv(final String path) {
        final File csvFile = new File(path);
        List<Set<String>> database = new ArrayList<>();
        try (Scanner scanner = new Scanner(csvFile)) {
            while (scanner.hasNextLine()) {
                final String row = scanner.nextLine();
                final String[] items = row.split(SEPARATOR);
                final Set<String> transaction = new HashSet<>(Arrays.asList(items));
                database.add(transaction);
            }
        } catch (FileNotFoundException e) {
            System.err.println("[ERROR] 数据库读取失败！");
            e.printStackTrace();
        }
        return database;
    }

    /**
     * @param database
     *     数据库对象
     *
     * @return 频繁项集及其支持度
     */
    public static Map<Set<String>, Integer> apriori(
        final List<Set<String>> database, final int minSupportCount
    ) {
        // 初始化总频繁项集
        Map<Set<String>, Integer> frequentPatternMap = new HashMap<>(database.size());
        // 初始化层级频繁项集
        Map<Set<String>, Integer> levelFrequentPatternMap = new HashMap<>(
            database.size());
        // 获取1频繁项集
        levelFrequentPatternMap.putAll(getOneFrequentPatternMap(database));
        // 并添加至总频繁项集
        frequentPatternMap.putAll(levelFrequentPatternMap);

        // 若层频繁项集存在且不是空集
        while (levelFrequentPatternMap.size() > 0) {
            // 生成下一层候选项集
            Map<Set<String>, Integer> candidatePatternMap = generate(
                levelFrequentPatternMap);
            // 扫描数据库，统计支持度
            for (final Set<String> transaction : database) {
                // 遍历候选项集中的每一个项集
                for (final Set<String> candidate : candidatePatternMap.keySet()) {
                    boolean flag = true;
                    // 遍历项集中的每一项
                    for (final String item : candidate) {
                        // 如果记录不包含特定项
                        if (!transaction.contains(item)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        candidatePatternMap.put(candidate,
                            candidatePatternMap.get(candidate) + 1
                        );
                    }
                }
            }

            // 从候选项集中筛选频繁项集
            levelFrequentPatternMap.clear();
            for (final Set<String> candidate : candidatePatternMap.keySet()) {
                int count = candidatePatternMap.get(candidate);
                if (count >= minSupportCount) {
                    levelFrequentPatternMap.put(candidate, count);
                }
            }

            // 合并频繁项集
            frequentPatternMap.putAll(levelFrequentPatternMap);
        }
        return frequentPatternMap;
    }

    /**
     * 获取1频繁项集
     *
     * @param database
     *     数据库
     *
     * @return 所有1频繁项集
     */
    private static Map<Set<String>, Integer> getOneFrequentPatternMap(
        final List<Set<String>> database
    ) {
        Map<Set<String>, Integer> oneFrequentPatterMap = new HashMap<>(database.size());
        // 扫描数据库
        for (final Set<String> transaction : database) {
            // 扫描记录
            for (final String item : transaction) {
                // 将单个元素转换为单元素项集
                final Set<String> pattern = new HashSet<>(List.of(item));
                /*
                 若1频繁项集中不存在当前项集，
                 则添加项集并置支持度为1，
                 否则支持度加1.
                 */
                oneFrequentPatterMap.merge(pattern, 1, Integer::sum);
            }
        }
        return oneFrequentPatterMap;
    }

    /**
     * 生成下一层候选项集
     *
     * @param levelFrequentPatternMap
     *     上一层频繁项集
     *
     * @return 候选项集
     */
    private static Map<Set<String>, Integer> generate(
        final Map<Set<String>, Integer> levelFrequentPatternMap
    ) {
        Map<Set<String>, Integer> candidatePatternMap = new HashMap<>(
            levelFrequentPatternMap.size());

        // 获取上一层的所有频繁项集
        final Set<Set<String>> candidatePatterns = levelFrequentPatternMap.keySet();
        // 对于每一个频繁项集
        for (final Set<String> patternA : candidatePatterns) {
            // 将频繁项集转换为数组
            String[] itemsA = new String[patternA.size()];
            patternA.toArray(itemsA);

            // 对于每一个频繁项集
            for (final Set<String> patternB : candidatePatterns) {
                // 将频繁项集转换为数组
                String[] itemsB = new String[patternB.size()];
                patternB.toArray(itemsB);

                boolean flag = true;
                for (int i = 0; i < itemsA.length - 1; i++) {
                    if (itemsA[i].compareTo(itemsB[i]) != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag && itemsA[itemsA.length - 1].compareTo(itemsB[itemsA.length - 1])
                            < 0) {
                    // 生成当前层的新候选项集
                    Set<String> items = new HashSet<>(patternA);
                    items.add(itemsB[itemsA.length - 1]);
                    // 删除候选项集中的非频繁项集
                    if (!hasInfrequentSubSet(items, levelFrequentPatternMap)) {
                        candidatePatternMap.put(items, 0);
                    }
                }
            }
        }
        return candidatePatternMap;
    }

    /**
     * 判断候选集是否为频繁项集
     *
     * @param items
     *     候选项集
     * @param levelFrequentPatternMap
     *     上层频繁项集
     *
     * @return 如果不是频繁项集，返回{@code true}；否则返回{@code false}
     */
    private static boolean hasInfrequentSubSet(
        final Set<String> items, final Map<Set<String>, Integer> levelFrequentPatternMap
    ) {
        // 提取候选项集的所有真子集
        for (final String itemA : items) {
            // 生成真子集
            Set<String> subSet = new HashSet<>();
            for (final String itemB : items) {
                if (!itemA.equals(itemB)) {
                    subSet.add(itemB);
                }
            }
            // 如果上层频繁项集中不存在此真子集，则候选项集本身不是频繁项集
            if (levelFrequentPatternMap.get(subSet) == null) {
                return true;
            }
        }
        return false;
    }
}
