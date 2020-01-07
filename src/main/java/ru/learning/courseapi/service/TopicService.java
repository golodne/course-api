package ru.learning.courseapi.service;

import org.springframework.stereotype.Service;
import ru.learning.courseapi.models.Topic;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = Arrays.asList(
            new Topic("spring","spring framework","spring descriptin"),
            new Topic("java","core java","core java description"),
            new Topic("javascript2","ES 5", "ES 5 description")
    );

    public List<Topic> getAllTopics() { return topics; }
}
