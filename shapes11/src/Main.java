import colors.Color;
import service.ShapesService;
import service.impl.ShapesServiceImpl;
import shapes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Triangle tri = new Triangle();
        tri.setA(new Point(1,1));
        tri.setB(new Point(3, 5));
        tri.setC(new Point(5,1));
        tri.move(2,2);
        tri.setColor(Color.PURPLE);
        tri.draw();
        System.out.println(' ');

        Point point = new Point(3, 3);
        point.move(4,6);
        point.setColor(Color.YELLOW);
        point.draw();
        System.out.println(' ');
        Circle ci = new Circle(new Point(6, 6), 2);
        ci.setRadius(3);
        ci.move(1, 1);
        ci.setColor(Color.BLUE);
        ci.draw();
        System.out.println(' ');

        Rectangle rec = new Rectangle();
        rec.setPointA(new Point(1 , 1));
        rec.setPointC(new Point(5, 5));
        rec.move(4,2);
        rec.setColor(Color.BLACK);
        rec.draw();
        System.out.println(' ');

        List<Shape> shapes = new ArrayList<>();

        Triangle tri1 = new Triangle();
        tri1.setA(new Point(1,0));
        tri1.setB(new Point(2, 5));
        tri1.setC(new Point(4,6));
        tri1.setColor(Color.RED);

        Circle ci1 = new Circle();
        ci1.setPoint(new Point(7,5));
        ci1.setRadius(2);
        ci1.setColor(Color.WHITE);

        Circle ci2 = new Circle();
        ci2.setPoint(new Point(2, 5));
        ci2.setRadius(4);
        ci2.setColor(Color.YELLOW);

        Rectangle rec1 = new Rectangle();
        rec1.setPointA(new Point(1, 1));
        rec1.setPointC(new Point (7, 3));

        Point point1 = new Point(4, 4);

        Triangle tri2 = new Triangle();
        tri2.setA(new Point(-2, 3));
        tri2.setB(new Point (4, 3));
        tri2.setC(new Point(2, 5));

        shapes.add(tri1);
        shapes.add(ci1);
        shapes.add(ci2);
        shapes.add(rec1);
        shapes.add(point1);
        shapes.add(tri2);

        ShapesService service = new ShapesServiceImpl();
        double totalSquares = service.getSquares(shapes);
        double maxPerimeter = service.getMaxPerimeters(shapes);
        Set<Color> uniqueColors = service.getColors(shapes);
        System.out.println("Сумма всех площадей фигур: " + totalSquares);
        System.out.println("Максимальный периметр: " + maxPerimeter);
        System.out.println("Уникальные цвета фигур: " + uniqueColors);


    }
}