package lesson5_executors.k_near_neighbors.concurrent_ver2;/**
 * @author Sergey Zhernovoy
 * create on 07.11.2017.
 */

import lesson5_executors.k_near_neighbors.EuclideanDistanceCalculator;
import lesson5_executors.k_near_neighbors.data.Distance;
import lesson5_executors.k_near_neighbors.data.Sample;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class GroupDistanceTask implements Runnable {

    private Distance[] distances;
    private int startIndex, endIndex;
    private Sample example;
    private List<? extends Sample> dataSet;
    private CountDownLatch endController;


    public GroupDistanceTask(Distance[] distance, int startIndex, int endIndex,
                             Sample example, List<? extends Sample> dataSet, CountDownLatch endController) {

            this.distances = distance;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.dataSet =dataSet;
            this.example = example;
            this.endController = endController;
    }

    @Override
    public void run() {
        for(int index = startIndex; index < endIndex; index++ ){
            Sample localExample = dataSet.get(index);
            distances[index] = new Distance();
            distances[index].setIndex(index);
            distances[index].setDistance(EuclideanDistanceCalculator.calculate(localExample,example));
        }
        endController.countDown();
    }
}

    