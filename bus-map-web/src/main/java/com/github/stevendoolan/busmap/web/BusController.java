package com.github.stevendoolan.busmap.web;

import com.github.stevendoolan.busmap.model.Locations;
import com.github.stevendoolan.busmap.model.ErrorInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Steven Doolan on 7/05/2016.
 */
@RestController
public class BusController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/bus/{direction}/{route}")
    public ResponseEntity<Locations> busLocations(
            @PathVariable("direction") String direction,
            @PathVariable("route") String route
            ) {
        Locations locations = new Locations();
        locations.setMessage("test");
        return new ResponseEntity<Locations>(locations, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInformation> exceptionHandler(Exception e) {
        logger.error("Unknown Error", e);
        ErrorInformation errorInformation = new ErrorInformation();
        errorInformation.setMessage(e.getMessage());
        return new ResponseEntity<ErrorInformation>(errorInformation, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
