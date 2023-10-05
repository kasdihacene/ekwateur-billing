package org.ekwateur.adapters.parser;

import org.ekwateur.adapters.exceptions.ClientTypeNotRecognizedException;

import java.util.Arrays;

public enum ClientTypeParser {
    PRO("PRO"),
    IND("IND");

    private final String type;

    ClientTypeParser(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static ClientTypeParser buildType(String literalType) {
        return Arrays.stream(ClientTypeParser.values())
                .filter(clientType -> clientType.type.equals(literalType))
                .findFirst()
                .orElseThrow(() -> new ClientTypeNotRecognizedException("Please provide a correct Client type"));
    }
}
