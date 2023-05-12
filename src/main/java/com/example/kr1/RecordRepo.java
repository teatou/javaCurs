package com.example.kr1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecordRepo extends JpaRepository<Record, Long> {
    @Query("SELECT p FROM Record p where concat(p.type, '', p.kind, '', p.sum, '', p.client) like %?1%")
    List<Record> search(String keyword);
}
