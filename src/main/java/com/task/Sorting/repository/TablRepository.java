package com.task.Sorting.repository;

import com.task.Sorting.models.Tabl;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface TablRepository extends JpaRepository<Tabl, Long> {

    @Query ("SELECT val FROM Tabl WHERE sort_id = ?1")
    ArrayList findSort(long num);

    @Query (value = "SELECT sort_id FROM Tabl ORDER BY id DESC LIMIT 1")
    ArrayList findLastSort();
}
