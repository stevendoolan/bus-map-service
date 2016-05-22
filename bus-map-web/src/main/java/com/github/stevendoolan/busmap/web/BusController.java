package com.github.stevendoolan.busmap.web;

import com.github.stevendoolan.busmap.model.Locations;
import com.github.stevendoolan.busmap.model.ErrorInformation;
import com.github.stevendoolan.busmap.model.ServiceException;
import com.github.stevendoolan.busmap.service.TranslinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private TranslinkService translinkService;

    @Autowired
    public void setTranslinkService(TranslinkService translinkService) {
        this.translinkService = translinkService;
    }

    @RequestMapping("/bus/{route}/{direction}")
    public ResponseEntity<Locations> busLocations (
            @PathVariable("route") String route,
            @PathVariable("direction") String direction
            ) throws ServiceException {
        Locations locations = new Locations();
        locations.setMessage("test");
        locations.setPositions(translinkService.getPositions(route));

        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInformation> exceptionHandler(Exception e) {
        logger.error("Unknown Error", e);
        ErrorInformation errorInformation = new ErrorInformation();
        errorInformation.setMessage(e.getMessage());
        return new ResponseEntity<>(errorInformation, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
