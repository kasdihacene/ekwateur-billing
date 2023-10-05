package org.ekwateur.adapters;

import org.ekwateur.adapters.exceptions.ClientTypeNotRecognizedException;

import java.util.Arrays;

public enum ClientType {
    PRO("PRO"),
    IND("IND");

    private final String type;

    ClientType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static ClientType buildType(String literalType) {
        return Arrays.stream(ClientType.values())
                .filter(clientType -> clientType.type.equals(literalType))
                .findFirst()
                .orElseThrow(() -> new ClientTypeNotRecognizedException(String.format("Please provide Client type within the following list %s", ClientType.values())));
    }
}
