package dinhnguyen.techs.convert.service;

import dinhnguyen.techs.convert.mapper.AddCountryRequest;
import dinhnguyen.techs.convert.mapper.AddCountryResponse;
import dinhnguyen.techs.convert.mapper.GetCountryResponse;

public interface CountryService {

	public GetCountryResponse getCountryByName(String countryName);

	public AddCountryResponse addCountry(AddCountryRequest request);

}
