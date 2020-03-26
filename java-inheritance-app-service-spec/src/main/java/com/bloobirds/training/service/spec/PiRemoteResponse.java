package com.bloobirds.training.service.spec;

import lombok.Data;

@Data
public class PiRemoteResponse {

    private String value;

    public static PiRemoteResponse of(String value) {
        PiRemoteResponse piRemoteResponse = new PiRemoteResponse();
        piRemoteResponse.setValue(value);
        return piRemoteResponse;
    }

}
