package org.ekwateur.core;

import java.math.BigDecimal;

public class Client {
    protected final String reference;
    protected final BigDecimal consumptionGaz;
    protected final BigDecimal consumptionElectricity;

    public Client(String reference, BigDecimal consumptionGaz, BigDecimal consumptionElectricity) {

        this.reference = reference;
        this.consumptionGaz = consumptionGaz;
        this.consumptionElectricity = consumptionElectricity;
    }
}
