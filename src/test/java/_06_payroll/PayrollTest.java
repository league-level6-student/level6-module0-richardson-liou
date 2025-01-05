package _06_payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayrollTest {

    Payroll payroll = new Payroll();

    @Test
    void itShouldCalculatePaycheck() {
        //given
    	double wage = 20.0;
    	int hours = 40;
    	double expectedPay = 800.0;
        //when
    	double actualPaycheck = payroll.calculatePaycheck(wage, hours);

        //then
        assertEquals(expectedPay, actualPaycheck);
    }

    @Test
    void itShouldCalculateMileageReimbursement() {
        //given
    	int milesTraveled = 100;
        double expectedReimbursement = 57.5; 
        //when
        double actualReimbursement = payroll.calculateMileageReimbursement(milesTraveled);

        //then
        assertEquals(expectedReimbursement, actualReimbursement);
    }

    @Test
    void itShouldCreateOfferLetter() {
        //given
    	String employeeName = "Richardson Liou";
        double hourlyWage = 25.0;
        String expectedOfferLetter = "Hello Richardson Liou, we are pleased to offer you an hourly pay of 25.0";

        //when
        String actualOfferLetter = payroll.createOfferLetter(employeeName, hourlyWage);

        //then
        assertEquals(expectedOfferLetter, actualOfferLetter);
    }

}