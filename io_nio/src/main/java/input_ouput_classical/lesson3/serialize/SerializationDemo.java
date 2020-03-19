package input_ouput_classical.lesson3.serialize;

import java.io.*;

/**
 * @author Sergey Zhernovoy
 * create on 15.10.2017.
 */

public class SerializationDemo {

    private final static String FILENAME = "D:\\test.dat";

    public static void serialize(){

        try(FileOutputStream fos = new FileOutputStream(FILENAME); ObjectOutputStream oos = new ObjectOutputStream(fos)){
            Employee employee = new Employee("Sergey Zhernovoy", 39, "Java developer");
            oos.writeObject(employee);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unserialize(){
        try(FileInputStream fis = new FileInputStream(FILENAME); ObjectInputStream ois = new ObjectInputStream(fis)){
            Employee employee = (Employee) ois.readObject();
            ois.close();
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
            System.out.println(employee.getVacancy());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SerializationDemo.serialize();
        SerializationDemo.unserialize();
    }

}

    