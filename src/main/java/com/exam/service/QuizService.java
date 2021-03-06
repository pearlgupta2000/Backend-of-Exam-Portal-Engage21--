package com.exam.service;

import com.exam.model.Quiz;
import com.exam.model.Subject;
import com.exam.repo.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    public void deleteQuiz(Long quizId) {
        this.quizRepository.deleteById(quizId);
    }

    public List<Quiz> getQuizzesOfSubject(Subject category) {
        return this.quizRepository.findBySubject(category);
    }

    //get active quizzes
    public List<Quiz> getActiveQuizzes() {
        return this.quizRepository.findByActive(true);
    }

    public List<Quiz> getActiveQuizzesOfSubject(Subject sub) {
        return this.quizRepository.findBySubjectAndActive(sub, true);
    }

}
