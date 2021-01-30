package calculator;

/*
        Метод Preparation занимается обработкой полученной строки с арабскими числами: удаляет возможные пробелы,
    выделяет оператор и числа, которые проверяет на правильность. Если число не входит в заданный диапазон (от 1 до 10),
    выбрасывается исключение "CalcException: Out of limits" и программа завершается. Возращает массив с числами и
    оператором.
        В методе ArabicCalculate рассчитывается результат выполнения введённой пользователем операции. Возвращает
    искомое число.
 */

public class ArabicNumParse {

    public String[] Preparation(String expression) throws CalcException {

        String resultExpression = expression.replaceAll(" ", "");
        String[] numbers = resultExpression.split("[+*/-]");
        String operator = resultExpression.replaceAll("[0-9]+", "");

        if (Integer.parseInt(numbers[0]) > 10 | Integer.parseInt(numbers[1]) > 10 | Integer.parseInt(numbers[0]) <= 0 |
                Integer.parseInt(numbers[1]) <= 0) { throw new CalcException("Out of limits");
        } else {
            return new String[]{numbers[0], numbers[1], operator};
        }
    }

    public int ArabicCalculate(String string) throws CalcException {
        String[] values = Preparation(string);
        return new Calculator().Calculate(values);
    }
}
