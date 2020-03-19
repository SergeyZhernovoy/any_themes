package lesson2_synchronization;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Sergey Zhernovoy
 * create on 23.09.2017.
 */

/**
 * • Immutable objects must not allow state to be modified.
 • All fields must be declared final.
 • Objects must be properly constructed so that “this” references
 don’t escape from constructors.

 - Не изменяемые объекты не должны изменять состояние (состояние данных по ссылкам не устанавливаются)
 - все поля должны быть финализированы
 - ссылка this не должна утекать из объекта.
 */

public final class ImmutableAndThreadSafing {

    private final Set<String> cache = new TreeSet<>();

    public ImmutableAndThreadSafing(){
        cache.add("First");
        cache.add("Second");
    }

    public boolean inCache(String value) {
        return cache.contains(value);
    }

    public void addInCache(String value){
        cache.add(value);
    }

    public static void main(String[] args) {
        ImmutableAndThreadSafing cacheSafe = new ImmutableAndThreadSafing();
        System.out.println("value First in cache is :" + cacheSafe.inCache("First"));
        System.out.println("value Third in cache is :" + cacheSafe.inCache("Third"));
        System.out.println("add Third in cache");
        cacheSafe.addInCache("Third");
        System.out.println("value Third in cache is :" + cacheSafe.inCache("Third"));

    }




}

    