package shapes;

public class Point extends Shape {
    private double x = 0.0;
    private double y = 0.0;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public Point(){}
    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw(){
        System.out.println ("фигура точка");
        System.out.println("Координаты точки: " + x + " " + y);
        System.out.println("Площадь точки: " + getSquare());
        System.out.println("Периметр точки: " + getFlat());
        System.out.println("Цвет точки: " + getColor());

    }
    public double getSquare(){
        return 0;
    }
    public double getFlat(){
        return 0;
    }

    public void move(double moveX, double moveY){
        x += moveX;
        y += moveY;
    }
}