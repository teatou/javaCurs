package com.example.kr1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MachineRepo extends JpaRepository<Machine, Long> {
    @Query("SELECT p FROM Machine p where concat(p.type, '', p.kind, '', p.arrived, '', p.gone, '', p.driver) like %?1%")
    List<Machine> search(String keyword);
}
