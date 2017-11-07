package lesson5_executors.k_near_neighbors.concurrent_ver1;/**
 * @author Sergey Zhernovoy
 * create on 07.11.2017.
 */

import lesson5_executors.k_near_neighbors.data.Distance;
import lesson5_executors.k_near_neighbors.data.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class IndividualDistanceTask {
    private static final Logger logger = LoggerFactory.getLogger(IndividualDistanceTask.class);

    public IndividualDistanceTask(Distance[] distance, int index, Sample localExample, Sample example, CountDownLatch endController) {
    }
}

    