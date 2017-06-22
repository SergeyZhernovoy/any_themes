package ru.zhernovoy.lesson4;

/**
 * Created by Sergey Zhernovoy on 20.06.2017.
 */
public interface Named {

    default String getDescription(){

        return "test1";
    }

}
