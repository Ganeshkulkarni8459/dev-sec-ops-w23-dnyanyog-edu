package org.dnyanyog;

import org.dnyanyog.config.DroolsBeanFactory;
import org.dnyanyog.dto.Customer;
import org.kie.api.runtime.KieSession;

public class RuleEngineMain {

	public static void main(String[] args) {

		// Knowledge is everything => kie
		
		KieSession kSession = new DroolsBeanFactory().getKieSession(); // Get build kie container (package)

		if (kSession != null) {
			// Now you can use kSession to insert objects and fire rules
			
			
			Customer customer = new Customer();
			customer.setAge(20);
			customer.setGender("M");
			

			
	//		System.out.println("before rule fire customer discount: " + customer.getDiscount());

			kSession.insert(customer); // 

			// Fire the rules
			kSession.fireAllRules();

			// Close the session
			kSession.dispose();

			// Print the result

			System.out.println("customer discount: " + customer.getDiscount());
			

		} else {
			System.err.println("Failed to create KieSession.");
		}
	}
}
