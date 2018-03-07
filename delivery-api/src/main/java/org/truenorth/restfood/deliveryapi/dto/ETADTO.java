package org.truenorth.restfood.deliveryapi.dto;

public class ETADTO {

    private String etaMessage;

    public ETADTO(String etaMessage) {
        this.etaMessage = etaMessage;
    }

    public String getEtaMessage() {
        return etaMessage;
    }

    public void setEtaMessage(String eta) {
        this.etaMessage = eta;
    }
}
