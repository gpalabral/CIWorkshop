package com.mycompany.stringcalculatorci;

public class Calculator {
    
    public int sum(String param) throws Exception{
        
        if(param.equals("")){
            return 0;
        }
        
        String [] sums = param.split(",");
        int sum=0;
        for(int i=0; i< sums.length; i++){
            
            int number = new Integer(sums[i]);
            
            if(number > 1000){
                continue;
            }
            if(number < 0){
                throw new Exception("There is a negative number");
            }
            
            sum = sum + number;
        }

        return sum;
        
        
    }
    
}
