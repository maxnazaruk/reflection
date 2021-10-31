package com.luxoft.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Magic {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
       //showAllNonPublicMethods(Reflection.class);
       //showAllSuperClassesInterfaces(Reflection.class);
        Reflection reflection = new Reflection();
        System.out.println(reflection.name);
        changeFieldsOfTheObjectToDefault(reflection);
        System.out.println(reflection.name);
    }

    public static Object generateInstance(Class clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors){
            if(constructor.getParameterCount() == 0){
               return constructor.newInstance();
            }
        }
        return null;
    }

    public static void runAllMethodsWithoutParameters(Object object) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods){
            if(method.getParameterCount() == 0) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    public static void showSignaturesOfAllFinalMethods(Object object) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Method[] methods = object.getClass().getDeclaredMethods();

        Method[] allMethods = Method.class.getDeclaredMethods();
        for (int i = 0; i < allMethods.length; i++) {
            if((allMethods[i].toString()).contains("getGenericSignature")){
                allMethods[i].setAccessible(true);
                for (Method method : methods){
                    System.out.println(allMethods[i].invoke(method));
                }
            }
        }
    }

    public static void showAllNonPublicMethods(Class clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods){
            if(Modifier.PUBLIC == method.getModifiers() || (Modifier.PUBLIC + Modifier.FINAL) == method.getModifiers()){
                continue;
            }else{
                System.out.println(method.getName());
            }
        }
    }

    public static void showAllSuperClassesAndInterfaces(Class clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        while (clazz != null){
            System.out.println(clazz.getName() + " " + Arrays.toString(clazz.getInterfaces()));
            clazz = clazz.getSuperclass();
        }
    }

    public static void changeFieldsOfTheObjectToDefault(Object object) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields){
            field.setAccessible(true);
            if(field.getType() == int.class){
                field.setInt(object, 0);
            }else if(field.getType() == boolean.class){
                field.setBoolean(object, false);
            }else if(field.getType().getClass().getSuperclass() == Object.class){
                field.set(object, null);
            }
        }
    }
}
