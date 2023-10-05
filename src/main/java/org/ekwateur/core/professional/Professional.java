package org.ekwateur.core.professional;

import org.ekwateur.core.ClientInvoice;

import java.math.BigDecimal;

public class Professional implements ClientInvoice {

    private final String reference;
    private final String numSiret;
    private final String socialRx;
    private final BigDecimal ca;
    private final BigDecimal consumptionGaz;
    private final BigDecimal consumptionElectricity;

    public Professional(String reference, String numSiret, String socialRx, BigDecimal ca) {
        this.reference = reference;
        this.numSiret = numSiret;
        this.socialRx = socialRx;
        this.ca = ca;
        this.consumptionGaz = BigDecimal.ZERO;
        this.consumptionElectricity = BigDecimal.ZERO;
    }

    public Professional(String reference, String numSiret, String socialRx, BigDecimal ca, BigDecimal consumptionGaz, BigDecimal consumptionElectricity) {

        this.reference = reference;
        this.numSiret = numSiret;
        this.socialRx = socialRx;
        this.ca = ca;
        this.consumptionGaz = consumptionGaz;
        this.consumptionElectricity = consumptionElectricity;
    }

    @Override
    public BigDecimal computeInvoiceAmount() {
        return ConsumptionProType.GAZ.compute(consumptionGaz, ca)
                .add(ConsumptionProType.ELECTRICITY.compute(consumptionElectricity, ca));
    }
}
