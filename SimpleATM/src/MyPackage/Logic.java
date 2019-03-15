package MyPackage;


public class Logic {


		private double balance;
	    double newbalance;
		boolean[] type =new boolean[5];
		double[] amount1=new double[5];
		int index=0;
		String type1;
		int i=0;
		public Logic (double initialBalance)
		{
		 if (initialBalance > 0.0)
			 balance=initialBalance;
		     
		}
		
		public void deposit (double amount)
	    { 
	     balance = balance + amount;
	    	 if (index<4)
	    	 {
	    		 type[index]=true;
	    		 amount1[index]=amount;
	    		 index++;
	    	 }
	    	 else 
	    	 {
	    		 for( i = 1 ; i<=4; i++)
	    		 {
	    			 type[i-1]=type[i];
	    			 amount1[i-1]=amount1[i];
	    		 }	
	    		 type[4]=true;
	    		 amount1[4]=amount;
	    	 }
	    	 
	     for (i =0 ; i<=index-1 ;i++)
	     {
	    	 if (type[i]==true)
	    	 {
	    		 System.out.println("Deposit: " + amount1[i]);
	    	 }
	     }
	    }
	    public void withdraw (double amount)
	    { 
		 
	     if (amount <= balance)
	     {
	    	 balance = balance - amount;
	    	 if (index<4)
	    	 {
	    		 type[index]=false;
	    		 amount1[index]=amount;
	    		 index++;
	    	 }
	    	 else 
	    	 {
	    		 for( i = 1 ; i<=4; i++)
	    		 {
	    			 type[i-1]=type[i];
	    			 amount1[i-1]=amount1[i];
	    		 }	
	    		 type[4]=true;
	    		 amount1[4]=amount;
	    	 }
	    	 
	    	   for (i =0 ; i<=index-1 ;i++)
	          {
	    	 if (type[i]==false)
	    	 {
	    		 System.out.println("withdrawal: " + amount1[i]);
	    	 }
	           }
	    	} 
	    
	    	 
	     }
        
	    public double BalanceInquiry () 
	    {    
	    	  
	    	  return balance;	    
	    	 
	    }
	    public String nextt () 
	    {    
	    	  
	    	  if (index+1 < 5 && index+1 >= 0)	    
	    	  {

	    		    	 if (type[index]==true)
	    		    	 {
	    		    		 type1=" Deposit ";
	    		    	 }
	    		    	 if (type[index]==false )
	    		    	 {
	    		    		 type1=" Withdrawal ";
	    		    	 }
	    	    String transaction = type1 + amount1[index] + "";
	    		index++;
                
				return transaction;
	    	  }
	    	  else 
	    		  return "error";	    	  
	    }
	    public String previous () 
	    {    
	    	 
	    	  if (index-1 < 5 && index-1 >= 0)	    
	    	  {
                         
	    		    	 if (type[index]==true)
	    		    	 {
	    		    		 type1=" Deposit ";
	    		    	 }
	    		    	 if (type[index]==false )
	    		    	 {
	    		    		 type1=" Withdrawal ";
	    		    	 }
	    		    	 String transaction = type1 + amount1[index] + "";
	    		    	 index--; 
                return transaction;
	    	  }
	    	  else 	    	  
	    		  return "error";
	    }
}    