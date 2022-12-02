package com.dfrb.springboot.repository;

import com.dfrb.springboot.entity.WikimediaDataTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaDataRepository extends JpaRepository<WikimediaDataTable, Long> {
}
