package service.impl;

import colors.Color;
import service.ShapesService;
import shapes.Shape;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShapesServiceImpl implements ShapesService {
    @Override
    public double getSquares(List<Shape> shapeList) {
        double totalSquare = 0;
        for(int i = 0; i < shapeList.size(); i++){
            totalSquare += shapeList.get(i).getSquare();
        }
        return totalSquare;
    }

    @Override
    public double getMaxPerimeters(List<Shape> shapeList) {
        double maxFlat = 0;
        for(int i = 0; i < shapeList.size(); i++){
            if (shapeList.get(i).getFlat() > maxFlat){
                maxFlat = shapeList.get(i).getFlat();
            }
        }
        return maxFlat;
    }

    @Override
    public Set<Color> getColors(List<Shape> shapeList) {
        Set<Color> uniqueColors = new HashSet<>();
        for(int i = 0; i < shapeList.size(); i++){
            uniqueColors.add(shapeList.get(i).getColor());
        }
        return uniqueColors;
    }
}