package com.example.demo.repository;

import com.example.demo.data.ClubWriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubWriterRepository extends JpaRepository<ClubWriter, String> {
}
