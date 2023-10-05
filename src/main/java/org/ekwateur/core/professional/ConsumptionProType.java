package org.ekwateur.core.professional;

import java.math.BigDecimal;

import static java.util.Optional.ofNullable;

public enum ConsumptionProType {
    GAZ {
        @Override
        public BigDecimal compute(BigDecimal consumption, BigDecimal ca) {
            if (CA_LIMIT.compareTo(ca) <= 0)
                return ofNullable(consumption)
                        .orElse(BigDecimal.ZERO)
                        .multiply(BigDecimal.valueOf(PRO_GAZ_MORE_THAN_CA_LIMIT_PRICE));

            return ofNullable(consumption)
                    .orElse(BigDecimal.ZERO)
                    .multiply(BigDecimal.valueOf(PRO_GAZ_LESS_THAN_CA_LIMIT_PRICE));
        }
    },
    ELECTRICITY {
        @Override
        public BigDecimal compute(BigDecimal consumption, BigDecimal ca) {
            if (CA_LIMIT.compareTo(ca) <= 0)
                return ofNullable(consumption)
                        .orElse(BigDecimal.ZERO)
                        .multiply(BigDecimal.valueOf(PRO_ELECTRICITY_MORE_THAN_CA_LIMIT_PRICE));

            return ofNullable(consumption)
                    .orElse(BigDecimal.ZERO)
                    .multiply(BigDecimal.valueOf(PRO_ELECTRICITY_LESS_THAN_CA_LIMIT_PRICE));
        }
    };

    private static final BigDecimal CA_LIMIT = BigDecimal.valueOf(1000000);
    private static final double PRO_ELECTRICITY_LESS_THAN_CA_LIMIT_PRICE = 0.118;
    private static final double PRO_ELECTRICITY_MORE_THAN_CA_LIMIT_PRICE = 0.114;
    private static final double PRO_GAZ_LESS_THAN_CA_LIMIT_PRICE = 0.113;
    private static final double PRO_GAZ_MORE_THAN_CA_LIMIT_PRICE = 0.111;

    public abstract BigDecimal compute(BigDecimal consumption, BigDecimal ca);
}
