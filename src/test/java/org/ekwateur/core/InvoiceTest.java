package org.ekwateur.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class InvoiceTest {

    @Test
    void shouldCalculateAmountForParticularConsumerWithoutGazAndElectricity() {
        ClientInvoice clientInvoice = new Individual("EKW12345678", "Mr", "Alain", "Delon");

        BigDecimal actualResult = clientInvoice.computeInvoiceAmount();
        Assertions.assertThat(actualResult).isEqualByComparingTo(BigDecimal.ZERO);
    }
}
