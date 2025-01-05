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
    	 int octaneGrade = 91;
         boolean expectedRefuelSuccess = true;
        //when

         when(car.fillTank(octaneGrade)).thenReturn(true);
        //then
         boolean actualRefuelSuccess = deliveryDriver.refuel(octaneGrade);
         assertEquals(expectedRefuelSuccess, actualRefuelSuccess);
    }

    @Test
    void itShouldContactCustomer() {
        //given
    	 String phoneNumber = "123-456-7890";
         boolean expectedCallSuccess = true;
        //when
         when(cellPhone.call(phoneNumber)).thenReturn(true);
        //then
         boolean actualCallSuccess = deliveryDriver.contactCustomer(phoneNumber);
         assertEquals(expectedCallSuccess, actualCallSuccess);
    }

}