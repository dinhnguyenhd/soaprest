package dinhnguyen.techs.soap.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dinhnguyen.techs.soap.entity.Country;
import dinhnguyen.techs.soap.repository.CountryRepository;
import techs.dinhnguyen.soap.AddCountryRequest;
import techs.dinhnguyen.soap.AddCountryResponse;
import techs.dinhnguyen.soap.GetCountryRequest;
import techs.dinhnguyen.soap.GetCountryResponse;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public GetCountryResponse getCountry(GetCountryRequest request) {
		Country country = this.countryRepository.getCountyByName(request.getName());
		GetCountryResponse response = new GetCountryResponse();
		this.modelMapper.map(country, response);
		return response;
	}

	@Override
	public AddCountryResponse addCountry(AddCountryRequest request) {
		Country country = new Country();
		country.setCapital(request.getCapital());
		country.setName(request.getName());
		country.setPopulation(request.getPopulation());
		country.setCurrency(request.getCurrency().toString());
		country = this.countryRepository.save(country);
		AddCountryResponse response = new AddCountryResponse();
		this.modelMapper.map(country, response);
		return response;
	}

}
