import java.util.List;

public class Calculate {
    public static double calculates(String eq) {
        String[] parts = eq.split("=");
        String leftExpression = parts[0].trim();
        String rightExpression = parts[1].trim();
        char variable = findVariable(leftExpression);
        if (variable == ' ') {
            variable = findVariable(rightExpression);
            List<Lexeme> lexemes = LexemeBuffer.lexAnalyze(leftExpression);
            LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
            double c = LexemeBuffer.expr(lexemeBuffer);
            if (rightExpression.length() == 2) {
                c *= -1;
            }
            return c;
        } else {
            boolean minus = false;
            String[] Rexp = rightExpression.split(" ");
            String[] exp = leftExpression.split(" ");
            for (int i = 0; i < exp.length; i++) {
                if (exp[i].matches("-[a-zA-Zа-яА-Я]")) {
                    minus = true;
                    exp[i] = exp[i].substring(1); // Удалить минус из строки
                }
            }
            switch (exp[1]) {
                case "*":
                    if (exp[0].equals("0") || exp[2].equals("0") && rightExpression.equals("0")) {
                        System.out.println(variable + " = R");
                    } else {
                        rightExpression += "/";
                        rightExpression += (variable == exp[0].charAt(0)) ? exp[2] : exp[0];
                        List<Lexeme> lexemes = LexemeBuffer.lexAnalyze(rightExpression);
                        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
                        double c = LexemeBuffer.expr(lexemeBuffer);
                        if (minus)c *= -1;
                        return c;
                    }
                case "+":
                    rightExpression += "-";
                    rightExpression += (variable == exp[0].charAt(0)) ? exp[2] : exp[0];
                    List<Lexeme> lexemes = LexemeBuffer.lexAnalyze(rightExpression);
                    LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
                    double c = LexemeBuffer.expr(lexemeBuffer);
                    if (minus)c *= -1;
                    return c;
                case "-":
                    if (variable == exp[2].charAt(0)) {
                        exp[2] = Rexp[0];
                        String ex = exp[0] + exp[1] + exp[2];
                        List<Lexeme> lexemes1 = LexemeBuffer.lexAnalyze(ex);
                        LexemeBuffer lexemeBuffer1 = new LexemeBuffer(lexemes1);
                        double c1 = LexemeBuffer.expr(lexemeBuffer1);
                        if (minus)c1 *= -1;
                        return c1;
                    } else {
                        rightExpression += "+";
                        rightExpression += exp[2];
                        List<Lexeme> lexemes1 = LexemeBuffer.lexAnalyze(rightExpression);
                        LexemeBuffer lexemeBuffer1 = new LexemeBuffer(lexemes1);
                        double c1 = LexemeBuffer.expr(lexemeBuffer1);
                        if (minus)c1 *= -1;
                        return c1;
                    }
                case "/":
                    if (variable == exp[2].charAt(0)) {
                        exp[2] = Rexp[0];
                        String ex = exp[0] + exp[1] + exp[2];
                        List<Lexeme> lexemes1 = LexemeBuffer.lexAnalyze(ex);
                        LexemeBuffer lexemeBuffer1 = new LexemeBuffer(lexemes1);
                        double c1 = LexemeBuffer.expr(lexemeBuffer1);
                        if (minus)c1 *= -1;
                        return c1;
                    } else {
                        rightExpression += "*";
                        rightExpression += exp[2];
                        List<Lexeme> lexemes1 = LexemeBuffer.lexAnalyze(rightExpression);
                        LexemeBuffer lexemeBuffer1 = new LexemeBuffer(lexemes1);
                        double c1 = LexemeBuffer.expr(lexemeBuffer1);
                        if (minus)c1 *= -1;
                        return c1;
                    }
                default:
                    break;
            }
        }
        return 0;
    }


    public static char findVariable(String expression) {
        for (char c : expression.toCharArray()) {
            if (Character.isLetter(c)) {
                return c;
            }
        }
        return ' ';
    }

}
