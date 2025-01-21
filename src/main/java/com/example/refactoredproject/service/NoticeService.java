package com.example.refactoredproject.service;

import com.example.refactoredproject.entity.Notice;
import com.example.refactoredproject.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    //공지사항 목록 가져오기
    public List<Notice> getAllNotices(){
        return noticeRepository.findAll();
    }
    
    //공지사항 등록
    public Notice createNotice(String title, String content){
        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setContent(content);
        notice.setCreateDate(LocalDateTime.now());
        return noticeRepository.save(notice);
    }

    //공지사항 조회수 증가
    public void incrementViewCount(Long id){
        Notice notice = noticeRepository.findById(id).orElseThrow();
        notice.setViewCount(notice.getViewCount()+1);
        noticeRepository.save(notice);
    }
    
    //공지사항 삭제
    public void deleteNotice(Long id){
        noticeRepository.deleteById(id);
    }
}
