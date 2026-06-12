package de.check24.framework.core.enums;

public enum HeaderMenuItem {
    ACTIVITIES("Aktivitäten"),
    NOTIFICATIONS("Mitteilungen"),
    LOGIN("Anmelden");

    private final String expectedText;

    HeaderMenuItem(String expectedText) {
        this.expectedText = expectedText;
    }

    public String expectedText() {
        return expectedText;
    }
}
