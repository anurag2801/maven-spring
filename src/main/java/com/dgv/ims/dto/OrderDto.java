package com.dgv.ims.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OrderDto {
	
	
	    private Long id;
	    private Long userId;
	    private Long productId;
	    private Integer quantity;
	    private String customerName;
	    private LocalDate date;
	    private Double totalAmount;


}
