package calculator;

/*
        Ключевой класс программы. Считывает введённую пользователем строку, проверяет её правильность, распределяет
    в зависимости от введённых чисел. Если строка содержит недопустимые символы или введены числа разных систем
    счисления, бросает исключения "CalcException: Wrong number" и "CalcException: Different type of numbers"
    соответственно, завершая программу. Выводит искомое число в консоль.
 */

import java.util.Scanner;
import java.lang.*;

public class CalcRunner {

    public static void main(String[] args) throws CalcException {

        Scanner input = new Scanner(System.in);
        String string = input.nextLine();

        if (!string.matches(" *[0-9IVX]+ *[+*/-] *[0-9IVX]+ *")) {
            throw new CalcException("Wrong number");
        }

        if (string.matches(" *[0-9]+ *[+*/-] *[0-9]+ *")) {
            System.out.println(new ArabicNumParse().ArabicCalculate(string));
        } else if (string.matches(" *[IVX]+ *[+*/-] *[IVX]+ *")) {
            System.out.println(new RomanNumParse().ArabicToRoman(string));
        } else {
            throw new CalcException("Different type of numbers");
        }
    }

}
