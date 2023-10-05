package org.ekwateur.adapters;

import org.ekwateur.adapters.parser.ClientParser;
import org.ekwateur.adapters.parser.ClientTypeParser;
import org.ekwateur.core.ClientInvoice;
import org.ekwateur.core.individual.Individual;
import org.ekwateur.core.professional.Professional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ClientFactoryAdapter {

    public static ClientInvoice computeInvoiceClient(String[] args) {

        ClientTypeParser clientType = ClientTypeParser.buildType(ClientParser.getFirstToken(args));
        return switch (clientType) {
            case IND -> buildIndividual(args);
            case PRO -> buildPro(args);
        };
    }

    private static ClientInvoice buildPro(String[] proArgs) {
        //TODO: Add format validation for PRO csv line
        List<String> proTokens = ClientParser.parse(proArgs);
        return new Professional(proTokens.get(1),
                proTokens.get(2),
                proTokens.get(3),
                getBigDecimalValue(proTokens.get(4)),
                getBigDecimalValue(proTokens.get(5)),
                getBigDecimalValue(proTokens.get(6)));
    }

    private static ClientInvoice buildIndividual(String[] individualArgs) {
        //TODO: Add format validation for IND csv line
        List<String> proTokens = ClientParser.parse(individualArgs);
        return new Individual(proTokens.get(1),
                proTokens.get(2),
                proTokens.get(3),
                proTokens.get(4),
                getBigDecimalValue(proTokens.get(5)),
                getBigDecimalValue(proTokens.get(6)));
    }

    private static BigDecimal getBigDecimalValue(String value) {
        if (Objects.isNull(value) || value.isBlank()) return BigDecimal.ZERO;
        return new BigDecimal(value);
    }
}
