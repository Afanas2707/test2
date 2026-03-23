package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GitHistoryParser {

    private static final Logger LOGGER = Logger.getLogger(GitHistoryParser.class.getName());

    private static final int MAX_COMMITS_LIMIT = 500;
    private static final int SHORT_HASH_LENGTH = 7;
    private static final int DEFAULT_RECENT_COMMITS = 10;

    public List<String> parseLog(String rawData, int limit) {
        if (limit > MAX_COMMITS_LIMIT) {
            LOGGER.log(Level.WARNING, "Error: limit too high ({0})", limit);
            return Collections.emptyList(); // Возвращаем пустой список вместо null
        }

        List<String> parsedHashes = new ArrayList<>();
        String[] logLines = rawData.split("\n");

        for (int i = 0; i < logLines.length; i++) {
            if (i == limit) {
                break;
            }
            String singleLine = logLines[i];
            if (singleLine.length() > SHORT_HASH_LENGTH) {
                parsedHashes.add(singleLine.substring(0, SHORT_HASH_LENGTH));
            }
        }
        return parsedHashes;
    }

    public List<String> parseRecentLog(String rawData) {
        return parseLog(rawData, DEFAULT_RECENT_COMMITS);
    }
}