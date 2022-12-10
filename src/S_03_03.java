//  Задан целочисленный список ArrayList.
//  Найти минимальное, максимальное и среднее из этого списка


import java.util.*;

public class S_03_03 {
    //    Генератор случайных чисел
    public static List<Integer> getRandom(int len, int min, int max) {
        Random rd = new Random(); // creating Random object
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            numbers.add(rd.nextInt(max - min) + min); // storing random integers in an array
        }
        return numbers;
    }

    public static void main(String[] args) {
        List<Integer> list = getRandom(6, 0, 100);
        System.out.printf("Исходный список: " + list);
        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        Double average = list.stream().mapToInt(val -> val).average().orElse(0.0);
        System.out.printf("\nMAX: " + max + "\nmin: " + min + "\nAverage: " + average);

    }
}
