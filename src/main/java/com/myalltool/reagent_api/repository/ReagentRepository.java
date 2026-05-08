package com.myalltool.reagent_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myalltool.reagent_api.model.Reagent;
@Repository
public interface ReagentRepository extends JpaRepository<Reagent, Long> {

    Reagent findByReagentNameAndLotNo(String reagentName, String lotNo);

}

