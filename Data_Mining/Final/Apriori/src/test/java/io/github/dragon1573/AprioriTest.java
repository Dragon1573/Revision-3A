package io.github.dragon1573;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Pseudo Apriori 测试类
 */
public class AprioriTest {
    private List<Set<String>> database;
    private Set<String> maxItemSet;
    private List<Set<String>> subSets;

    @Test
    public void AppTest() {
        try {
            readCsvTest();
            getAllElementTest();
            getAllSubSetsTest();
            getFrequentItemSetsTest();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readCsvTest() throws FileNotFoundException {
        System.out.println("-".repeat(55));
        System.out.println("CSV文件读取测试：");
        File csvFile = new File("src/main/resources/data.csv");
        database = Apriori.readCsv(csvFile);
        for (final Set<String> transaction : database) {
            System.out.println(transaction.toString());
        }
        System.out.println("-".repeat(55));
    }

    private void getAllElementTest() {
        System.out.println("-".repeat(55));
        System.out.println("最长项集提取测试：");
        maxItemSet = Apriori.getAllElements(database);
        System.out.println(maxItemSet.toString());
        System.out.println("-".repeat(55));
    }

    private void getAllSubSetsTest() {
        System.out.println("-".repeat(55));
        System.out.println("全子集提取测试：");
        subSets = Apriori.getAllSubsets(maxItemSet);
        for (final Set<String> subSet : subSets) {
            System.out.println(subSet.toString());
        }
        System.out.println("-".repeat(55));
    }

    private void getFrequentItemSetsTest() {
        System.out.println("-".repeat(55));
        System.out.println("频繁项集：");
        Map<Set<String>, Integer> frequentItemSets = Apriori.getFrequentItemSets(
            subSets, database, 2);
        for (final Set<String> frequentItemSet : frequentItemSets.keySet()) {
            System.out.println(frequentItemSet.toString() + ": " + frequentItemSets
                .get(frequentItemSet));
        }
    }
}
