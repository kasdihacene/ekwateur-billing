package org.ekwateur.adapters.parser;

import java.util.Arrays;
import java.util.List;

public class ClientParser {

    private static final int CSV_LINE = 0;
    private static final String SEPARATOR = ";";
    private static final int NOT_DISCARD_EMPTY_FIELDS = -1;

    public static List<String> parse(String[] args) {
        return Arrays.stream(args[CSV_LINE]
                        .trim()
                        .split(SEPARATOR, NOT_DISCARD_EMPTY_FIELDS))
                .toList();
    }

    public static String getFirstToken(String[] args) {
        return parse(args)
                .get(0);
    }
}
