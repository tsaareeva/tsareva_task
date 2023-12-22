public class Calculator {
    public static <T,V> double sum(T a, V b) {
        double num1 = convertToDouble(a);
        double num2 = convertToDouble(b);
        return num1 + num2;
    }

    public static <T,V>double multiply(T a, V b) {
        double num1 = convertToDouble(a);
        double num2 = convertToDouble(b);
        return num1 * num2;
    }

    public static <T,V>double divide(T a, V b) {
        double num1 = convertToDouble(a);
        double num2 = convertToDouble(b);
        if (num2 == 0) {
            throw new ArithmeticException("Делить на 0 нельзя");
        }
        return num1 / num2;
    }

    public static <T,V>double subtraction(T a, V b) {
        double num1 = convertToDouble(a);
        double num2 = convertToDouble(b);
        return num1 - num2;
    }

    private static double convertToDouble(Object value) {
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        } else if (value instanceof String) {
            try {
                return Double.parseDouble((String) value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Некорректный ввод " + value);
            }
        } else {
            throw new IllegalArgumentException("Посторонний класс " + value.getClass());
        }
    }

    public static void main(String[] args) {
        int input1 = 10;
        String input2 = "3.5";

        System.out.println("Sum: " + sum(input1, input2));
        System.out.println("Product: " + multiply(input1, input2));
        System.out.println("Division: " + divide(input1, input2));
        System.out.println("Subtraction: " + subtraction(input1, input2));
    }
}
