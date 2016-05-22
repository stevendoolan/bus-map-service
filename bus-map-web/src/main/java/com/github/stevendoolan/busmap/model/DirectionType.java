package com.github.stevendoolan.busmap.model;

import org.apache.tomcat.util.http.fileupload.util.Streams;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Created by Steven Doolan on 22/05/2016.
 */
public enum DirectionType {
    INBOUND(0), OUTBOUND(1);

    private int code;

    DirectionType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static DirectionType forCode(int code) {
        Optional<DirectionType> first = Arrays.stream(values())
                .filter(value -> value.code == code)
                .findFirst();
        return first.orElseThrow(() -> new IllegalArgumentException("Unknown Code " + code));
    }
}
