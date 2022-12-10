import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class calc_n_logger {
    public static void main(String[] args) throws IOException {
        String equation = "(\\d+|-\\d+|\\d+\\.\\d+|-\\d+\\.\\d+)([\\-+*/])(\\d+|-\\d+|\\d+\\.\\d+|-\\d+\\.\\d+)$";
//Заводим логгер
        Logger logger = Logger.getLogger(calc_n_logger.class.getName());
        FileHandler fh = new FileHandler("/Users/kos/Documents/JAVA Learnings/Seminar_02/untitled/files/log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        Matcher numbersMatcher;
        String eq;
        double result = 0;
        do {
            Scanner iScanner = new Scanner(System.in);
            System.out.print("Введите пример: ");
            eq = iScanner.nextLine();
            String action = "";
            double num1 = 0;
            double num2 = 0;
//Ниже узнаём действие в для вычисления. Находим знак действия после любой цифры и делаем из этого строку
            Pattern pAction = Pattern.compile("\\d[\\-+*/]");  //Регулярка для символов действий
            Matcher eqMatcher = pAction.matcher(eq);  //Строка в которой ищем регулярку
            if (eqMatcher.find()) {
                action = eqMatcher.group();
            } //Присваиваем строке результат поиска
//Ниже выделяем числа. Любое количество чисел, с минусом, с точкой между ними и минусом, знак деййствия и опять сначала.
            //В паттерне три группы.
            Pattern pNumbers = Pattern.compile(equation);
            numbersMatcher = pNumbers.matcher(eq);
            if (numbersMatcher.find()) {
                num1 = Double.parseDouble(numbersMatcher.group(1)); //Присваеваем результат первой группы одной переменной
                num2 = Double.parseDouble(numbersMatcher.group(3)); //Присваеваем результат третьей группы второй переменной
            }
            try {
                if (action.contains("+")) result = num1 + num2;
                if (action.contains("*")) result = num1 * num2;
                if (action.contains("-")) result = num1 - num2;
                if (action.contains("/")) result = num1 / num2;
            } catch (Exception e) {
                System.out.println("Возможны только действия +, -, /, * над двумя числами.\nДесятичные отделять точкой");
            }
            System.out.printf("Ответ: " + result + "\n");
            logger.info("Выражение: " + eq + "\n      Ответ: " + result + "\n");
        }
        while (!eq.equals("q"));
    }

}
