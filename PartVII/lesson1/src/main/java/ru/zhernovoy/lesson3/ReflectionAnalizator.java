package ru.zhernovoy.lesson3;/**
 * Created by Sergey Zhernovoy on 17.06.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionAnalizator<T> {

    private Field[] fields;
    private Method[] methods;
    private Constructor<T>[] constructors;
    private Class aClass;
    private Class superClass;
    private boolean fill = false;
    private Object obj;

    public ReflectionAnalizator(Class aClasse,Object obj){
        this.aClass = aClasse;
        this.obj = obj;
    }

    private void generator(){
            this.superClass = aClass.getSuperclass();
            this.constructors = aClass.getDeclaredConstructors();
            this.fields = aClass.getDeclaredFields();
            this.methods = aClass.getDeclaredMethods();
            aClass.getModifiers();
            this.fill = true;
    }

    public void printFields(){
        if(!this.fill){
            this.generator();
        }

        for(Field field : this.fields){
            Class fType = field.getType();
            String name = field.getName();
            String modifiers = Modifier.toString(fType.getModifiers());
            System.out.print(" ");
            if(modifiers.length() > 0) {
                System.out.print(String.format("%s ",modifiers));
            }
            Object value = null;
            field.setAccessible(true);
            try {
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s %s value=%s;",fType.getName(),name,value));
        }
    }


}
