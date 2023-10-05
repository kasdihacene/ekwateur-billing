package org.ekwateur.core;

import java.math.BigDecimal;

public class Individual
        extends Client
        implements ClientInvoice {

    private final String gender;
    private final String firstname;
    private final String lastname;

    public Individual(String reference, String gender, String firstname, String lastname) {

        super(reference, BigDecimal.ZERO, BigDecimal.ZERO);
        this.gender = gender;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Individual(String reference, String gender, String firstname, String lastname, BigDecimal consumptionGaz, BigDecimal consumptionElectricity) {

        super(reference, consumptionGaz, consumptionElectricity);
        this.gender = gender;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public BigDecimal computeInvoiceAmount() {
        return ConsumptionIndividualType.GAZ.compute(consumptionGaz)
                .add(ConsumptionIndividualType.ELECTRICITY.compute(consumptionElectricity));
    }
}
