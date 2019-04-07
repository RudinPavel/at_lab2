package com.company;

// Класс с методами для работы с массивом целых чисел
public class MyMass {
    private int[] mass = new int[0];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(int b){
        if (isContain(b)){
            System.out.println("Massive already contains this element!");
            return;
        }
        int[] helper = new int[size + 1];
        for (int i = 0; i < size; i++){
            helper[i] = mass[i];
        }
        helper[size] = b;
        mass = helper;
        size++;
        System.out.println("Element " + b + " added. Success!");
    }

    /*private void add(int a){
        int[] helper = new int[size + 1];
        for (int i = 0; i < size; i++){
            helper[i] = mass[i];
        }
        helper[size] = a;
        mass = helper;
        size++;
        System.out.println("Element " + b + " added. Success!");
    }*/

    public void printer(){
        String result = "";
        for (int a:
             mass) {
            result += a + " ";
        }
        System.out.println(result);
    }

    public String stringer(){
        String result = "";
        for (int a:
                mass) {
            result += a + " ";
        }
        return result;
    }

    private boolean isContain(int b)
    {
        for (int a:
             mass) {
            if (a == b) return true;
        }
        return false;
    }

    public void removeByIndex(int index){
        if (index < 0 || index >= size){
            System.out.println("Wrong index!");
            return;
        }
        int[] helper = new int[size-1];
        if (index == 0){
            for (int i = 1; i < size; i++)
                helper[i-1] = mass[i];
        }
        if (index == size-1){
            for (int i = 0; i < size-1; i++)
                helper[i] = mass[i];
        }
        if(index != 0 && index != size - 1) {
            int j = 0;
            for (int i = 0; i < size; i++){
                if (index == i) {
                    continue;
                }
                helper[j] = mass[i];
                j++;
            }
        }
        mass = helper;
        size--;
    }

    public void removeByValue(int value){
        int index = findIndexByValue(value);
        removeByIndex(index);
    }

    public int findMax(){
        if (size == 0){
            System.out.println("Massive is empty!");
            return 0;
        }
        int max = mass[0];
        for (int i = 1; i < size; i++){
            if (mass[i] > max){
                max = mass[i];
            }
        }
        return max;
    }

    public int findMin(){
        if (size == 0){
            System.out.println("Massive is empty!");
            return 0;
        }
        int min = mass[0];
        for (int i = 1; i < size; i++){
            if (mass[i] < min){
                min = mass[i];
            }
        }
        return min;
    }

    public int findIndexByValue(int b){
        for (int i = 0; i < size; i++){
            if (mass[i] == b){
                System.out.println("Find element at " + i + " position");
                return i;
            }
        }
        System.out.println("Not found.");
        return -1;
    }
}
