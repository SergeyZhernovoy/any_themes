package lesson5_executors.k_near_neighbors.data;/**
 * @author Sergey Zhernovoy
 * create on 07.11.2017.
 */

public class Distance implements Comparable<Distance>{
    private int index;

    private double distance;

    public void setIndex(int index){
        this.index = index;
    }

    public void setDistance(double distance){
            this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public int compareTo(Distance other) {
        int result = 0;
        if(this.distance < other.getDistance()){
            result = -1;
        } else if(this.distance > other.getDistance()){
            result = 1;
        }
        return result;
    }
}

    