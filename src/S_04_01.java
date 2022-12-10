//  Пусть дан LinkedList с несколькими элементами.
//  Реализуйте метод, который вернет “перевернутый” список.


import java.util.*;

public class S_04_01 {
    //    Генератор случайных чисел
    public static LinkedList<Integer> getRandom(int len, int min, int max) {
        Random rd = new Random(); // creating Random object
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            numbers.addLast(rd.nextInt(max - min) + min); // storing random integers in an array
        }
        return numbers;
    }

    public static LinkedList<Integer> reverseList(LinkedList<Integer> inList) {
        LinkedList<Integer> revList = new LinkedList<>(); //Список для накопления обратного порядка
        Iterator r = inList.iterator();
        while (r.hasNext()) {
            revList.addFirst((Integer) r.next());
        }
        return revList;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = getRandom(6, 0, 100);
        System.out.printf("Исходный список: " + list);
        System.out.printf("\nRes: " + reverseList(list));
    }
}
