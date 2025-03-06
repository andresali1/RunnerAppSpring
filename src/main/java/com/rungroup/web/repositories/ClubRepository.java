package com.rungroup.web.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rungroup.web.models.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {
	Optional<Club> findByTitle(String title);
}
