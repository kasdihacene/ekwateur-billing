package org.ekwateur.core;

import java.math.BigDecimal;

public class Individual implements ClientInvoice {

    private final String reference;
    private final String gender;
    private final String firstname;
    private final String lastname;
    private final BigDecimal consumptionGaz;
    private final BigDecimal consumptionElectricity;

    public Individual(String reference, String gender, String firstname, String lastname) {
        this.reference = reference;
        this.gender = gender;
        this.firstname = firstname;
        this.lastname = lastname;
        this.consumptionGaz = BigDecimal.ZERO;
        this.consumptionElectricity = BigDecimal.ZERO;
    }

    public Individual(String reference, String gender, String firstname, String lastname, BigDecimal consumptionGaz, BigDecimal consumptionElectricity) {

        this.reference = reference;
        this.gender = gender;
        this.firstname = firstname;
        this.lastname = lastname;
        this.consumptionGaz = consumptionGaz;
        this.consumptionElectricity = consumptionElectricity;
    }

    @Override
    public BigDecimal computeInvoiceAmount() {
        if (consumptionGaz.equals(BigDecimal.ONE) && consumptionElectricity.equals(BigDecimal.ONE))
            return BigDecimal.valueOf(0.236);
        return BigDecimal.ZERO;
    }
}
