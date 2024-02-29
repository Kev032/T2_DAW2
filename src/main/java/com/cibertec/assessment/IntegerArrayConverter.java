package com.cibertec.assessment;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
@Converter
public class IntegerArrayConverter implements AttributeConverter<Integer[], String>{
	
	private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Integer[] attribute) {
        if (attribute == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting Integer[] to JSON", e);
        }
    }

    @Override
    public Integer[] convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        try {
            return objectMapper.readValue(dbData, Integer[].class);
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON to Integer[]", e);
        }
    }

}
