package shapes;
import colors.Color;

public abstract class Shape {
    public Color color = Color.TRANSPARENT;
    private double square = 0;
    private double perimeter = 0;

    public Color getColor () {
        return color;
    }
    public void setColor (Color color) {
        this.color = color;
    }

    public double getSquare () {
        return square;
    }

    public void setSquare (double square) {
        this.square = square;
    }
    public double getFlat () {
        return perimeter;
    }

    public void setFlat(double perimeter) {
        this.perimeter = perimeter;
    }
    public void move (double moveX, double moveY) {

    }
    public void draw() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}