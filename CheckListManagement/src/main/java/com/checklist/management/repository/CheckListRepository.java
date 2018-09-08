package com.checklist.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checklist.management.model.CheckList;

@Repository
public interface CheckListRepository extends JpaRepository<CheckList, Integer> {

}
