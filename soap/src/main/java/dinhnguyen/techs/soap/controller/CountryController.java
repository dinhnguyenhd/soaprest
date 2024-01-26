package dinhnguyen.techs.soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import dinhnguyen.techs.soap.service.CountryService;
import techs.dinhnguyen.soap.AddCountryRequest;
import techs.dinhnguyen.soap.AddCountryResponse;
import techs.dinhnguyen.soap.GetCountryRequest;
import techs.dinhnguyen.soap.GetCountryResponse;

@Endpoint
public class CountryController {
	private static final String NAMESPACE_URI = "http://dinhnguyen.techs/soap";

	@Autowired
	private CountryService countryService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response = countryService.getCountry(request);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCountryRequest")
	@ResponsePayload
	public AddCountryResponse addCountry(@RequestPayload AddCountryRequest request) {
		AddCountryResponse response = new AddCountryResponse();
		response = countryService.addCountry(request);
		return response;
	}
}