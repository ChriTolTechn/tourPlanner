package at.technikum.tolanzeilinger.tourplanner.model;

import at.technikum.tolanzeilinger.tourplanner.event.Event;
import at.technikum.tolanzeilinger.tourplanner.event.EventAggregator;

import java.util.ArrayList;
import java.util.List;

public class WordRepository {
    private final List<String> words;
    private final EventAggregator eventAggregator;

    public WordRepository(EventAggregator eventAggregator) {
        this.eventAggregator = eventAggregator;

        words = new ArrayList<>();
    }

    public void add(String word) {
        if(word != null && !words.contains(word))
            words.add(word);

        eventAggregator.publish(Event.CREATE_WORD);
    }

    public void remove(String word) {
        if(word != null)
            words.remove(word);

        eventAggregator.publish(Event.DELETE_WORD);
    }

    public List<String> findAll() {
        return words;
    }
}
