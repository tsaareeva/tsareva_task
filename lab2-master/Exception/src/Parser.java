import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Double.parseDouble;


class Parser {
    public static void parse(String path) {
        File file = new File(path);
        try {
            int taskNumber = 1;
            FileWriter writer = new FileWriter("C:/Users/artem/OOP_labs/output.txt");
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Решите уравнение:")) {
                    String equation = line.substring(line.indexOf(":") + 1).trim();
                    writer.write("===Task " + taskNumber + "===\n");
                    writer.write("Решите уравнение: " + equation + "\n");
                    try {
                        double res = Calculate.calculates(equation);
                        writer.write(Calculate.findVariable(equation) + " = " + formatDouble(res) + "\n");
                    } catch (Exception e) {
                        writer.write("Невозможно вычислить решение уравнения\n");
                    }
                    taskNumber++;
                }
                else if (line.startsWith("Найдите значение выражения:")) {
                    String expression = line.substring(line.indexOf(":") + 1).trim();
                    writer.write("===Task " + taskNumber + "===" + "\n");
                    writer.write("Найдите значение выражения: " + expression + "\n");
                    try {
                        List<Lexeme> lexemes = LexemeBuffer.lexAnalyze(expression);
                        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
                        double result = LexemeBuffer.expr(lexemeBuffer);
                        if (Double.isInfinite(result)) {
                            writer.write("Ошибка: деление на ноль\n");
                        } else {
                            writer.write(expression + " = " + formatDouble(result) + "\n");
                        }
                    } catch (Exception e) {
                        writer.write("Невозможно вычислить значение выражения\n");
                    }
                    taskNumber++;
                } else if(line.startsWith("Найдите решение квадратного уравнения:")){
                    String expression = line.substring(line.indexOf(":") + 1).trim();
                    writer.write("===Task " + taskNumber + "===" + "\n");
                    writer.write("Найдите решение квадратного уравнения: " + expression + "\n");
                    try{
                        String[] expressionWithoutSpace = expression.split(" ");
                        List<Object> koef = new ArrayList<>();
                        for (int i = 0; i < expressionWithoutSpace.length;i++) {
                            if (expressionWithoutSpace[i].matches("[a-zA-Zа-яА-Я]")) {
                                if (i == 0)koef.add(1.0);
                                else{
                                    double k = parseDouble(expressionWithoutSpace[i-2]);
                                    try{
                                        if (expressionWithoutSpace[i-3].matches("-")) {
                                            k *= -1;
                                        }
                                    } catch (IndexOutOfBoundsException ignored) {}
                                    koef.add(k);
                                }
                            }
                            if (expressionWithoutSpace[i].matches( "=")){
                                double k = parseDouble(expressionWithoutSpace[i-1]);
                                if (expressionWithoutSpace[i-2].matches("-")) {
                                    k *= -1;
                                }
                                koef.add(k);
                            }
                        }
                        QuadraticEquationSolver quadraticSolver = (a, b, c) -> {
                            double discriminant = b * b - 4 * a * c;
                            if (discriminant < 0) {
                                return List.of();
                            } else if (discriminant == 0) {
                                double root = -b / (2 * a);
                                return List.of(root);
                            } else {
                                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                                return Arrays.asList(root1, root2);
                            }
                        };
                        double a = (double) koef.get(0);
                        double b = (double) koef.get(1);
                        double c = (double) koef.get(2);
                        List<Double> roots = quadraticSolver.solveQuadraticEquation(a, b, c);
                        if (roots.isEmpty()) {
                            //System.out.println("Квадратное уравнение не имеет действительных корней.");
                            writer.write("Квадратное уравнение не имеет действительных корней.\n");
                        } else if (roots.size() == 1) {
                            //System.out.println("Уравнение имеет один корень: x = " + roots.get(0));
                            writer.write("x = " + formatDouble(roots.get(0)) + "\n");
                        } else {
                            //System.out.println("Уравнение имеет два корня: x1 = " + roots.get(0) + ", x2 = " + roots.get(1));
                            writer.write("x1 = " + formatDouble(roots.get(0)) + "; x2 = " + formatDouble(roots.get(1)) + "\n");
                        }
                    }catch (Exception e){
                        writer.write("Невозможно вычислить значение выражения\n");
                    }
                    taskNumber++;
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл " + path + " не найден");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
        }
    }
    private static String formatDouble(double number) {
        if (number % 1 == 0) {
            return String.valueOf(number);
        } else {
            return String.format("%.3f", number);
        }
    }

}