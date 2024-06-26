public class CustomerResponse {

  private String status;
  private String message;
  private long customerCode;

  @Autowired private CustomerData customerData;

  public CustomerData getCustomerData() {
    return customerData;
  }

  public void setCustomerData(CustomerData customerData) {
    this.customerData = customerData;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public long getCustomerCode() {
    return customerCode;
  }

  public void setCustomerCode(long customerCode) {
    this.customerCode = customerCode;
  }
}
