package ru.learning.courseapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learning.courseapi.models.Topic;
import ru.learning.courseapi.repository.TopicRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> localTopics = new ArrayList<>();
        topicRepository.findAll().forEach(x -> localTopics.add(x));
        //topicRepository.forEach(localTopics::add)
        return localTopics;
    }

    public Optional<Topic> getTopic(String id) {
        return topicRepository.findById(id);
//        return Optional.ofNullable(topics.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null));
    }

    public void createTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic){
        topicRepository.save(topic);
/*
        for (int i = 0; i<topics.size(); i++) {
            Topic currentTopic = topics.get(i);
            if (currentTopic.getId().equals(id)) {
                topics.set(i,topic);
                return;
            }
        }
        */
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
  //      topics.removeIf(t -> t.getId().equals(id));
    }

}
