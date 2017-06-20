package ru.zhernovoy.lesson4;

import java.util.Arrays;

/**
 * Created by Sergey Zhernovoy on 20.06.2017.
 */
public interface Person extends Named {

    default String getDescription(String ... objectNamed){
        StringBuilder builder = new StringBuilder();
        Arrays.stream(objectNamed)
                .forEach(objectName -> {builder.append(objectName);
                    builder.append("\n\n");

                });
        return builder.toString();
    }
}
