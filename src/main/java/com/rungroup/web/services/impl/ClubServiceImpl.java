package com.rungroup.web.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rungroup.web.dto.ClubDto;
import com.rungroup.web.models.Club;
import com.rungroup.web.repositories.ClubRepository;
import com.rungroup.web.services.ClubService;
import static com.rungroup.web.mapper.ClubMapper.mapToClub;
import static com.rungroup.web.mapper.ClubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements ClubService {
	private ClubRepository clubRepository;

	public ClubServiceImpl(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}

	@Override
	public List<ClubDto> searchClubs(String query) {
		List<Club> clubs = clubRepository.searchClubs(query);
		return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
	}

	@Override
	public List<ClubDto> findAllClubs() {
		List<Club> clubs = clubRepository.findAll();
		return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
	}

	@Override
	public Club saveClub(ClubDto clubDto) {
		Club club = mapToClub(clubDto);
		return clubRepository.save(club);
	}

	@Override
	public ClubDto findClubById(long clubId) {
		Club club = clubRepository.findById(clubId).get();
		return mapToClubDto(club);
	}

	@Override
	public void updateClub(ClubDto clubDto) {
		Club club = mapToClub(clubDto);
		clubRepository.save(club);
	}

	@Override
	public void deleteClub(long clubId) {
		clubRepository.deleteById(clubId);
	}
}
