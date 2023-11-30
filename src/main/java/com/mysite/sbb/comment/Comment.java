//package com.mysite.sbb.comment;
//
//import com.mysite.sbb.user.SiteUser;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
//public class Comment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String content;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private SiteUser author;
//}
