package com.cts.dto;

import com.cts.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CartDto {
	private int userId;
	private int quantity;
	private boolean inorder;
	private Product product;

}
