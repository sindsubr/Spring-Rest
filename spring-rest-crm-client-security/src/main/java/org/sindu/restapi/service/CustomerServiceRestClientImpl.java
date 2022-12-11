package org.sindu.restapi.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;
import org.sindu.restapi.entity.CustomUserDetails;
import org.sindu.restapi.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceRestClientImpl implements CustomerService {

	private RestTemplate restTemplate;
	private String crmRestUrl;
	private CustomUserDetails customUserDetails;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	

	public void setCustomUserDetails(CustomUserDetails customUserDetails) {
		this.customUserDetails = customUserDetails;
	}

	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}


	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


	@Autowired
	public CustomerServiceRestClientImpl(RestTemplate restTemplate, @Value("${crm.rest.url}") String crmRestUrl,CustomUserDetails customUserDetails) {
		super();
		this.restTemplate = restTemplate;
		this.crmRestUrl = crmRestUrl;
		this.customUserDetails = customUserDetails;
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
		
	}
	
	@Override
	public List<Customer> getCustomers() {
		logger.info("in getCustomers(): Calling REST API " + crmRestUrl);
		// make REST call
		this.restTemplate.getInterceptors().add(
				new BasicAuthorizationInterceptor(customUserDetails.getUsername(), customUserDetails.getPassword()));
		
		HttpEntity<List<Customer>> httpEntity = new HttpEntity<List<Customer>>(
				createHeaders(customUserDetails.getUsername(), customUserDetails.getPassword()));
		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<List<Customer>>() {
				});
		// get the list of customers from response
		List<Customer> customers = responseEntity.getBody();
		return customers;
	}

	@Override
	public Customer getCustomer(int customerId) {
		logger.info("in getCustomer(): Calling REST API " + crmRestUrl);
		// make REST call
		Customer theCustomer = 
				restTemplate.getForObject(crmRestUrl + "/" + customerId, Customer.class);
		logger.info("in saveCustomer(): theCustomer=" + theCustomer);
		return theCustomer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		logger.info("in saveCustomer(): Calling REST API " + crmRestUrl);
			restTemplate.postForEntity(crmRestUrl, customer, String.class);
		logger.info("in saveCustomer(): success");
	}
	
	
	
	@Override
	public void deleteCustomer(int customerId) {
		logger.info("in deleteCustomer(): Calling REST API " + crmRestUrl);
		// make REST call
		restTemplate.delete(crmRestUrl + "/" + customerId);
		logger.info("in deleteCustomer(): deleted customer theId=" + customerId);
	}

	@Override
	public void updateCustomer(Customer customer) {
		logger.info("in updateCustomer(): Calling REST API " + crmRestUrl);
		restTemplate.put(crmRestUrl, customer);	
		logger.info("in updateCustomer(): success");		
	}
	HttpHeaders createHeaders(final String username, final String password){
		   return new HttpHeaders() {{
		         String auth = username + ":" + password;
		         byte[] encodedAuth = Base64.encodeBase64( 
		            auth.getBytes(Charset.forName("US-ASCII")) );
		         String authHeader = "Basic " + new String( encodedAuth );
		         set( "Authorization", authHeader );
		      }};
		}
	
}
