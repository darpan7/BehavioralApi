package com.javasampleapproach.jpamysqlangular4.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.jpamysqlangular4.model.Question;
import com.javasampleapproach.jpamysqlangular4.model.QuestionType;

public interface QuestionRepository extends CrudRepository<Question, Long>{
	List<Question> findByQType(QuestionType qType);
}
