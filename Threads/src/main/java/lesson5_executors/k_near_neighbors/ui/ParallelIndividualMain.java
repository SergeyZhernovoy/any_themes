package lesson5_executors.k_near_neighbors.ui;

import lesson5_executors.k_near_neighbors.Service.BankMarketingLoader;
import lesson5_executors.k_near_neighbors.concurrent_ver1.KnnClassifierParrallelIndividual;
import lesson5_executors.k_near_neighbors.data.BankMarketing;

import java.util.Date;
import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 09.11.2017.
 */

public class ParallelIndividualMain {
    public static void main(String[] args) {


        String path1 = SerialMain.class.getClassLoader().getResource("data/bank.data").getFile().substring(1);
        String path2 = SerialMain.class.getClassLoader().getResource("data/bank.test").getFile().substring(1);

        BankMarketingLoader loader = new BankMarketingLoader();
        List<BankMarketing> train = loader.load(path1);
        System.out.println("Train: " + train.size());
        List<BankMarketing> test = loader.load(path2);
        System.out.println("Test: " + test.size());
        double currentTime = 0.0d;
        int success = 0, mistakes = 0;
        int k = Integer.parseInt(args[0]);
        success = 0;
        mistakes = 0;
        KnnClassifierParrallelIndividual classifier = new KnnClassifierParrallelIndividual(
                train, k, 1, true);
        try {
            Date start, end;
            start = new Date();
            for (BankMarketing example : test) {
                String tag = classifier.classify(example);
                if (tag.equals(example.getTag())) {
                    success++;
                } else {
                    mistakes++;
                }
            }
            end = new Date();

            currentTime = end.getTime() - start.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        classifier.destroy();
        System.out.println("******************************************");
        System.out.println("Parallel Classifier Individual - K: " + k
                + " - Factor 1 - Parallel Sort: false");
        System.out.println("Success: " + success);
        System.out.println("Mistakes: " + mistakes);
        System.out.println("Execution Time: " + (currentTime / 1000)
                + " seconds.");
        System.out.println("******************************************");
    }
}

    