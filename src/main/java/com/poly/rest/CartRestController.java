package com.poly.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dao.AccountDao;
import com.poly.dao.OrderItemDao;
import com.poly.dao.OrdersDao;
import com.poly.entity.Account;
import com.poly.entity.Order;
import com.poly.entity.OrderItem;
import com.poly.service.ItemService;
import com.poly.service.SessionService;

import ch.qos.logback.core.model.Model;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class CartRestController {

    @Autowired
    OrdersDao orderDao;

    @Autowired
    SessionService session;

    @Autowired
    AccountDao dao;

    @PostMapping("save")
    public Order saveOrder(@RequestBody Order order) {
        // Lưu thông tin đơn hàng vào bảng "Orders"
        order = new Order();
        order.setOrderDate(new Date());// Ngày đặt hàng
        order.setTotalPrice(0); // Giá tổng cộng (tạm thời lấy giá 0)
        // Lấy thông tin người dùng đã đăng nhập từ session
        Integer accountId = (Integer) session.get("accId");
        if (accountId != null) {
            // Truy xuất thông tin tài khoản từ cơ sở dữ liệu bằng accountId
            Account account = dao.findById(accountId).orElse(null);
            if (account != null) {
                // Thêm thông tin tài khoản vào đơn hàng
                order.setAccount(account);
            }
        } else {
            // Xử lý trường hợp người dùng chưa đăng nhập hoặc session đã hết hạn.

        }
        orderDao.save(order);
        return order;
    }
}