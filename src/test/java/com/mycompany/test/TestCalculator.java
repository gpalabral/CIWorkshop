package com.mycompany.test;

import com.mycompany.stringcalculatorci.Calculator;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

@Test
public class TestCalculator {
    
    public void emptyStringReturnZero() throws Exception{
        Calculator calculator = new Calculator();
        
        //Empty string returns zero
        assertEquals(calculator.sum(""),0);
    }
    
    public void twoNumsCommaDelimitedReturnSum() throws Exception{
        Calculator calculator = new Calculator();
        
        assertEquals(calculator.sum("2,3"), 6);
        assertEquals(calculator.sum("0,1"), 1);
        assertEquals(calculator.sum("2,0"), 2);
    }
    
    public void threeNumsCommaDelimitedReturnSum() throws Exception{
        Calculator calculator = new Calculator();
        
        assertEquals(calculator.sum("2,3,5"), 10);
    }
    
    public void numbersGreaterThan100AreIgnored() throws Exception{
        Calculator calculator = new Calculator();
                
        assertEquals(calculator.sum("1500,50"),50);
    }
    
    
    public void negativeNumberThrowException() throws Exception{
        
        Calculator calculator = new Calculator();
        try {
            assertEquals(calculator.sum("1500,-50"),50);
            
        } catch (Exception ex) {
            Logger.getLogger(TestCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
