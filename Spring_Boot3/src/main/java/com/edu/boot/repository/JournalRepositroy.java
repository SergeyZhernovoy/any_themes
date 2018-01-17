package com.edu.boot.repository;

import com.edu.boot.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepositroy extends JpaRepository<Journal,Long> {
}
