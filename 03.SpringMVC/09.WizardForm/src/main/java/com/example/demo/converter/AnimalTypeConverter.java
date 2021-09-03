package com.example.demo.converter;

import com.example.demo.domain.AnimalType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AnimalTypeConverter implements Converter<String, AnimalType> {

    @Override
    public AnimalType convert(String index) {
        return AnimalType.values()[Integer.parseInt(index)];
    }
}
