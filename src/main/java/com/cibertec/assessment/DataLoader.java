package com.cibertec.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cibertec.assessment.model.Polygon;
import com.cibertec.assessment.service.PolygonService;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

   @Autowired
    PolygonService polygonService;

    @PostConstruct
    public void initializeData() {
        List<Polygon> list = new ArrayList<>();

        String[] xpoint1 = { "10", "205", "305", "405", "500" };
        String[] ypoint1 = { "10", "501", "506", "107", "30" };

        String[] xpoint2 = { "100", "605", "305", "405", "500" };
        String[] ypoint2 = { "100", "601", "506", "337", "300" };

        // Convertir arrays de String a Integer
        Integer[] xPoints1 = Arrays.stream(xpoint1).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] yPoints1 = Arrays.stream(ypoint1).map(Integer::parseInt).toArray(Integer[]::new);

        Integer[] xPoints2 = Arrays.stream(xpoint2).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] yPoints2 = Arrays.stream(ypoint2).map(Integer::parseInt).toArray(Integer[]::new);

        // Construir objetos Polygon con los arrays de Integer
        Polygon polygon1 = new Polygon().builder().name("Poligon 01").xPoints(xPoints1).yPoints(yPoints1).build();
        Polygon polygon2 = new Polygon().builder().name("Poligon 02").xPoints(xPoints2).yPoints(yPoints2).build();

        list.add(polygon1);
        list.add(polygon2);

        polygonService.create(list);
    }
}
