package lesson5_executors.k_near_neighbors.concurrent_ver1;/**
 * @author Sergey Zhernovoy
 * create on 07.11.2017.
 */

import lesson5_executors.k_near_neighbors.EuclideanDistanceCalculator;
import lesson5_executors.k_near_neighbors.data.Distance;
import lesson5_executors.k_near_neighbors.data.Sample;

import java.util.concurrent.CountDownLatch;

public class IndividualDistanceTask implements Runnable {

    private Distance[] distances;
    private int index;
    private Sample localExample;
    private Sample example;
    private CountDownLatch endController;


    public IndividualDistanceTask(Distance[] distance, int index, Sample localExample, Sample example, CountDownLatch endController) {

            this.distances = distance;
            this.index = index;
            this.localExample = localExample;
            this.example = example;
            this.endController = endController;
    }

    @Override
    public void run() {
        distances[index] = new Distance();
        distances[index].setIndex(index);
        distances[index].setDistance(EuclideanDistanceCalculator.calculate(localExample,example));
        endController.countDown();
    }
}

    