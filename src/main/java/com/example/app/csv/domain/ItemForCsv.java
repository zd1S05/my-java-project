package com.example.app.csv.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ItemForCsv {
	
	private Integer id;
    private Integer category;
    private String title;
    private String description;
    private Integer startingPrice;
    private Integer eventDuration;
    private Integer endTime;
    private String itemCondition;
    private LocalDateTime registerdDate;
    private LocalDateTime updatedDate;
    private LocalDate listingDate;
    private String createdBy;

    // 他のテーブルのID
    private Integer paymentId;
    private Integer shippingMethod1Id;
    private Integer shippingMethod2Id;
    private Integer shippingMethod3Id;
    private Integer itemPolicyId;
    private Integer subItemId;
    private Integer imageComment;

    // 他のテーブルとの関連を保持
    private Payment payment;
    private ShippingMethod1 shippingMethod1;
    private ShippingMethod2 shippingMethod2;
    private ShippingMethod3 shippingMethod3;
    private ItemPolicy itemPolicy;
    private SubItem subItem;

}
