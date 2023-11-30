package com.mysite.sbb.answer;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
//답변 생성
    public Answer create(Question question, String content, SiteUser author){
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        this.answerRepository.save(answer);
        return answer;
    }
//답변 가져오기
    public Answer getAnswer(int id){
        Optional<Answer> answer = this.answerRepository.findById(id);
        if(answer.isPresent()){
            return answer.get();
        }else {
            throw new DataNotFoundException("answer not found");
        }
    }
//답변 수정
    public void modify(Answer answer, String content){
        answer.setContent(content);
        answer.setModifyDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }
//답변 삭제
    public void delete(Answer answer){
        this.answerRepository.delete(answer);
    }
//답변 추천
    public void vote(Answer answer, SiteUser siteUser) {
        answer.getVoter().add(siteUser);
        this.answerRepository.save(answer);
    }

//답변 목록 페이징
    public Page<Answer> getList(int id, int page, String sortType){
        List<Sort.Order> sorts = new ArrayList<>();
        if("latest".equals(sortType)){
            //최신순
            sorts.add(Sort.Order.desc("createDate"));
        }
//        else if("popular".equals(sortType)){
//            //추천 많은 순
//            sorts.add(Sort.Order.desc("getVoterSize"));
//        }
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.answerRepository.findAllByQuestionId(id,pageable);
    }
// 답변 키워드 검색하고 정렬
//    public Page<Answer> getList(int page, String kw){
//        List<Sort.Order> sorts = new ArrayList<>();
//        sorts.add(Sort.Order.desc("createDate"));
//        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
//        return this.answerRepository.findAllByKeyword(kw, pageable);
//    }
}
