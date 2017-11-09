package lesson5_executors.k_near_neighbors.concurrent_ver2;

import lesson5_executors.k_near_neighbors.data.Distance;
import lesson5_executors.k_near_neighbors.data.Sample;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Sergey Zhernovoy
 * create on 07.11.2017.
 */

public class KnnClassifierParallelGroup {

    private List<? extends Sample> dataSet;
    private int k;
    private ThreadPoolExecutor executor;
    private int numThreads;
    private boolean parallelSort;


    public KnnClassifierParallelGroup(List<? extends Sample> dataSet, int k, int factor, boolean parallelSort) {
        this.dataSet = dataSet;
        this.k = k;
        this.numThreads = factor * (Runtime.getRuntime().availableProcessors());
        this.parallelSort = parallelSort;
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numThreads);
    }

    public String classify(Sample example) throws InterruptedException {

        Distance[] distance = new Distance[this.dataSet.size()];
        CountDownLatch endController = new CountDownLatch(this.dataSet.size());

        int length =  dataSet.size() / numThreads;
        int startIndex = 0, endIndex = length;

        for(int index = 0 ; index < numThreads ; index++){
            GroupDistanceTask task = new GroupDistanceTask(distance,startIndex,endIndex,example,dataSet,endController);
            startIndex = endIndex;
            if(index < numThreads - 2){
                endIndex = endIndex + length;
            } else {
                endIndex = dataSet.size();
            }

        }
        endController.await();
        if(parallelSort){
            Arrays.parallelSort(distance);
        } else {
            Arrays.sort(distance);
        }

        Hashtable<String,Integer> results = new Hashtable<>();
        for(int i = 0; i < k ; i++){
            Sample localeExample = this.dataSet.get(distance[i].getIndex());
            String tag = localeExample.getTag();
            Integer counter = results.get(tag);
            if(counter == null){
                counter = new Integer(1);
                results.put(tag,counter);
            } else {
                counter++;
            }
        }

        Enumeration<String> keys = results.keys();
        int max = 0;
        String result = null;
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            int value = results.get(key);
            if(value > max){
                max = value;
                result = key;
            }
        }
        return result;
    }

    public void destroy(){
        executor.shutdown();
    }
}

    