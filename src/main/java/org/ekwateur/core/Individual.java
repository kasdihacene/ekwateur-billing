package org.ekwateur.core;

import java.math.BigDecimal;

public class Individual implements ClientInvoice {

    public Individual(String reference, String gender, String firstname, String lastname) {
    }

    @Override
    public BigDecimal computeInvoiceAmount() {
        return BigDecimal.ZERO;
    }
}
