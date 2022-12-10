//  Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class S_03_02 {
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
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            if (itr.next() % 2 == 0) {
                itr.remove();
            }
        }
        System.out.printf("\nРезультат: " + list);

    }
}
