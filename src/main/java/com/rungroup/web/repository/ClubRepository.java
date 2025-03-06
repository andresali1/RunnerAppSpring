package com.rungroup.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rungroup.web.models.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {
	Optional<Club> findByTittle(String title);
}
