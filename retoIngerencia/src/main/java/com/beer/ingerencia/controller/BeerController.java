package com.beer.ingerencia.controller;

import com.beer.ingerencia.constant.ServiceNames;
import com.beer.ingerencia.model.Beer;
import com.beer.ingerencia.model.Log;
import com.beer.ingerencia.service.BeerService;
import com.beer.ingerencia.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.sql.Timestamp;

@RestController
public class BeerController {
    @Autowired
    private BeerService beerService;

    @Autowired
    private LogService logService;

    //Servicio que muestra todas las cervezas disponibles
    @CrossOrigin
    @GetMapping("/beers")
    public List<Beer> findAllBeers(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long startTime = System.currentTimeMillis();
        List<Beer> beers = beerService.findAllBeers();
        long endTime = System.currentTimeMillis();
        double tiempo = (double) ((endTime - startTime));

        Log log = new Log();
        log.setService_name(ServiceNames.FIND_ALL_BEERS);
        log.setResponse_time(tiempo +" milisegundos");
        log.setExecution_hour(timestamp);
        logService.insertLog(log);
        return beers;
    }

    //Servicio de busqueda de cerveza por nombre
    @CrossOrigin
    @GetMapping("/beers/{name}")
    public List<Beer> findBeersByName(@PathVariable("name") String name){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long startTime = System.currentTimeMillis();
        List<Beer> listBeer = beerService.findBeersByName(name);
        long endTime = System.currentTimeMillis();
        double tiempo = (double) ((endTime - startTime));

        Log log = new Log();
        log.setService_name(ServiceNames.FIND_BY_NAME);
        log.setResponse_time(tiempo +" milisegundos");
        log.setExecution_hour(timestamp);
        logService.insertLog(log);
        return listBeer;
    }

    //Servicio de recomendacion de cerveza aleatoria
    @CrossOrigin
    @GetMapping("/beers/random")
    public Beer findBeerRandom(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long startTime = System.currentTimeMillis();
        Beer beer = beerService.findBeerRandom();
        long endTime = System.currentTimeMillis();
        double tiempo = (double) ((endTime - startTime));

        Log log = new Log();
        log.setService_name(ServiceNames.FIND_RANDOM);
        log.setResponse_time(tiempo +" milisegundos");
        log.setExecution_hour(timestamp);
        logService.insertLog(log);
        return beer;
    }
}
