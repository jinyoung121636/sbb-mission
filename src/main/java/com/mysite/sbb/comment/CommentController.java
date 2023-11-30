//package com.mysite.sbb.comment;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/comments")
//public class CommentController {
//    private final CommentService commentService;
//
////    @PostMapping("/add-to-question/{questionId}")
////    public String addCommentToQuestion(
////            @PathVariable Long questionId,
////            @ModelAttribute CommentForm commentForm,
////            Principal principal
////    ) {
////        SiteUser author = userService.getUser(principal.getName());
////        commentService.addCommentToQuestion(questionId, commentForm, author);
////        return "redirect:/questions/detail/" + questionId;
////    }
////
////    @PostMapping("/add-to-answer/{answerId}")
////    public String addCommentToAnswer(
////            @PathVariable Long answerId,
////            @ModelAttribute CommentForm commentForm,
////            Principal principal
////    ) {
////        SiteUser author = userService.getUser(principal.getName());
////        commentService.addCommentToAnswer(answerId, commentForm, author);
////        return "redirect:/answers/detail/" + answerId;
////    }
//}
