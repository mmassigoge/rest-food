package org.truenorth.restfood.deliveryapi.controller;

public class ETA {

    private String etaMessage;

    public ETA(String etaMessage) {
        this.etaMessage = etaMessage;
    }

    public String getEtaMessage() {
        return etaMessage;
    }

    public void setEtaMessage(String eta) {
        this.etaMessage = eta;
    }
}
