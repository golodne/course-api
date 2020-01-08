package ru.learning.courseapi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.learning.courseapi.models.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {



}
