package com.rungroup.web.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClubDto {
	private Long id;

	@NotEmpty(message = "Club title should not be empty")
	private String title;

	@NotEmpty(message = "Club Photo link should not be empty")
	private String photoUrl;

	@NotEmpty(message = "Club content should not be empty")
	private String content;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
}
