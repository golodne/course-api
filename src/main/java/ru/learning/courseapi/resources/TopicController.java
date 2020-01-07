package ru.learning.courseapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.learning.courseapi.models.Topic;
import ru.learning.courseapi.service.TopicService;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.GET, value = "/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/topics/{id}")
    public ResponseEntity<Topic> show(@PathVariable String id) {
        Optional<Topic> topic = topicService.getTopic(id);
        if (topic.isPresent()) return ResponseEntity.status(HttpStatus.ACCEPTED).body(topic.get());
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
