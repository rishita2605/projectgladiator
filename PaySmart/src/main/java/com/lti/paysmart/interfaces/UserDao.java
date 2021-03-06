package com.lti.paysmart.interfaces;

import java.util.List;

import com.lti.paysmart.dto.ViewAllOrderResopnseDTO;
import com.lti.paysmart.dto.CardDetailsRequestDTO;
import com.lti.paysmart.dto.CardDetailsResponseDTO;
import com.lti.paysmart.dto.InstallmentPaymentRequestDTO;
import com.lti.paysmart.dto.ProductOrderRequestDTO;
import com.lti.paysmart.dto.ProductOrderResponseDTO;
import com.lti.paysmart.dto.UserLoginDTO;
import com.lti.paysmart.dto.UserRegisterDTO;
import com.lti.paysmart.entities.Product;
import com.lti.paysmart.entities.User;

public interface UserDao extends GenericDao {

	/*
	 * All the methods that UserDao should have are declared here.
	 */
	
	public String performLogin(UserLoginDTO userLoginDTO);
	public String performRegister(UserRegisterDTO userRegisterDTO);
	public List<User> viewAllUser();
	public CardDetailsResponseDTO fetchCardUser(CardDetailsRequestDTO cardDetailsRequestDTO);
	public User fetchByUsername(String username);
	public List<ViewAllOrderResopnseDTO> fetchAllOrder(String username);
	public ProductOrderResponseDTO placeOrderFresh(double installment_value, double totalAmtToPay,User user,ProductOrderRequestDTO productOrderRequestDTO, Product product);
	public String payInstallment(InstallmentPaymentRequestDTO installmentPaymentRequestDTO);
}
