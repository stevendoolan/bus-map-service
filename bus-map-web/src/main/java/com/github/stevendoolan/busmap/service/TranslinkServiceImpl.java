package com.github.stevendoolan.busmap.service;

import com.github.stevendoolan.busmap.model.DirectionType;
import com.github.stevendoolan.busmap.model.Position;
import com.github.stevendoolan.busmap.model.ServiceException;
import com.google.transit.realtime.GtfsRealtime;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Steven Doolan on 22/05/2016.
 */
@Component
public class TranslinkServiceImpl implements TranslinkService {

    @Override
    public List<Position> getPositions(String tripNumber) throws ServiceException {
        String path = "https://gtfsrt.api.translink.com.au/feed/seq";
        try {
            URL url = new URL(path);
            GtfsRealtime.FeedMessage feedMessage = GtfsRealtime.FeedMessage.parseFrom(url.openStream());

            if (CollectionUtils.isEmpty(feedMessage.getEntityList())) {
                return Collections.emptyList();
            } else {
                List<GtfsRealtime.FeedEntity> entities = feedMessage.getEntityList().stream()
                        .filter(entity -> entity.getVehicle().hasPosition())
                        .filter(entity -> StringUtils.startsWith(entity.getVehicle().getTrip().getRouteId(), tripNumber))
                        .collect(Collectors.toList());
                if (CollectionUtils.isEmpty(entities)) {
                    return Collections.emptyList();
                } else {
                    return entities.stream()
                            .map(this::getPosition)
                            .collect(Collectors.toList());
                }
            }

        } catch (Exception e) {
            throw new ServiceException("Cannot get feed at url " + path, e);
        }
    }

    private Position getPosition(GtfsRealtime.FeedEntity entity) {
        Position position = new Position();
        GtfsRealtime.VehiclePosition vehicle = entity.getVehicle();
        position.setRouteId(vehicle.getTrip().getRouteId());
        position.setLongitude(vehicle.getPosition().getLongitude());
        position.setLatitude(vehicle.getPosition().getLatitude());
        position.setDirection(DirectionType.forCode(vehicle.getTrip().getDirectionId()));
        return position;
    }

}
