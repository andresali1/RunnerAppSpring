package com.rungroup.web.services;

import java.util.List;

import com.rungroup.web.dto.ClubDto;

public interface ClubService {
	List<ClubDto> findAllClubs();
}
