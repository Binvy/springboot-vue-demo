package com.binvi.springboot.demo03.guide.ws.consumer;

import com.example.consumingwebservice.wsdl.GetCountryResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/9/2 23:53
 */
@RestController
@RequestMapping("country")
public class CountryController {

	private CountryClient countryClient;

	@Autowired
	public CountryController(CountryClient countryClient) {
		this.countryClient = countryClient;
	}

	@GetMapping("/{name}")
	public GetCountryResponse getCountry(@PathVariable String name) {
		return countryClient.getCountry(name);
	}

}
