package com.cron_email.cron_email.core.enums;

/**
 * ░█▀▄░▀▀█░▀▀█░█▀█░█▀█░█▀█
 * ░█░█░░▀▄░░▀▄░█▀▀░█▀█░█░█
 * ░▀▀░░▀▀░░▀▀░░▀░░░▀░▀░▀░▀
 *
 * @author d33pan on 2/8/2026
 */
public enum EnumTemplate {
    MASSACHUSETTS("Massachusetts",  "MA"),
    MICHIGAN     ("Michigan",       "MI");
    // all 50 of those

    private final String full;
    private final String abbr;

    private EnumTemplate(String full, String abbr) {
        this.full = full;
        this.abbr = abbr;
    }

    public String getFullName() {
        return full;
    }

    public String getAbbreviatedName() {
        return abbr;
    }
}
