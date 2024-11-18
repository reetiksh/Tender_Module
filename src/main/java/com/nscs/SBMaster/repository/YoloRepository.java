package com.nscs.SBMaster.repository;

import com.nscs.SBMaster.model.Yolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YoloRepository extends JpaRepository<Yolo, Long> {
    List<Yolo> findByTicketNo(String ticketNo);
    List<Yolo> findByUser(String user);
}
