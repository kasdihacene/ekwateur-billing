package org.ekwateur.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvoiceTest {

    @Test
    void shouldCalculateAmountForIndividualConsumerWithoutGazAndElectricity() {
        ClientInvoice clientInvoice = new Individual("EKW12345678", "Mr", "Alain", "Delon");

        BigDecimal actualResult = clientInvoice.computeInvoiceAmount();
        Assertions.assertThat(actualResult).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void shouldCalculateAmountForIndividualConsumerWithGazAndElectricity() {
        ClientInvoice clientInvoice = new Individual("EKW12345678", "Mr", "Alain", "Delon", BigDecimal.ONE, BigDecimal.ONE);

        BigDecimal actualResult = clientInvoice.computeInvoiceAmount();
        BigDecimal expected = BigDecimal.valueOf(0.236);
        assertEquals(expected, actualResult);
    }

    @Test
    void shouldCalculateAmountForIndividualConsumerWithHigherGazAndElectricityConsumption() {
        ClientInvoice clientInvoice = new Individual("EKW12345678", "Mr", "Alain", "Delon", BigDecimal.TEN, BigDecimal.TEN);

        BigDecimal actualResult = clientInvoice.computeInvoiceAmount();
        BigDecimal expected = BigDecimal.valueOf(2.36);
        Assertions.assertThat(actualResult).isEqualByComparingTo(expected);
    }


    @Test
    void shouldCalculateAmountForIndividualConsumerWithHigherGazConsumptionWithoutElectricity() {
        ClientInvoice clientInvoice = new Individual("EKW12345678", "Mr", "Alain", "Delon", BigDecimal.TEN, null);

        BigDecimal actualResult = clientInvoice.computeInvoiceAmount();
        BigDecimal expected = BigDecimal.valueOf(1.15);
        Assertions.assertThat(actualResult).isEqualByComparingTo(expected);
    }
}
