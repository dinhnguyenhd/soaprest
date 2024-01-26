package dinhnguyen.techs.convert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dinhnguyen.techs.convert.forms.AddCountryForm;
import dinhnguyen.techs.convert.mapper.AddCountryRequest;
import dinhnguyen.techs.convert.mapper.AddCountryResponse;
import dinhnguyen.techs.convert.mapper.Currency;
import dinhnguyen.techs.convert.mapper.GetCountryResponse;
import dinhnguyen.techs.convert.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/getCountry/{countryName}")
	public ResponseEntity<GetCountryResponse> getCountryByName(@PathVariable("countryName") String countryName) {
		GetCountryResponse response = countryService.getCountryByName(countryName);
		return new ResponseEntity<GetCountryResponse>(response, HttpStatus.OK);

	}

	@PostMapping("/country/addCountry")
	public ResponseEntity<AddCountryResponse> addCountry(@RequestBody AddCountryForm form) {
		AddCountryRequest request = new AddCountryRequest();
		request.setCapital(form.getCapital());
		request.setName(form.getName());
		request.setPopulation(form.getPopulation());
		request.setCurrency(Currency.GBP);
		AddCountryResponse response = this.countryService.addCountry(request);
		return new ResponseEntity<AddCountryResponse>(response, HttpStatus.OK);

	}
}
