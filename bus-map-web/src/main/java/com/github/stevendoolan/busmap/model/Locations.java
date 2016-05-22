package com.github.stevendoolan.busmap.model;

import java.util.List;

public class Locations {

    private String message;
    private List<Position> positions;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}
