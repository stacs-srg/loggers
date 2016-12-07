package uk.ac.standrews.cs;

/**
 * @author Simone I. Conte "sic2@st-andrews.ac.uk"
 */
public enum LEVEL {

    INFO("INFO"),
    DEBUG("DEBUG"),
    WARN("WARN"),
    ERROR("ERROR");

    private final String text;

    LEVEL(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
