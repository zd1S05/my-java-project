package com.example.app.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Item {

	private Integer id;

	@NotNull
	private Integer category;

	@NotBlank
	@Size(max = 65)
	private String title;

	@NotBlank
	@Size(max = 500)
	private String description;

	@NotNull
	private Integer startingPrice;

	@NotNull
	private Integer eventDuration;
	@NotNull
	private Integer endTime;

	private String itemCondition;
	
	private LocalDateTime registerdDate;
	private LocalDateTime updatedDate;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate listingDate;

	private String createdBy;

	private Integer paymentId;
	private Integer shippingMethod1Id;
	private Integer shippingMethod2Id;
	private Integer shippingMethod3Id;
	private Integer itemPolicyId;
	private Integer subItemId;
	private Integer imageComment;

}
