package com.example.refactoredproject.controller;


import com.example.refactoredproject.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.refactoredproject.entity.Notice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notices")
public class NoticeController {
    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService){
        this.noticeService=noticeService;
    }
    
    //공지사항 목록
    @GetMapping
    public String listNotices(Model model){
        List<Notice> notices=noticeService.getAllNotices();
        model.addAttribute("notices", notices);
        return "notice/list";
    }
    
    //공지사항 등록 폼
    @GetMapping("/new")
    public String createNoticeForm(){
        return "notice/create";
    }

    //공지사항 등록
    @PostMapping
    public String createNotice(@RequestParam String title, @RequestParam String content){
        noticeService.createNotice(title,content);
        return "redirect:/notices";
    }

    //공지사항 상세 조회
    @GetMapping("/{id}")
    public String viewNotice(@PathVariable Long id, Model model){
        noticeService.incrementViewCount(id); //조회수 증가
        Notice notice = noticeService.getAllNotices().stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElseThrow();

        model.addAttribute("notice",notice);
        return "notice/view";
    }
    //공지사항 수정
    
    //공지사항 삭제
}
