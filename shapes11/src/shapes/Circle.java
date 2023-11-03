package shapes;

public class Circle extends Shape {
    private Point point;
    private double radius = 0.0;
    private static final double Pi = 3.141592;
    public Point getPoint() {
        return point;
    }
    public void setPoint(Point point) {
        this.point = point;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        if (validate(radius)) {
            this.radius = radius;
        }
        else {
            System.out.println("Радиус меньше 0");
        }
    }
    private boolean validate (double radius) {
        if (radius > 0) {
            return true;
        }
        else {
            throw new NullPointerException("не удалось создать фигуру, так как радиус меньше 0");
        }
    }
    public Circle(){}
    public Circle (Point point, double radius) {
        this.point = point;
        this.radius = radius;
    }
    public void draw(){
        System.out.println ("Фигура круг");
        System.out.println("Площадь круга: " + getSquare());
        System.out.println("Периметр круга: " + getFlat());
        System.out.println("Цвет круга: " + getColor());

    }
    public double getSquare(){
        return Pi * radius * radius;
    }
    public double getFlat(){
        return 2 * Pi * radius;
    }

    public void move(double moveX, double moveY){
        double newX = point.getX() + moveX;
        double newY = point.getY() + moveY;
        point.setX(newX);
        point.setY(newY);
    }
}