package com.github.stevendoolan.busmap.service

import com.github.stevendoolan.busmap.Application
import com.github.stevendoolan.busmap.model.Position
import com.google.transit.realtime.GtfsRealtime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by Steven Doolan on 22/05/2016.
 */
@ContextConfiguration(classes = Application.class)
class TranslinkServiceImplIntegrationTest extends Specification {

    @Autowired
    TranslinkService translinkService

    def "GetFeedMessages"() {
        when:
        List<Position> message = translinkService.getPositions("200")

        then:
        message != null
    }

}
