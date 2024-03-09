package org.customer.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.customer.dto.CustomerData;
import org.customer.dto.CustomerRequest;
import org.customer.dto.CustomerResponse;
import org.customer.dto.DiscountRequest;
import org.customer.dto.DiscountResponse;
import org.customer.entity.Customer;
import org.customer.repo.CustomerRepository;
import org.dnyanyog.enums.CustomerResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	CustomerResponse customerResponse;


	@Override
	public CustomerResponse addCustomerDetails(CustomerRequest customerRequest) {

		if (customerRepo.existsByEmail_id(customerRequest.getEmailID())) {
			customerResponse.setStatus(CustomerResponseCode.FAILED_CUSTOMER_ADD_EXISTS.getStatus());
			customerResponse.setMessage(CustomerResponseCode.FAILED_CUSTOMER_ADD_EXISTS.getMessage());
			customerResponse.setCustomerCode(0000);
		} else {

			Customer customerTable = Customer.getInstance().setFirst_name(customerRequest.getFirstName())
					.setMiddle_name(customerRequest.getMiddleName()).setLast_name(customerRequest.getLastName())
					.setDate_of_birth(customerRequest.getDateOfBirth())
					.setAddress_line1(customerRequest.getAddressLine1())
					.setAddress_line2(customerRequest.getAddressLine2()).setZip(customerRequest.getZip())
					.setCity(customerRequest.getCity()).setState(customerRequest.getState())
					.setCountry(customerRequest.getCountry()).setMobile_phone(customerRequest.getMobilePhone())
					.setHome_phone(customerRequest.getHomePhone()).setWork_phone(customerRequest.getWorkPhone())
					.setEmail_id(customerRequest.getEmailID()).setCustomer_id(customerRequest.getCustomerId())
					.setCreated_date(LocalDateTime.now()).setUpdated_date(LocalDateTime.now());

			try {
				customerTable = customerRepo.save(customerTable);
			} catch (Exception e) {
				e.printStackTrace();
			}

			customerResponse.setStatus(CustomerResponseCode.SUCCESS_CUSTOMER_ADD.getStatus());
			customerResponse.setMessage(CustomerResponseCode.SUCCESS_CUSTOMER_ADD.getMessage());
			customerResponse.setCustomerCode(customerTable.getCustomer_code());

		}
		return customerResponse;
	}

	public CustomerResponse updateCustomerDetails(String mobilePhone, CustomerRequest customerRequest) {

		List<Customer> customerTable = customerRepo.findByMobilePhone(mobilePhone);
		if (customerTable.isEmpty()) {
			customerResponse.setStatus(CustomerResponseCode.FAILED_UPDATE_CUSTOMER.getStatus());
			customerResponse.setMessage(CustomerResponseCode.FAILED_UPDATE_CUSTOMER.getMessage());
			customerResponse.setCustomerCode(0000);
		} else {
			Customer receivedData = customerTable.get(0);
			
			receivedData.setFirst_name(customerRequest.getFirstName());
			receivedData.setMiddle_name(customerRequest.getMiddleName());
			receivedData.setLast_name(customerRequest.getLastName());
			receivedData.setDate_of_birth(customerRequest.getDateOfBirth());
			receivedData.setAddress_line1(customerRequest.getAddressLine1());
			receivedData.setAddress_line2(customerRequest.getAddressLine2());
			receivedData.setZip(customerRequest.getZip());
			receivedData.setCity(customerRequest.getCity());
			receivedData.setState(customerRequest.getState());
			receivedData.setCountry(customerRequest.getCountry());
			receivedData.setMobile_phone(customerRequest.getMobilePhone());
			receivedData.setHome_phone(customerRequest.getHomePhone());
			receivedData.setWork_phone(customerRequest.getWorkPhone());
			receivedData.setEmail_id(customerRequest.getEmailID());
			receivedData.setCustomer_id(customerRequest.getCustomerId());
			receivedData.setCreated_date(LocalDateTime.now());
			receivedData.setUpdated_date(LocalDateTime.now());
			
			receivedData = customerRepo.save(receivedData);
			
			customerResponse.setStatus("Success");
			customerResponse.setMessage("Data Updated Successfuly");
			
			
		}

		return customerResponse;

	}

	public CustomerResponse findByMobileNumber(String mobilePhone) {
	    CustomerResponse customerResponse = new CustomerResponse(); // Initialize customerResponse

	    List<Customer> customerTable = customerRepo.findByMobilePhone(mobilePhone);

	    if (customerTable.isEmpty()) {
	        customerResponse.setStatus(CustomerResponseCode.FAILED_GET_CUSTOMER.getStatus());
	        customerResponse.setMessage(CustomerResponseCode.FAILED_GET_CUSTOMER.getMessage());
	        customerResponse.setCustomerCode(0000); // Assuming customerCode is a long, it should be set as 0L for clarity.
	    } else {
	        Customer receivedData = customerTable.get(0);

	        customerResponse.setCustomerCode(receivedData.getCustomer_code());
	        CustomerData customerData = new CustomerData();
	        customerData.setFirstName(receivedData.getFirst_name());
	        customerData.setMiddleName(receivedData.getMiddle_name());
	        customerData.setLastName(receivedData.getLast_name());
	        customerData.setDateOfBirth(receivedData.getDate_of_birth());
	        customerData.setAddressLine1(receivedData.getAddress_line1());
	        customerData.setAddressLine2(receivedData.getAddress_line2());
	        customerData.setZip(receivedData.getZip());
	        customerData.setCity(receivedData.getCity());
	        customerData.setState(receivedData.getState());
	        customerData.setCountry(receivedData.getCountry());
	        customerData.setMobilePhone(receivedData.getMobile_phone());
	        customerData.setHomePhone(receivedData.getHome_phone());
	        customerData.setWorkPhone(receivedData.getWork_phone());
	        customerData.setEmailID(receivedData.getEmail_id());
	        customerResponse.setCustomerData(customerData);
	        
	        customerResponse.setMessage("Customer details found");
	        customerResponse.setStatus("Success");
	    }

	    return customerResponse;
	}

	public DiscountResponse getDiscount(DiscountRequest request) {

		DiscountResponse response = new DiscountResponse();

		String age = request.getAge();
		String gender = request.getGender();

		int discountPercent = calculateDiscount(age, gender);

		response.setDiscountPercent(String.valueOf(discountPercent));

		return response;
	}

	private int calculateDiscount(String age, String gender) {
		int discountPercent = 0;

		if (!age.isEmpty()) {
			int ageValue = Integer.parseInt(age);
			if (gender != null && gender.equals("M")) {
				if (ageValue < 30) {
					discountPercent = 10;
				} else if (ageValue >= 30 && ageValue < 60) {
					discountPercent = 5;
				} else if (ageValue >= 60) {
					discountPercent = 15;
				}
			} else if (gender != null && gender.equals("F")) {
				if (ageValue < 30) {
					discountPercent = 10 + 5;
				} else if (ageValue >= 30 && ageValue < 60) {
					discountPercent = 5 + 5;
				} else if (ageValue >= 60) {
					discountPercent = 15 + 5;
				}
			}
		}
		return discountPercent;

	}

}
