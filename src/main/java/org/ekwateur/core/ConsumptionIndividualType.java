package org.ekwateur.core;

import java.math.BigDecimal;

import static java.util.Optional.ofNullable;

public enum ConsumptionIndividualType {
    GAZ {
        @Override
        public BigDecimal compute(BigDecimal consumption) {
            return ofNullable(consumption)
                    .orElse(BigDecimal.ZERO)
                    .multiply(BigDecimal.valueOf(PARTICULAR_GAZ_PRICE));
        }
    },
    ELECTRICITY {
        @Override
        public BigDecimal compute(BigDecimal consumption) {
            return ofNullable(consumption)
                    .orElse(BigDecimal.ZERO)
                    .multiply(BigDecimal.valueOf(PARTICULAR_ELECTRICITY_PRICE));
        }
    };

    private static final double PARTICULAR_ELECTRICITY_PRICE = 0.121;
    private static final double PARTICULAR_GAZ_PRICE = 0.115;

    public abstract BigDecimal compute(BigDecimal consumption);
}
