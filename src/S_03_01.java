//Реализовать алгоритм сортировки слиянием

import java.util.Random;

public class S_03_01 {
    //    Генератор случайных чисел
    public static int[] getRandom(int len, int min, int max) {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(max - min) + min; // storing random integers in an array
        }
        return arr;
    }

    //    Вывод массива
    public static void printArr(int[] arr, String type) {
        if (type == "i") System.out.printf("\nИсходный массив: ");
        if (type == "r") System.out.printf("\nОтсортированный массив: ");
        for (int i : arr) {
            System.out.printf(i + " ");
        }
    }

    //    Дробим массив
    public static void mergeSort(int[] inArr, int length) {
        int arrMiddle = length / 2;
        int[] leftPart = new int[arrMiddle];
        int[] rightPart = new int[length - arrMiddle];

        if (length < 2) return;

        for (int i = 0; i < arrMiddle; i++) {
            leftPart[i] = inArr[i];
        }
        for (int i = arrMiddle; i < length; i++) {
            rightPart[i - arrMiddle] = inArr[i];
        }
        mergeSort(leftPart, arrMiddle);
        mergeSort(rightPart, length - arrMiddle);
        merge(inArr, leftPart, rightPart, arrMiddle, length - arrMiddle);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<Integer>();
        int[] numberArr = getRandom(10, 0, 100);
        printArr(numberArr, "i");
        mergeSort(numberArr, numberArr.length);
        printArr(numberArr, "r");

    }
}
