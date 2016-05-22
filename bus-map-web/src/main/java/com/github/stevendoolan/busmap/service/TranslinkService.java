package com.github.stevendoolan.busmap.service;

import com.github.stevendoolan.busmap.model.Position;
import com.github.stevendoolan.busmap.model.ServiceException;

import java.util.List;

/**
 * Created by Steven Doolan on 22/05/2016.
 */
public interface TranslinkService {

    List<Position> getPositions(String tripNumber) throws ServiceException;

}
