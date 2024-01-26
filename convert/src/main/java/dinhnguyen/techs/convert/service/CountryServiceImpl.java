package dinhnguyen.techs.convert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import dinhnguyen.techs.convert.configs.SoapConnector;
import dinhnguyen.techs.convert.mapper.AddCountryRequest;
import dinhnguyen.techs.convert.mapper.AddCountryResponse;
import dinhnguyen.techs.convert.mapper.GetCountryRequest;
import dinhnguyen.techs.convert.mapper.GetCountryResponse;

@Service
public class CountryServiceImpl implements CountryService {

	final String uri = "http://localhost:8090/soap/country";
	final String getCountryUrl = "http://dinhnguyen.techs/soap/getCountry";
	final String addCountryUrl = "http://dinhnguyen.techs/soap/addCountry";

	@Autowired
	private SoapConnector<GetCountryRequest, GetCountryResponse> getCountryConnector;

	@Autowired
	private SoapConnector<AddCountryRequest, AddCountryResponse> addCountryConnector;

	@Autowired 
	private Jaxb2Marshaller jaxb2Marshaller;

	@Override
	public GetCountryResponse getCountryByName(String countryName) {
		GetCountryRequest request = new GetCountryRequest();
		request.setName(countryName);
		this.getCountryConnector.setDefaultUri("http://localhost:8090/soap/country.wsdl");
		this.getCountryConnector.setMarshaller(this.jaxb2Marshaller);
		this.getCountryConnector.setUnmarshaller(this.jaxb2Marshaller);
		GetCountryResponse response = this.getCountryConnector.getResponse(uri, request, getCountryUrl);
		return response;

	}

	@Override
	public AddCountryResponse addCountry(AddCountryRequest request) {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("dinhnguyen.techs.convert.mapper");
		this.addCountryConnector.setMarshaller(this.jaxb2Marshaller);
		this.addCountryConnector.setUnmarshaller(this.jaxb2Marshaller);
		this.addCountryConnector.setDefaultUri("http://localhost:8090/soap/country.wsdl");
		AddCountryResponse response = this.addCountryConnector.getResponse(uri, request, addCountryUrl);
		return response;
	}

}
