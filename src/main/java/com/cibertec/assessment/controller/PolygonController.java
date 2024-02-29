package com.cibertec.assessment.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.assessment.beans.PolygonBean;
import com.cibertec.assessment.model.Polygon;
import com.cibertec.assessment.service.PolygonService;

@RestController
@RequestMapping("/polygons")
public class PolygonController {

    @Autowired
    private PolygonService polygonService;
    
    @GetMapping
    public ResponseEntity<List<PolygonBean>> listPolygons() {
        List<PolygonBean> polygons = polygonService.list();
        return new ResponseEntity<>(polygons, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Polygon> createPolygon(@RequestBody PolygonBean polygonBean) {
        System.out.println("Received PolygonBean: " + polygonBean);

        Polygon polygon = new Polygon();
        polygon.setName(polygonBean.getName());
        polygon.setNpoints(polygonBean.getNpoints());

        System.out.println("Received xPoints: " + Arrays.toString(polygonBean.getXPoints()));
        System.out.println("Received yPoints: " + Arrays.toString(polygonBean.getYPoints()));

        // Asigna los arreglos de enteros directamente
        polygon.setXPoints(polygonBean.getXPoints());
        polygon.setYPoints(polygonBean.getYPoints());

        polygonService.create(polygon);

        System.out.println("Stored Polygon: " + polygon);

        return new ResponseEntity<>(polygon, HttpStatus.CREATED);
    }
}