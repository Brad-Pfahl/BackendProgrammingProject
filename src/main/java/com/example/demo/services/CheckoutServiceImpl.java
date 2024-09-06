package com.example.demo.services;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // Validate that the customer is not set to null
        if (purchase.getCustomer() == null) {
            throw new IllegalArgumentException("ERROR: The customer cannot be null");
        }

        // Validate that the cart is not empty or null
        if (purchase.getCartItems().isEmpty() || purchase.getCartItems() == null) {
            throw new IllegalArgumentException("ERROR: The cart cannot be empty");
        }

        // retrieve the cart info from dto
        Cart cart = purchase.getCart();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        // populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cartItem -> cart.add(cartItem));

        cart.setCartItem(purchase.getCartItems());
        cart.setCustomer(purchase.getCustomer());

        // populate customer with cart
        Customer customer = purchase.getCustomer();
        customer.add(cart);

        // save to the database
        customerRepository.save(customer);


        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number

        return UUID.randomUUID().toString();
    }
}






