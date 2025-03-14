package com.rungroup.web.mapper;

import java.util.stream.Collectors;

import com.rungroup.web.dto.ClubDto;
import com.rungroup.web.models.Club;
import static com.rungroup.web.mapper.EventMapper.mapToEventDto;

public class ClubMapper {
    public static ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map((event) -> mapToEventDto(event))
                        .collect(Collectors.toList()))
                .build();

        return clubDto;
    }

    public static Club mapToClub(ClubDto clubDto) {
        Club club = Club.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .photoUrl(clubDto.getPhotoUrl())
                .content(clubDto.getContent())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())
                .build();

        return club;
    }
}
