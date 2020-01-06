package com.hexagonal.external.system.ws.adapter;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.springframework.ws.test.client.RequestMatchers.payload;
import static org.springframework.ws.test.client.ResponseCreators.withPayload;

import java.io.IOException;

import javax.xml.transform.Source;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.test.client.MockWebServiceServer;
import org.springframework.xml.transform.ResourceSource;

import com.cdyne.ws.weatherws.GetCityForecastByZIP;
import com.cdyne.ws.weatherws.GetCityForecastByZIPResponse;
import com.hexagonal.external.system.ws.infra.SoapRepositoryConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoapRepositoryConfiguration.class)
public class WeatherSoapClientAdapterIT {

	private static final String ZIP_CODE = "23454";

	@Autowired
	private WebServiceTemplate webServiceTemplate;

	@Autowired
	private WeatherSoapSpringClientAdapter2 weatherSoapSpringClientAdapter2;

	private MockWebServiceServer mockServer;
	private MockWebServiceServer mockServer2;

	@Before
	public void init() {
		mockServer = MockWebServiceServer.createServer(webServiceTemplate);
		mockServer2 = MockWebServiceServer.createServer(weatherSoapSpringClientAdapter2);
	}

	@Test
	public void getCityForecastByZIP() throws IOException {
		Source expectedPayload = new ResourceSource(new ClassPathResource("request.xml"));
		Source expectedResponse = new ResourceSource(new ClassPathResource("response.xml"));
		mockServer.expect(payload(expectedPayload)).andRespond(withPayload(expectedResponse));

		String zip = ZIP_CODE;
		GetCityForecastByZIP getCityForecastByZIP = new GetCityForecastByZIP();
		getCityForecastByZIP.setZIP(zip);
		GetCityForecastByZIPResponse getCityForecastByZIPResponse = (GetCityForecastByZIPResponse) webServiceTemplate
				.marshalSendAndReceive(getCityForecastByZIP);

		assertNotNull(getCityForecastByZIPResponse);

		mockServer.verify();
	}

	@Test
	public void getCityForecastByZIP2() throws IOException {
		Source expectedPayload = new ResourceSource(new ClassPathResource("request.xml"));
		Source expectedResponse = new ResourceSource(new ClassPathResource("response.xml"));
		mockServer2.expect(payload(expectedPayload)).andRespond(withPayload(expectedResponse));

		String zip = ZIP_CODE;

		GetCityForecastByZIPResponse getCityForecastByZIPResponse = weatherSoapSpringClientAdapter2
				.getCityForecastByZIP(zip);

		assertNotNull(getCityForecastByZIPResponse);

		mockServer2.verify();
	}

}
