package app.dao;

import app.dtos.OrderDto;


public interface OrderDao {
    public long createOrder(OrderDto orderDto) throws Exception;
    
}
