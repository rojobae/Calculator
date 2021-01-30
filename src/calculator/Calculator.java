package calculator;

/*
        Метод Calculate сопоставлет оператор перечислению CalcOperations. Если введён неправильный оператор, бросает
    исключение "CalcException: Invalid operation". Возвращает искомое число в арабской системе счисления.
 */

public class Calculator {

    public int Calculate(String[] values) throws CalcException {

        CalcOperations[] operators = CalcOperations.values();

        for (CalcOperations action : operators) {
            if (action.operator.equals(values[2])) {
                return action.result(values[0], values[1]);
            }
        }

        throw new CalcException("Invalid operation");
    }
}
