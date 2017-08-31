package part8_generics;

/**
 * Created by Sergey on 01.08.2017.
 * границы определений указывают ,
 * что класс должен реализовывать указанные интерфейсы
 * иначе ошибка
 */

public class EmployerList<T extends Employer & Printable> {
    public T calcute(T value){
        return  value;
    }

    public static void main(String[] args) {
        EmployerList<Manager> employerList = new EmployerList<>();
    }

}
