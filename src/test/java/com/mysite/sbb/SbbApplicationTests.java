package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.answer.AnswerService;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private UserService userService;


//    @Test
//    void t1_testJpa(){
//        for (int i = 1; i<=300; i++){
//            String subject = String.format("테스트 데이터입니다:[%03d]", i);
//            String content = "내용무";
//            this.questionService.create(subject, content, null);
//        }
//    }

//    @Test
//    void t2_testJpa(){
//        for (int i = 1; i<=200; i++){
//            String subject = String.format("스프링 데스트입니다:[%03d]", i);
//            String content = "스프링";
//            this.questionService.create(subject, content, null);
//        }
//    }
//    @Test
//    void t3_testJpa(){
//        Question question = questionService.getQuestion(736);
//        for(int i = 1; i<=100; i++){
//            String content = "테스트 댓글 데이터";
//            this.answerService.create(question,content,null);
//        }
//    }

    @Test
    void t4_testJpa(){
        Question question = questionService.getQuestion(737);
        SiteUser siteUser = userService.getUser("user1");
        for(int i = 1; i<=100; i++){
            String content = "테스트 댓글 데이터";
            this.answerService.create(question,content,siteUser);
        }
    }
}
