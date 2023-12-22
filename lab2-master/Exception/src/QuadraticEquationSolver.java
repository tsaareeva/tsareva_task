import java.util.List;

@FunctionalInterface
interface QuadraticEquationSolver {
    List<Double> solveQuadraticEquation(double a, double b, double c);
}