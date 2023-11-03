package shapes;

public class Triangle extends Shape{
    private Point A;
    private Point B;
    private Point C;

    public Point getA() {
        return A;
    }

    public void setA(Point A) {
        this.A = A;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point B) {
        this.B = B;
    }

    public Point getC() {
        return C;
    }

    public void setC(Point C) {
        this.C = C;
    }

    public Triangle(Point A, Point B, Point C) {
        if (validate(A, B, C)) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }
    public Triangle(){

    }
    private boolean validate(Point A,Point B,Point C){
        try {
            if (((A.getX() == C.getX()) || (A.getY() == C.getY())) && ((A.getX() == B.getX()) || (A.getY() == B.getY())) && ((B.getX() == C.getX()) || (B.getY() == C.getY()))) {
                throw new NullPointerException("не удалось создать фигуру, т.к. точки х или y лежат на одной прямой");
            } else {
                return true;
            }
        }
        catch (Exception e){
            throw new NullPointerException("мимо");
        }
    }
    public double getSquare() {
        double sideAB = calculateDistance(A, B);
        double sideBC = calculateDistance(B, C);
        double sideCA = calculateDistance(C, A);

        double s = (sideAB + sideBC + sideCA) / 2.0;

        return Math.sqrt(s * (s - sideAB) * (s - sideBC) * (s - sideCA));
    }

    public double getFlat() {
        double sideAB = calculateDistance(A, B);
        double sideBC = calculateDistance(B, C);
        double sideCA = calculateDistance(C, A);

        return sideAB + sideBC + sideCA;
    }

    private double calculateDistance(Point p1, Point p2) {
        double deltaX = p1.getX() - p2.getX();
        double deltaY = p1.getY() - p2.getY();

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public void move(double moveX, double moveY){
        A.setX(A.getX() + moveX);
        A.setY(A.getY() + moveY);
        C.setX(C.getX() + moveX);
        C.setY(C.getY() + moveY);
        B.setX(B.getX() + moveX);
        B.setY(B.getY() + moveY);
    }
    public void draw(){
        validate(A,B,C);
        try {
            System.out.println("Фигура треугольник");
            System.out.println("Координаты вершин: точка А: (" + A.getX() + ";" + A.getY() + ") точка B: (" + B.getX() + ";" + B.getY() + ") точка С: (" + C.getX() + ";" + C.getY() + ")");
            System.out.println("Площадь прямоугольника: " + getSquare());
            System.out.println("Периметр прямоугольника: " + getFlat());
            System.out.println("Цвет прямоугольника: " + getColor());
        }
        catch (Exception c){
            throw new NullPointerException("не удалось создать фигуру, т.к. точки х или y лежат на одной прямой");
        }


    }
}