package org.ekwateur.core;

import org.assertj.core.api.Assertions;
import org.ekwateur.core.professional.Professional;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ProfessionalInvoiceTest {

    @Test
    void shouldCalculateAmountForProfessionalConsumerWithoutGazAndElectricity() {
        ClientInvoice clientInvoice = new Professional("EKW12345678", "SRT00012", "SOCIAL_001", BigDecimal.valueOf(1000000));

        BigDecimal actualResult = clientInvoice.computeInvoiceAmount();
        Assertions.assertThat(actualResult).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void shouldCalculateAmountForProfessionalConsumerWithoutGazAndElectricityHavingNullValues() {
        ClientInvoice clientInvoice = new Professional("EKW12345678", "SRT00012", "SOCIAL_001", BigDecimal.valueOf(20000000), null, null);

        BigDecimal actualResult = clientInvoice.computeInvoiceAmount();
        Assertions.assertThat(actualResult).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void shouldCalculateAmountForProfessionalConsumerWithGazAndElectricityConsumptions() {
        ClientInvoice clientInvoice = new Professional("EKW12345678", "SRT00012", "SOCIAL_001", BigDecimal.valueOf(1000000), BigDecimal.ONE, BigDecimal.ONE);

        BigDecimal actualResult = clientInvoice.computeInvoiceAmount();
        BigDecimal expectedResult = BigDecimal.valueOf(0.225);
        Assertions.assertThat(actualResult).isEqualByComparingTo(expectedResult);
    }

    @Test
    void shouldCalculateAmountForProfessionalConsumerWithGazAndElectricityExceedsCALimit() {
        BigDecimal ca = BigDecimal.valueOf(1000000);
        ClientInvoice clientInvoice = new Professional("EKW12345678", "SRT00012", "SOCIAL_001", ca, BigDecimal.ONE, BigDecimal.ONE);

        BigDecimal actualResult = clientInvoice.computeInvoiceAmount();
        BigDecimal expectedResult = BigDecimal.valueOf(0.225);
        Assertions.assertThat(actualResult).isEqualByComparingTo(expectedResult);
    }

    @Test
    void shouldCalculateAmountForProfessionalConsumerWithGazAndElectricityLessThanCALimit() {
        BigDecimal ca = BigDecimal.valueOf(900000);
        ClientInvoice clientInvoice = new Professional("EKW12345678", "SRT00012", "SOCIAL_001", ca, BigDecimal.ONE, BigDecimal.ONE);

        BigDecimal actualResult = clientInvoice.computeInvoiceAmount();
        BigDecimal expectedResult = BigDecimal.valueOf(0.231);
        Assertions.assertThat(actualResult).isEqualByComparingTo(expectedResult);
    }

    @Test
    void shouldCalculateAmountForProfessionalConsumerWithGazAndElectricityLessThanCALimitWithHugeConsumption() {
        BigDecimal ca = BigDecimal.valueOf(900000);
        ClientInvoice clientInvoice = new Professional("EKW12345678", "SRT00012", "SOCIAL_001", ca, BigDecimal.valueOf(1000), BigDecimal.valueOf(1000));

        BigDecimal actualResult = clientInvoice.computeInvoiceAmount();
        BigDecimal expectedResult = BigDecimal.valueOf(231);
        Assertions.assertThat(actualResult).isEqualByComparingTo(expectedResult);
    }


    @Test
    void shouldCalculateAmountForProfessionalConsumerWithGazAndElectricityWithNoCA() {
        ClientInvoice clientInvoice = new Professional("EKW12345678", "SRT00012", "SOCIAL_001", null, BigDecimal.ONE, BigDecimal.ONE);

        BigDecimal actualResult = clientInvoice.computeInvoiceAmount();
        BigDecimal expectedResult = BigDecimal.valueOf(0.231);
        Assertions.assertThat(actualResult).isEqualByComparingTo(expectedResult);
    }

    @Test
    void shouldCalculateAmountForProfessionalConsumerWithGazAndElectricityWithZeroCA() {
        ClientInvoice clientInvoice = new Professional("EKW12345678", "SRT00012", "SOCIAL_001", BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ONE);

        BigDecimal actualResult = clientInvoice.computeInvoiceAmount();
        BigDecimal expectedResult = BigDecimal.valueOf(0.231);
        Assertions.assertThat(actualResult).isEqualByComparingTo(expectedResult);
    }
}
