package com.poly.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dao.AccountDao;
import com.poly.dao.OrderItemDao;
import com.poly.dao.OrdersDao;
import com.poly.entity.Account;
import com.poly.entity.Item;
import com.poly.entity.Order;
import com.poly.entity.OrderItem;
import com.poly.service.ItemService;
import com.poly.service.OrderService;
import com.poly.service.SessionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ItemRestController {
	@Autowired
	ItemService itemService;

	@Autowired
	OrdersDao orderDao;

	@Autowired
	OrderItemDao orderItemDao;

	@Autowired
	SessionService session;

	@Autowired
	AccountDao dao;

	@Autowired
	OrderService orderService;

	@GetMapping("{itemId}")
	public Item getOne(@PathVariable("itemId") Integer itemId) {
		return itemService.findById(itemId);
	}

	@GetMapping("/cart-items/{accountId}")
	public List<OrderItem> getCartItems(@PathVariable("accountId") Integer accountId) {
		// Lấy danh sách sản phẩm trong giỏ hàng dựa trên accountId
		List<OrderItem> cartItems = orderItemDao.findByOrder_Account_AccountId(accountId);
		return cartItems;
	}

	@PostMapping("/add-to-cart/{itemId}/{accountId}/{quantity}")
	public ResponseEntity<String> addToCart(@PathVariable("itemId") Integer itemId,
			@PathVariable("accountId") Integer accountId,
			@PathVariable("quantity") int quantity) {
		Item item = itemService.findById(itemId);
		Account account = dao.findById(accountId).get();

		if (item == null || account == null) {
			return ResponseEntity.badRequest().body("Item or account not found!");
		}

		// Tạo đơn hàng mới hoặc lấy đơn hàng chưa hoàn tất của người dùng
		Order order = orderDao.findUncompletedOrder(account);
		if (order == null) {
			order = new Order();
			order.setOrderDate(new Date());
			order.setTotalPrice(0);
			order.setAccount(account);
			// Thiết lập các thông tin khác cho đơn hàng (ngày đặt hàng, tổng tiền,...)

			order = orderDao.save(order);
		}

		// Thêm sản phẩm vào đơn hàng
		OrderItem orderItem = new OrderItem();
		orderItem.setOrder(order);
		orderItem.setItem(item);
		orderItem.setQuantity(quantity); // Số lượng sản phẩm được chuyển từ Angular
		// Thiết lập các thông tin khác cho chi tiết đơn hàng

		orderItemDao.save(orderItem);
		return ResponseEntity.ok("{\"message\": \"Item added to cart!\"}");
	}

	// @DeleteMapping("/remove-from-cart/{itemId}/{accountId}")
	// public ResponseEntity<String> removeFromCart(
	// @PathVariable Integer itemId,
	// @PathVariable Integer accountId) {
	// // Kiểm tra và xử lý xóa sản phẩm khỏi giỏ hàng
	// try {
	// orderService.removeCartItem(accountId, itemId);
	// return ResponseEntity.ok("Product removed from cart successfully.");
	// } catch (Exception e) {
	// return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	// .body("Error while removing product from cart: " + e.getMessage());
	// }
	// }
}
