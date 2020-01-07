package ru.learning.courseapi.service;

import org.springframework.stereotype.Service;
import ru.learning.courseapi.models.Topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private List<Topic> topics = Arrays.asList(
            new Topic("spring","spring framework","spring descriptin"),
            new Topic("java","core java","core java description"),
            new Topic("javascript2","ES 5", "ES 5 description")
    );

    public List<Topic> getAllTopics() { return topics; }

    public Optional<Topic> getTopic(String id) {
        return Optional.ofNullable(topics.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null));
    }
}
