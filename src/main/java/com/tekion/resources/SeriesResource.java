package com.tekion.resources;

import com.tekion.beans.Series;
import com.tekion.controller.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/series")
public class SeriesResource {

    @Autowired
    private SeriesRepository seriesRepository;

    @GetMapping("{seriesId}")
    public Series getSeriesDetails(@PathVariable("seriesId") int seriesId){
        return seriesRepository.getBySeriesId(seriesId);
    }

}
