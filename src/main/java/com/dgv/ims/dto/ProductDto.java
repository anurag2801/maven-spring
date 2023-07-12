package com.dgv.ims.dto;



import lombok.Data;

@Data
public class ProductDto {
	
	
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private Integer price;
    private Long categoryId;

}
