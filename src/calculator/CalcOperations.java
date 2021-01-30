package calculator;

/*
        CalcOperations - перечисление возможных операций над вводимыми числами. Здесь они и выполняются. Возвращает
    искомое число.
 */

public enum CalcOperations {

    SUM("+") {
        public int result(String a, String b) { return Integer.parseInt(a) + Integer.parseInt(b); }
    },

    MULTIPLY("*") {
        public int result(String a, String b) { return Integer.parseInt(a) * Integer.parseInt(b); }
    },

    SUBTRACT("-") {
        public int result(String a, String b) { return Integer.parseInt(a) - Integer.parseInt(b); }
    },

    DIVIDE("/") {
        public int result(String a, String b) { return Integer.parseInt(a) / Integer.parseInt(b); }
    };

    final String operator;
    CalcOperations(String operator) { this.operator = operator; }

    public abstract int result(String a, String b);

}
