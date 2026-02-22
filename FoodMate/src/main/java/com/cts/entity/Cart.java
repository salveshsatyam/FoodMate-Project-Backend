package com.cts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int cartId;
	
	 private int userId;
	 private int quantity;
	 private boolean inorder;
	 
	 @ManyToOne
	private Product product;
	 
	 public void setCartId(int cartId) {
			this.cartId = cartId;
		}
		
		public int getCartId() {
			return cartId;
		}
		
		public void setUserId(int userId) {
			this.userId = userId;
		}
		
		public int getUserId() {
			return userId;
		}
		
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		public int getQuantity() {
			return quantity;
		}
		
		public void setInorder(boolean inorder) {
			this.inorder = inorder;
		}
		
		public boolean getInorder() {
			return inorder;
		}
		public void setproduct(Product product) {
			this.product = product;
		}
		
		public Product getProduct() {
			return product;
		}

}
