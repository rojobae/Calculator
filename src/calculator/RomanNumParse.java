package calculator;

/*
        Переменная класса romanNumbers содержит число римской системе счисления эквивалентное его индексу (числу в
    арабской системе счисления) в массиве.
        Метод Preparation занимается обработкой полученной строки с римскими числами: удаляет возможные пробелы,
    выделяет оператор и числа, которые проверяет на правильность, конвертирует его в число арабской системы счисления.
    Если число не входит в заданный диапазон (от 1 до 10), выбрасывается исключение "CalcException: Out of limits", если
    число записано неверно, выбрасывается исключение "CalcException: Invalid Roman Number". При выводе любого исключения
    программа мгновенно завершается. Возращает массив с числами и оператором.
        В методе ArabicToRoman рассчитывается результат выполнения введённой пользователем операции. Полученное число в
    арабской системе счисления переводится в эквивалентное число римской системы счисления. Если искомое число в
    арабской системе счисления невозможно конвертировать в число римской системы счисления, выбрасывается исключение
    "CalcException: Not a valid result" и программа завершается. Возвращает число в римской системе счисления.
 */

public class RomanNumParse {

    final String[] romanNumbers = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};

    public String[] Preparation(String expression) throws CalcException {

        String resultExpression = expression.replaceAll(" ", "");
        String[] numbers = resultExpression.split("[+*/-]");
        String operator = resultExpression.replaceAll("[XIV]+", "");

        for (int i = 1; i < romanNumbers.length; i++) {
            if (numbers[0].equals(romanNumbers[i])) { numbers[0] = String.valueOf(i); }
            if (numbers[1].equals(romanNumbers[i])) { numbers[1] = String.valueOf(i); }
        }

        if (!numbers[0].matches("[0-9]+") | !numbers[1].matches("[0-9]+")) {
            throw new CalcException("Invalid Roman Number");
        } else if (Integer.parseInt(numbers[0]) > 10 | Integer.parseInt(numbers[1]) > 10) {
            throw new CalcException("Out of limits");
        } else { return new String[] {numbers[0], numbers[1], operator}; }
    }

    public String ArabicToRoman(String string) throws CalcException {
        String[] values = Preparation(string);
        int arabicNum = new Calculator().Calculate(values);

        if (arabicNum < 1) { throw new CalcException("Not a valid result");
        } else {
            for (int i = 1; i < romanNumbers.length; i++) {
                if (arabicNum == i) {
                    return romanNumbers[i];
                }
            }
        }

        throw new CalcException("Not a valid result");
    }
}
