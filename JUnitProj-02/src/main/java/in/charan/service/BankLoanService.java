package in.charan.service;

public class BankLoanService {
	
	

	public BankLoanService() {

		System.out.println("Zero Arg Constructor of BankLoanService");
	}

	public float calculateSimpleInterest(float pAmt,float rate,float time) {
		System.out.println("Inside the service class\n");
		if(pAmt<=0 || rate<=0 || time<=0) {
			throw new IllegalArgumentException("Invalid Input");
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(pAmt*rate*time)/100.0f;
	}
}
