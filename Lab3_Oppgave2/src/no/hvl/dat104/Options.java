package no.hvl.dat104;

import java.util.HashMap;
import java.util.Map;

public class Options {

    private Map<Integer, String> alternatives;

    public Options() {
        this.alternatives = new HashMap<>();
    }

    public Map<Integer, String> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(Map<Integer, String> alternatives) {
        this.alternatives = alternatives;
    }
}
