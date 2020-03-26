package com.bloobirds.training.service.remote;

import com.bloobirds.training.service.spec.PiRemoteResponse;
import com.bloobirds.training.service.spec.PiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class PiServiceRemote implements PiService {

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public double computePi() {
        try {
            log.info("Going to request to pi api");
            Request request = new Request.Builder()
                    .url("http://127.0.0.1:8080/computePi")
                    .addHeader("content-type", "application/json")
                    .get()
                    .build();
            Response httpResponse = client.newCall(request).execute();
            log.info("Request to pi api with result {}", httpResponse.code());
            ResponseBody body = httpResponse.body();
            PiRemoteResponse piRemoteResponse = objectMapper.readValue(body.string(), PiRemoteResponse.class);
            return Double.parseDouble(piRemoteResponse.getValue());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
