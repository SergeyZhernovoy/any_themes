package lesson5_executors.k_near_neighbors.concurrent_ver1;

import lesson5_executors.k_near_neighbors.data.Distance;
import lesson5_executors.k_near_neighbors.EuclideanDistanceCalculator;
import lesson5_executors.k_near_neighbors.data.Sample;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Sergey Zhernovoy
 * create on 07.11.2017.
 */

public class KnnClassifierParrallelIndividual {

    private List<? extends Sample> dataSet;
    private int k;
    private ThreadPoolExecutor executor;
    private int numThreads;
    private boolean parallelSort;


    public KnnClassifierParrallelIndividual(List<? extends Sample> dataSet, int k, int factor, boolean parallelSort) {
        this.dataSet = dataSet;
        this.k = k;
        this.numThreads = factor * (Runtime.getRuntime().availableProcessors());
        this.parallelSort = parallelSort;
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numThreads);
    }

    public String classify(Sample example){

        Distance[] distance = new Distance[this.dataSet.size()];
        CountDownLatch endController = new CountDownLatch(this.dataSet.size());

        int index = 0;

        for(Sample localExample : this.dataSet){

            IndividualDistanceTask task = new IndividualDistanceTask(distance,index,localExample,example,endController);

            distance[index] = new Distance();
            distance[index].setIndex(index);
            distance[index++].setDistance(EuclideanDistanceCalculator.calculate(localExample,example));
        }

        Arrays.sort(distance);

        Map<String, Integer> result = new HashMap<>();
        for(int i = 0; i < k ; i++){
            Sample localeExample = this.dataSet.get(distance[i].getIndex());
            String tag = localeExample.getTag();
            result.merge(tag,1,(a,b)->a+b);
        }

        return Collections
                .max(result.entrySet(),Map.Entry.comparingByValue())
                .getKey();
    }

}

    