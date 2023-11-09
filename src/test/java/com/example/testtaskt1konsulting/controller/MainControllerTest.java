package com.example.testtaskt1konsulting.controller;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MainControllerTest {

    @LocalServerPort
    private int port;
    @Test
    void getCountOfEachSymbolInLine_whenLineIsEmpty_ThanBadRequest() throws IOException {

        ClassicHttpRequest request = new HttpPost(String.format("http://localhost:%d/getAllSequenceElementsCount", port));
        request.addHeader("content-type", "text/plain");

        StringEntity requestString = new StringEntity("");
        request.setEntity(requestString);

        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assertions.assertEquals(response.getCode(), 400);

    }

    @Test
    void getCountOfEachSymbolInLine() throws IOException, ParseException {
        StringEntity expectedResponseString = new StringEntity("[{\"a\":6},{\"b\":4},{\"c\":1}]");

        ClassicHttpRequest request = new HttpPost(String.format("http://localhost:%d/getAllSequenceElementsCount", port));
        request.addHeader("content-type", "text/plain");

        StringEntity requestString = new StringEntity("aaaaaabbbbc");
        request.setEntity(requestString);

        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);

        String responseString = EntityUtils.toString(response.getEntity());

        Assertions.assertEquals(EntityUtils.toString(expectedResponseString), responseString);

    }
}