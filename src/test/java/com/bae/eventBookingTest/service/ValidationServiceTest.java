package com.bae.eventBookingTest.service;

import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import javax.validation.ValidationException;

import org.junit.Test;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.domain.Event;
import com.bae.service.ValidationService;

public class ValidationServiceTest {

	private Customer customerDetails = new Customer();
	private Event eventDetails = new Event();

	private ValidationService validation = new ValidationService();

	@Test
	public void firstNameBlankTest() {
		boolean thrown = false;
		this.customerDetails.setFirstName("");
		try {
			this.validation.customerFirstNameValidation(this.customerDetails);
			} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void firstNameTooLongTest() {
		boolean thrown = false;
		this.customerDetails.setFirstName("neevanneevanneevanneevanneevanneevanneevanneevanneevanneevann");
		try {
			this.validation.customerFirstNameValidation(this.customerDetails);
			} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void firstNameCorrectTest() {
		boolean thrown = true;
		this.customerDetails.setFirstName("Neevan");
		try {
			this.validation.customerFirstNameValidation(this.customerDetails);
			} catch (ValidationException e) {
			thrown = false;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void lastNameBlankTest() {
		boolean thrown = false;
		this.customerDetails.setLastName("");
		try {
			this.validation.customerLastNameValidation(this.customerDetails);
			} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void lastNameTooLongTest() {
		boolean thrown = false;
		this.customerDetails.setLastName("tigstigstigstigstigstigstigstigstigstigstigstigstigstigstigstigstigstigstigstigst");
		try {
			this.validation.customerLastNameValidation(this.customerDetails);
			} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void lastNameCorrectTest() {
		boolean thrown = true;
		this.customerDetails.setLastName("Tigs");
		try {
			this.validation.customerLastNameValidation(this.customerDetails);
			} catch (ValidationException e) {
			thrown = false;
		}
		assertTrue(thrown);
	}

	@Test
	public void phoneBlankTest() {
		boolean thrown = false;
		this.customerDetails.setCustomerNumber("");
		try {
			this.validation.customerPhoneValidation(this.customerDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	// Test it fails if it is too short
	@Test
	public void incorrectPhoneTest() {
		boolean thrown = false;
		this.customerDetails.setCustomerNumber("+44 738");
		try {
			this.validation.customerPhoneValidation(this.customerDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	// Test it fails if it doesn't start with +44
	@Test
	public void incorrectPhoneTest2() {
		boolean thrown = false;
		this.customerDetails.setCustomerNumber("07382938475");
		try {
			this.validation.customerPhoneValidation(this.customerDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	// Test it fails if letters are added
	@Test
	public void incorrectPhoneTest3() {
		boolean thrown = false;
		this.customerDetails.setCustomerNumber("+44728ggg2637");
		try {
			this.validation.customerPhoneValidation(this.customerDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	// Test UK Mobile Number
	@Test
	public void ukMobileTest() {
		boolean thrown = true;
		this.customerDetails.setCustomerNumber("+44 7182938495");
		try {
			this.validation.customerPhoneValidation(this.customerDetails);
		} catch (ValidationException e) {
			thrown = false;
		}
		assertTrue(thrown);
	}

	// Test UK Landline
	@Test
	public void ukLandlineTest() {
		boolean thrown = true;
		this.customerDetails.setCustomerNumber("+441494839283");
		try {
			this.validation.customerPhoneValidation(this.customerDetails);
		} catch (ValidationException e) {
			thrown = false;
		}
		assertTrue(thrown);
	}

	// Test American Mobile
	@Test
	public void americanMobileTest() {
		boolean thrown = true;
		this.customerDetails.setCustomerNumber("+1 (480) 848-1398");
		try {
			this.validation.customerPhoneValidation(this.customerDetails);
		} catch (ValidationException e) {
			thrown = false;
		}
		assertTrue(thrown);
	}

	// Test French Mobile
	@Test
	public void frenchMobileTest() {
		boolean thrown = true;
		this.customerDetails.setCustomerNumber("+33 6 17 40 56 84");
		try {
			this.validation.customerPhoneValidation(this.customerDetails);
		} catch (ValidationException e) {
			thrown = false;
		}
		assertTrue(thrown);
	}

	@Test
	public void emailBlankTest() {
		boolean thrown = false;
		this.customerDetails.setEmail("");
		try {
			this.validation.customerEmailValidation(this.customerDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	// Doesn't have an '@'
	@Test
	public void incorrectEmailTest() {
		boolean thrown = false;
		this.customerDetails.setEmail("tigs.msn.com");
		try {
			this.validation.customerEmailValidation(this.customerDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	// Doesn't have a '.'
	@Test
	public void incorrectEmailTest2() {
		boolean thrown = false;
		this.customerDetails.setEmail("tigs@msncom");
		try {
			this.validation.customerEmailValidation(this.customerDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test
	public void correctEmailTest() {
		boolean thrown = true;
		this.customerDetails.setEmail("tigs@msn.com");
		try {
			this.validation.customerEmailValidation(this.customerDetails);
		} catch (ValidationException e) {
			thrown = false;
		}
		assertTrue(thrown);
	}

	@Test
	public void dateBeforePresentFailTest() {
		boolean thrown = false;
		this.eventDetails.setEventDate(LocalDate.now().minusDays(1));
		try {
			this.validation.eventDateValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test
	public void dateAfter5YearsInFutureFailTest() {
		boolean thrown = false;
		this.eventDetails.setEventDate(LocalDate.now().plusYears(5).plusDays(1));
		try {
			this.validation.eventDateValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test
	public void datePassTest() {
		boolean thrown = true;
		this.eventDetails.setEventDate(LocalDate.now().plusYears(1));
		try {
			this.validation.eventDateValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = false;
		}
		assertTrue(thrown);
	}

	@Test
	public void capacityTooSmallTest() {
		boolean thrown = false;
		this.eventDetails.setEventCapacity(0);
		try {
			this.validation.eventCapacityValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test
	public void capacityNegativeTest() {
		boolean thrown = false;
		this.eventDetails.setEventCapacity(-10);
		try {
			this.validation.eventCapacityValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test
	public void capacityTooBigTest() {
		boolean thrown = false;
		this.eventDetails.setEventCapacity(5001);
		try {
			this.validation.eventCapacityValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test
	public void capacityCorrectTest() {
		boolean thrown = true;
		this.eventDetails.setEventCapacity(250);
		try {
			this.validation.eventCapacityValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = false;
		}
		assertTrue(thrown);
	}

	// Test it fails if it starts with a number
	@Test
	public void postcodeBlank() {
		boolean thrown = false;
		this.eventDetails.setEventPostcode("");
		try {
			this.validation.eventPostcodeValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	// Test it fails if it starts with a number
	@Test
	public void incorrectPostcodeTest() {
		boolean thrown = false;
		this.eventDetails.setEventPostcode("2L38 9QW");
		try {
			this.validation.eventPostcodeValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	// Test it fails if it has a space
	@Test
	public void incorrectPostcodeTest2() {
		boolean thrown = false;
		this.eventDetails.setEventPostcode("HL389QW");
		try {
			this.validation.eventPostcodeValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	// Test it fails if it has more than 2 letters first
	@Test
	public void incorrectPostcodeTest3() {
		boolean thrown = false;
		this.eventDetails.setEventPostcode("HLH8 9QW");
		try {
			this.validation.eventPostcodeValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	// Test it fails if it has a letter after the space
	@Test
	public void incorrectPostcodeTest4() {
		boolean thrown = false;
		this.eventDetails.setEventPostcode("HL29 DQW");
		try {
			this.validation.eventPostcodeValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	// Test it fails if the last two characters are number
	@Test
	public void incorrectPostcodeTest5() {
		boolean thrown = false;
		this.eventDetails.setEventPostcode("HL29 928");
		try {
			this.validation.eventPostcodeValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	// Test it fails if postcode is too short
	@Test
	public void incorrectPostcodeTest6() {
		boolean thrown = false;
		this.eventDetails.setEventPostcode("9NQ");
		try {
			this.validation.eventPostcodeValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	// Test correct postcode passes
	@Test
	public void correctPostcodeTest() {
		boolean thrown = true;
		this.eventDetails.setEventPostcode("HP10 2HQ");
		try {
			this.validation.eventPostcodeValidation(this.eventDetails);
		} catch (ValidationException e) {
			thrown = false;
		}
		assertTrue(thrown);
	}
}
