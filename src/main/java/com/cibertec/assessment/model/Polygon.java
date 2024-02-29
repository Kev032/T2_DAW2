package com.cibertec.assessment.model;

import com.cibertec.assessment.IntegerArrayConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Polygon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int npoints;

    @Column(columnDefinition = "json", name = "x_points")
    @Convert(converter = IntegerArrayConverter.class)
    private Integer[] xPoints;

    @Column(columnDefinition = "json", name = "y_points")
    @Convert(converter = IntegerArrayConverter.class)
    private Integer[] yPoints;
}