package controller;

import ir.sharif.ap.hw4.event.EvenToken;
import ir.sharif.ap.hw4.event.Event;
import ir.sharif.ap.hw4.response.Response;

public interface ResponseSender {
    void sendResponse(Response response);

    EvenToken getEvenToken();

    void close();
}