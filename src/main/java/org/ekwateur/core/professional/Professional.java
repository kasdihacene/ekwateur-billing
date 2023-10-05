package org.ekwateur.core.professional;

import org.ekwateur.core.ClientInvoice;

import java.math.BigDecimal;

public class Professional implements ClientInvoice {

    public Professional(String reference, String numSiret, String socialRx, BigDecimal ca) {
    }

    public Professional(String reference, String numSiret, String socialRx, BigDecimal ca, Object consumptionGaz, Object consumptionElectricity) {

    }

    @Override
    public BigDecimal computeInvoiceAmount() {
        return BigDecimal.ZERO;
    }
}
