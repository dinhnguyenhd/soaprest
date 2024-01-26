package dinhnguyen.techs.convert.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class SoapConnector<R, P> extends WebServiceGatewaySupport {

	@Autowired
	private WebServiceTemplate webServiceTemplate;

	public P getResponse(String uri, R request, String url) {

		@SuppressWarnings("unchecked")
		P response = (P) this.webServiceTemplate.marshalSendAndReceive(uri, request, new SoapActionCallback(url));
		return response;

	}

}
