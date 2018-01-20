package com.edu.boot.repository;

import com.edu.boot.domain.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface JournalRepositroy extends JpaRepository<JournalEntry,Long> {
}
