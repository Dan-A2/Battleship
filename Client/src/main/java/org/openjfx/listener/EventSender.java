package org.openjfx.listener;

import ir.sharif.ap.hw4.event.EvenToken;
import ir.sharif.ap.hw4.event.Event;
import ir.sharif.ap.hw4.response.Response;

public interface EventSender {
    Response send(EvenToken evenToken);

    void close();
}