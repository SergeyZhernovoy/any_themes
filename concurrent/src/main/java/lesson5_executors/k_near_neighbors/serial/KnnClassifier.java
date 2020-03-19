package lesson5_executors.k_near_neighbors.serial;

import lesson5_executors.k_near_neighbors.data.Distance;
import lesson5_executors.k_near_neighbors.EuclideanDistanceCalculator;
import lesson5_executors.k_near_neighbors.data.Sample;

import java.util.*;

/**
 * @author Sergey Zhernovoy
 * create on 07.11.2017.
 */

public class KnnClassifier {

    private List<? extends Sample> dataSet;
    private int k;

    public KnnClassifier(List<? extends Sample> dataSet, int k) {
        this.dataSet = dataSet;
        this.k = k;
    }

    public String classify(Sample sample){

        Distance[] distance = new Distance[this.dataSet.size()];

        int index = 0;

        for(Sample localSample : this.dataSet){
            distance[index] = new Distance();
            distance[index].setIndex(index);
            distance[index++].setDistance(EuclideanDistanceCalculator.calculate(localSample,sample));
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

    