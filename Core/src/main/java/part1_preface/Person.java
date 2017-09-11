package part1_preface;

/**
 * Created by Sergey on 29.07.2017.
 */
public class Person {
    private String name;
    private String lastName;
    public Person(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        PersonFactory<Person> personFactory  = Person::new;
        System.out.println(personFactory.create("Sergey","Zhernovoy").toString());
    }
}
