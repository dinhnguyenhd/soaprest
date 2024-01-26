package dinhnguyen.techs.soap.service;

import techs.dinhnguyen.soap.AddCountryRequest;
import techs.dinhnguyen.soap.AddCountryResponse;
import techs.dinhnguyen.soap.GetCountryRequest;
import techs.dinhnguyen.soap.GetCountryResponse;

public interface CountryService {

	public GetCountryResponse getCountry(GetCountryRequest request);

	public AddCountryResponse addCountry(AddCountryRequest request);

}
