package _08_mocking.models;

import _07_intro_to_mocking.models.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeliveryDriverTest {

    DeliveryDriver deliveryDriver;
    String name;
    @Mock
    Car car;
    @Mock
    CellPhone cellPhone;
    
    @BeforeEach
    void setUp() {
    	MockitoAnnotations.openMocks(this);
    	deliveryDriver = new DeliveryDriver(name, car, cellPhone);
    }

    @Test
    void itShouldWasteTime() {
        //given
    	boolean expectedTimeWaste = true;
        

        //when
    	when(deliveryDriver.wasteTime()).thenReturn(true);
        
        //then
    	boolean actualTimeWaste = deliveryDriver.wasteTime();
    	assertEquals(expectedTimeWaste, actualTimeWaste);
    }

    @Test
    void itShouldRefuel() {
        //given

        //when

        //then
    }

    @Test
    void itShouldContactCustomer() {
        //given

        //when

        //then
    }

}