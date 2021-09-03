package com.example.demo.converters;

import com.example.demo.domain.Sport;
import com.example.demo.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class SportConverter implements Converter<String, Sport> {

    Logger logger = LoggerFactory.getLogger(SportConverter.class);

    private PlayerService playerService;

    public SportConverter(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public Sport convert(String s) {
        int id = Integer.parseInt(s);
        Sport sport = playerService.getSport(id);
        logger.info(sport.toString());
        return sport;
    }
}
