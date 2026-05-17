package com.myalltool.reagent_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myalltool.reagent_api.model.ReagentUsageLog;

public interface ReagentUsageLogRepository extends JpaRepository<ReagentUsageLog, Long> {

    List<ReagentUsageLog> findAllByOrderByUsedAtDesc();
}