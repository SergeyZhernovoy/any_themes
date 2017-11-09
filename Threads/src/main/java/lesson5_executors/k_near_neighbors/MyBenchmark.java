package lesson5_executors.k_near_neighbors;/**
 * @author Sergey Zhernovoy
 * create on 10.11.2017.
 */

import lesson5_executors.k_near_neighbors.Service.BankMarketingLoader;
import lesson5_executors.k_near_neighbors.concurrent_ver1.KnnClassifierParrallelIndividual;
import lesson5_executors.k_near_neighbors.concurrent_ver2.KnnClassifierParallelGroup;
import lesson5_executors.k_near_neighbors.data.BankMarketing;
import lesson5_executors.k_near_neighbors.serial.KnnClassifier;
import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class MyBenchmark {

    @Param({ "10", "30", "50" })
    public int size;

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Fork(1)
    @Warmup(iterations = 10, time = 1, batchSize = 1)
    @Measurement(iterations = 10, time = 1, batchSize = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void serialMain() {
        BankMarketingLoader loader = new BankMarketingLoader();
        List<BankMarketing> train = loader.load("data\\bank.data");
        System.out.println("Train: " + train.size());
        List<BankMarketing> test = loader.load("data\\bank.test");
        System.out.println("Test: " + test.size());
        int success = 0, mistakes = 0;
        int k = size;

        success = 0;
        mistakes = 0;
        KnnClassifier classifier = new KnnClassifier(train, k);
        try {

            for (BankMarketing example : test) {
                String tag = classifier.classify(example);
                if (tag.equals(example.getTag())) {
                    success++;
                } else {
                    mistakes++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("******************************************");
        System.out.println("Serial Classifier - K: " + k);
        System.out.println("Success: " + success);
        System.out.println("Mistakes: " + mistakes);
        System.out.println("******************************************");
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Fork(1)
    @Warmup(iterations = 10, time = 1, batchSize = 1)
    @Measurement(iterations = 10, time = 1, batchSize = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void parallelIndividualMain() {
        BankMarketingLoader loader = new BankMarketingLoader();
        List<BankMarketing> train = loader.load("data\\bank.data");
        System.out.println("Train: " + train.size());
        List<BankMarketing> test = loader.load("data\\bank.test");
        System.out.println("Test: " + test.size());
        int success = 0, mistakes = 0;
        int k = size;
        success = 0;
        mistakes = 0;
        KnnClassifierParrallelIndividual classifier = new KnnClassifierParrallelIndividual(train, k, 1, false);
        try {
            for (BankMarketing example : test) {
                String tag = classifier.classify(example);
                if (tag.equals(example.getTag())) {
                    success++;
                } else {
                    mistakes++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        classifier.destroy();
        System.out.println("******************************************");
        System.out.println("Parallel Classifier Individual - K: " + k + " - Factor 1 - Parallel Sort: false");
        System.out.println("Success: " + success);
        System.out.println("Mistakes: " + mistakes);
        System.out.println("******************************************");

    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Fork(1)
    @Warmup(iterations = 10, time = 1, batchSize = 1)
    @Measurement(iterations = 10, time = 1, batchSize = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void parallelIndividualMainSort() {
        BankMarketingLoader loader = new BankMarketingLoader();
        List<BankMarketing> train = loader.load("data\\bank.data");
        System.out.println("Train: " + train.size());
        List<BankMarketing> test = loader.load("data\\bank.test");
        System.out.println("Test: " + test.size());
        int success = 0, mistakes = 0;
        int k = size;
        success = 0;
        mistakes = 0;
        KnnClassifierParrallelIndividual classifier = new KnnClassifierParrallelIndividual(train, k, 1, true);
        try {
            for (BankMarketing example : test) {
                String tag = classifier.classify(example);
                if (tag.equals(example.getTag())) {
                    success++;
                } else {
                    mistakes++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        classifier.destroy();
        System.out.println("******************************************");
        System.out.println("Parallel Classifier Individual - K: " + k + " - Factor 1 - Parallel Sort: true");
        System.out.println("Success: " + success);
        System.out.println("Mistakes: " + mistakes);
        System.out.println("******************************************");

    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Fork(1)
    @Warmup(iterations = 10, time = 1, batchSize = 1)
    @Measurement(iterations = 10, time = 1, batchSize = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void parallelGroupMain() {
        BankMarketingLoader loader = new BankMarketingLoader();
        List<BankMarketing> train = loader.load("data\\bank.data");
        System.out.println("Train: " + train.size());
        List<BankMarketing> test = loader.load("data\\bank.test");
        System.out.println("Test: " + test.size());
        int success = 0, mistakes = 0;
        int k = size;

        success = 0;
        mistakes = 0;
        KnnClassifierParallelGroup classifier = new KnnClassifierParallelGroup(train, k, 1, false);
        try {
            for (BankMarketing example : test) {
                String tag = classifier.classify(example);
                if (tag.equals(example.getTag())) {
                    success++;
                } else {
                    mistakes++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        classifier.destroy();

        System.out.println("******************************************");
        System.out.println("Parallel Classifier Group - K: " + k + " - Factor 1 - Parallel Sort: false");
        System.out.println("Success: " + success);
        System.out.println("Mistakes: " + mistakes);
        System.out.println("******************************************");
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    @Fork(1)
    @Warmup(iterations = 10, time = 1, batchSize = 1)
    @Measurement(iterations = 10, time = 1, batchSize = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void parallelGroupMainSort() {
        BankMarketingLoader loader = new BankMarketingLoader();
        List<BankMarketing> train = loader.load("data\\bank.data");
        System.out.println("Train: " + train.size());
        List<BankMarketing> test = loader.load("data\\bank.test");
        System.out.println("Test: " + test.size());
        int success = 0, mistakes = 0;
        int k = size;

        success = 0;
        mistakes = 0;
        KnnClassifierParallelGroup classifier = new KnnClassifierParallelGroup(train, k, 1, true);
        try {
            for (BankMarketing example : test) {
                String tag = classifier.classify(example);
                if (tag.equals(example.getTag())) {
                    success++;
                } else {
                    mistakes++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        classifier.destroy();

        System.out.println("******************************************");
        System.out.println("Parallel Classifier Group - K: " + k + " - Factor 1 - Parallel Sort: true");
        System.out.println("Success: " + success);
        System.out.println("Mistakes: " + mistakes);
        System.out.println("******************************************");

    }

}

    