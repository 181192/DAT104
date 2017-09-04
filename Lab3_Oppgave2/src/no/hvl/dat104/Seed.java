package no.hvl.dat104;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Seed {
    private List<String> options;

    Seed() {
        options = new ArrayList<>();
    }

    public ArrayList<String> getOptions() {
        return (ArrayList<String>) this.options;
    }

    void setOptions(List<String> options) {
        this.options = options;
    }

    void seedHashMaps(
            Map<Integer, Integer> votes,
            Map<Integer, String> alternatives) {

        for (int i = 0; i < options.size(); i++) {
            alternatives.put(i, options.get(i));
            votes.put(i, 0);
        }
    }
}
