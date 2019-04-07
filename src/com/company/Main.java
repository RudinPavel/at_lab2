package com.company;

public class Main {

    public static void main(String[] args) {
        // Задача 1
        firstMethod();
        int[] mass = {1,2,3,4,5,6};

        // Задача 2
        reverse(mass);

        // Задача 3
        fillMass(mass);

        // Задача 4
        int[][] matrix = new int[5][5] ;
        fillMatrix(matrix);


        // Задача на класс
        MyMass m  = new MyMass();
        m.add(10);
        m.add(10);
        m.add(-3);
        m.add(15);
        m.add(14);
        System.out.println(m.findMin());
        System.out.println(m.findMax());
        System.out.println(m.findIndexByValue(-3));
        System.out.println(m.findIndexByValue(-4));
        m.printer();
        System.out.println(m.stringer());
        m.removeByIndex(2);
        m.removeByValue(4);
        m.removeByValue(-3);
        m.printer();
    }

    // Функция выполняет задачу 1. Выводит на консоль по 3 элемента.
    public static void firstMethod(){
        for (int i = 1; i <= 100; i += 3){
            if ((i + 1) > 100) {
                System.out.println(100);
                return;
            }
            System.out.println(i + " " + (i+1) + " " + (i + 2));
        }
    }

    // Функция выполняет задачу 2. Выводит на консоль массив в обратном порядке.
    public static void reverse(int[] mass){
        String result = "";
        for (int i = (mass.length - 1); i >= 0; i--)
            result += mass[i];
        System.out.println(result);
    }

    // Функция выполняет задачу 3. Заполняет массив из середины 3_2_1_0_1_2 и выводит на консоль.
    public static void fillMass(int[] mass){
        String result = "";
        int middle = mass.length / 2;
        int i = 0;
        mass[middle] = i;
        for (int j = middle-1; j >= 0; j--)
            mass[j] = ++i;
        i = 0;
        for (int j = middle+1; j < mass.length; j++)
            mass[j] = ++i;
        for (i = 0; i < mass.length; i++)
            result += mass[i];
        System.out.println(result);
    }

    // Функция выполняет задачу 4. Заполняет двумерный КВАДРАТНЫЙ массив спиралью к центру и выводит на консоль.
    public static void fillMatrix(int[][] matrix){
        // блок инциализации
        int helper = 0; // переменная для отслеживания момента, когда останавливаем заполнение
        int elementCount = matrix.length * matrix[0].length; // количество элементов
        boolean moveRight = true; // !moveRight = moveLeft
        // boolean moveDown = true; // !moveDown = moveUp
        int rightBorder = matrix.length;
        int leftBorder = 0;
        int upBorder = 0;
        int downBorder = matrix[0].length;
        int current = 0;
        int i = 0;
        int j = 0;


        while (true){
            if (helper == elementCount) break;
            if (moveRight){
                for (j = leftBorder; j < rightBorder; j++){
                    matrix[i][j] = current++;
                    helper++;
                    if (helper == elementCount) break;
                }
                j--;
                i++;
                upBorder++;
                moveRight = false;
                for (; i < downBorder; i++){
                    matrix[i][j] = current++;
                    helper++;
                    if (helper == elementCount) break;
                }
            }
            i--;
            rightBorder--;
            if (!moveRight){
                for (j = rightBorder-1; j >= leftBorder; j--){
                    matrix[i][j] = current++;
                    helper++;
                    if (helper == elementCount) break;
                }
                downBorder--;
                moveRight = true;
                j++;
                i--;
                for (; i >= upBorder; i--){
                    matrix[i][j] = current++;
                    helper++;
                    if (helper == elementCount) break;
                }
                leftBorder++;
                i++;
            }
        }

        // вывод на консоль
        String result = "";
        for (i = 0; i < matrix.length; i++){
            for (j = 0; j < matrix[0].length; j++)
                result += matrix[i][j] + " ";
            result += '\n';
        }
        System.out.println(result);
    }
}
