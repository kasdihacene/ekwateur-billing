package org.ekwateur.core.professional;

import org.ekwateur.core.Client;
import org.ekwateur.core.ClientInvoice;

import java.math.BigDecimal;

public class Professional
        extends Client
        implements ClientInvoice {

    private final String numSiret;
    private final String socialRx;
    private final BigDecimal ca;

    public Professional(String reference, String numSiret, String socialRx, BigDecimal ca) {
        super(reference, BigDecimal.ZERO, BigDecimal.ZERO);
        this.numSiret = numSiret;
        this.socialRx = socialRx;
        this.ca = ca;
    }

    public Professional(String reference, String numSiret, String socialRx, BigDecimal ca, BigDecimal consumptionGaz, BigDecimal consumptionElectricity) {

        super(reference, consumptionGaz, consumptionElectricity);
        this.numSiret = numSiret;
        this.socialRx = socialRx;
        this.ca = ca;
    }

    @Override
    public BigDecimal computeInvoiceAmount() {
        return ConsumptionProType.GAZ.compute(consumptionGaz, ca)
                .add(ConsumptionProType.ELECTRICITY.compute(consumptionElectricity, ca));
    }

    @Override
    public void print() {
        System.out.println("""
                ---------------------------
                Facture pour le client [%s]
                - Entreprise : N° Siret %s - Réseau sociale %s
                ---------------------------
                    Consommation Gaz            %s
                    Consommation éléctricité    %s
                    
                    - Total : %s €
                ---------------------------
                """.formatted(
                reference,
                numSiret,
                socialRx,
                consumptionGaz,
                consumptionElectricity,
                computeInvoiceAmount()));
    }
}
