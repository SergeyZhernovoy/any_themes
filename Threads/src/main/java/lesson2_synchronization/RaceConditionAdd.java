package lesson2_synchronization;/**
 * @author Sergey Zhernovoy
 * create on 14.09.2017.
 */

public class RaceConditionAdd implements Runnable {

    private Integer checker = 0;
    private Integer recieve = 0;

    public RaceConditionAdd(Integer checker, Integer recieve){
        this.checker = checker;
        this.recieve = recieve;
    }

    @Override
    public void run() {
        checker = 0;
        while(recieve != 5){

            if(checker == 30){
                recieve = 5;
            }

            System.out.println(Thread.currentThread().getName() + " - checker - " + checker++);
        }
    }

    public static void main(String[] args) {
        Integer checker = 0;
        Integer reciever= 0;
        RaceConditionAdd raceConditionAdd = new RaceConditionAdd(checker,reciever);
        new Thread(raceConditionAdd).start();
        new Thread(raceConditionAdd).start();
    }


}

    