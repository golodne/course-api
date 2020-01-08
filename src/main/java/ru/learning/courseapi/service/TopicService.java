package ru.learning.courseapi.service;

import org.springframework.stereotype.Service;
import ru.learning.courseapi.models.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>();
    {
        topics.add(new Topic("spring","spring framework","spring descriptin"));
        topics.add(new Topic("java","core java","core java description"));
        topics.add(new Topic("javascript2","ES 5", "ES 5 description"));
    }

    public List<Topic> getAllTopics() { return topics; }

    public Optional<Topic> getTopic(String id) {
        return Optional.ofNullable(topics.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null));
    }

    public void createTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic){
        for (int i = 0; i<topics.size(); i++) {
            Topic currentTopic = topics.get(i);
            if (currentTopic.getId().equals(id)) {
                topics.set(i,topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }

}
