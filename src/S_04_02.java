//  2.Реализуйте очередь с помощью LinkedList со следующими методами:
//- enqueue() - помещает элемент в конец очереди,
//- dequeue() - возвращает первый элемент из очереди и удаляет его,
//- first() - возвращает первый элемент из очереди, не удаляя.


import java.util.*;

public class S_04_02 {
    //    Генератор случайных чисел
    public static LinkedList<Object> getRandom(int len, int min, int max) {
        Random rd = new Random(); // creating Random object
        LinkedList<Object> numbers = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            numbers.addLast(rd.nextInt(max - min) + min); // storing random integers in an array
        }
        return numbers;
    }

    //помещает элемент в конец очереди
    public static void enqueue(LinkedList<Object> inList) {
        System.out.print("Введите элемент: ");
        Scanner enqScanner = new Scanner(System.in);
        Object element = enqScanner.nextLine();
        inList.addLast(element);
        System.out.printf(String.valueOf(inList));
    }

    //- dequeue() - возвращает первый элемент из очереди и удаляет его
    public static void dequeue(LinkedList<Object> inList) {
        if (inList.size() >= 1) {
            Object firstEl = inList.pollFirst();
            System.out.printf("Первый элемент: " + firstEl + " удален");
        } else {
            System.out.print("В списке нет элементов");
        }
    }

    //- first() - возвращает первый элемент из очереди, не удаляя.
    public static void first(LinkedList<Object> inList) {
        Object firstEl = inList.peekFirst();
        System.out.printf("Первый элемент элемент: " + firstEl);
    }


    public static void main(String[] args) {
        LinkedList<Object> list = getRandom(2, 0, 100);
        String choose;
        Scanner iScanner;
        do {
            System.out.printf("\nИсходный список: " + list);
            System.out.print("""
                    \nВыберите метод для работы со списком
                    1 - добавить элемент в конец очереди
                    2 - отобразить первый элемент и удалить его
                    3 - отобразить первый элемент
                    q - ВЫХОД
                    """);
            iScanner = new Scanner(System.in);
            choose = iScanner.nextLine();
            if (Objects.equals(choose, "1")) enqueue(list);
            if (Objects.equals(choose, "2")) dequeue(list);
            if (Objects.equals(choose, "3")) first(list);
        }
        while (!Objects.equals(choose, "q"));
        iScanner.close();
        System.out.print("До свидания!");
    }
}
