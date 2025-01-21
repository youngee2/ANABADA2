package com.example.refactoredproject.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

// 공지사항 엔티티
@Entity
@Table(name="notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment
    private Long id; //게시글 고유 번호

    @Column(nullable = false, length=100) //NOT NULL, 최대 길이 100
    private String title; //공지사항 제목
    
    @Column(columnDefinition = "TEXT") //긴 텍스트 저장
    private String content;

    @Column(name = "create_date", nullable=false, updatable = false)
    private LocalDateTime createDate; // 작성일

    @Column(name="view_content", nullable = false)
    private int viewCount; //조회수

    //기본 생성자(JPA에서 필수)
    public Notice(){}

    //Getter와 Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
