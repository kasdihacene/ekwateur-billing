package org.ekwateur.core;

import org.ekwateur.core.exceptions.PreventIncorrectClientReferenceException;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {

    private static final String REGEX_PATTERN = "^(EKW)([0-9]{8})$";
    protected final String reference;
    protected final BigDecimal consumptionGaz;
    protected final BigDecimal consumptionElectricity;

    public Client(String reference, BigDecimal consumptionGaz, BigDecimal consumptionElectricity) {

        validate(reference);
        this.reference = reference;
        this.consumptionGaz = consumptionGaz;
        this.consumptionElectricity = consumptionElectricity;
    }

    private void validate(String reference) {
        Pattern compiler = Pattern.compile(REGEX_PATTERN);
        Matcher matcher = compiler.matcher(reference);
        if (!matcher.matches()) {
            throw new PreventIncorrectClientReferenceException(String.format("The given client reference is mal-formatted [%s]", reference));
        }
    }
}
