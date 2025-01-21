package com.example.refactoredproject.repository;
import com.example.refactoredproject.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice,Long> {
    //JpaRepository는 기본적인 CRUD 메서드를 제공


}
