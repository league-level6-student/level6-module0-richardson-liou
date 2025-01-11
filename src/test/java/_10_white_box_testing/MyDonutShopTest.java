package _10_white_box_testing;

import _09_intro_to_white_box_testing.models.DeliveryService;
import _09_intro_to_white_box_testing.models.Order;
import _10_white_box_testing.models.BakeryService;
import _10_white_box_testing.models.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import _08_mocking.models.DeliveryDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.awt.List;
import java.util.Collections;

class MyDonutShopTest {

    MyDonutShop myDonutShop;
    @Mock
    PaymentService payService;
    @Mock
    DeliveryService deliveryService;
    @Mock
    BakeryService bakeryService;
    
    @BeforeEach
    void setUp() {
    	MockitoAnnotations.openMocks(this);
    	
    	myDonutShop = new MyDonutShop(payService,deliveryService, bakeryService);
    	myDonutShop.openForTheDay();
    }

    @Test
    void itShouldTakeDeliveryOrder() throws Exception {
        //given
    	Order order = new Order("CUSTOMER_NAME",
                "CUSTOMER_PHONE_NUMBER",
                1,
                5.00,
                "CREDIT_CARD_NUMBER",
                true);
        when(payService.charge(order)).thenReturn(true);
        when(bakeryService.getDonutsRemaining()).thenReturn(50);
        //when
        myDonutShop.takeOrder(order);
        
        //then
        verify(payService, times(1)).charge(order);

    }

    @Test
    void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() {
        //given
    	Order order = new Order("CUSTOMER_NAME",
                "CUSTOMER_PHONE_NUMBER",
                1,
                5.00,
                "CREDIT_CARD_NUMBER",
                true);
    	
    	when(payService.charge(order)).thenReturn(true);
        when(bakeryService.getDonutsRemaining()).thenReturn(0);
        //when
    	Throwable ex = assertThrows(IllegalArgumentException.class, () -> myDonutShop.takeOrder(order));
    	assertEquals(ex.getMessage(), "Insufficient donuts remaining");
        //then
    	
    }

    @Test
    void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException(){
        //given
    	Order order = new Order("CUSTOMER_NAME",
                "CUSTOMER_PHONE_NUMBER",
                1,
                5.00,
                "CREDIT_CARD_NUMBER",
                true);
 
    	myDonutShop.closeForTheDay();
        //when
    	Throwable ex = assertThrows(Exception.class, () -> myDonutShop.takeOrder(order));
    	assertEquals(ex.getMessage(), "Sorry we're currently closed");
        //then
    	
    }

}