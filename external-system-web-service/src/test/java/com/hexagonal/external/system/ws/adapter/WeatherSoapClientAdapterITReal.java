package com.hexagonal.external.system.ws.adapter;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cdyne.ws.weatherws.GetCityForecastByZIP;
import com.hexagonal.external.system.ws.infra.SoapRepositoryConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoapRepositoryConfiguration.class)
public class WeatherSoapClientAdapterITReal {

	private static final String ZIP_CODE = "23454";

	@Autowired
	private WeatherSoapSpringClientAdapter2 weatherSoapSpringClientAdapter2;

	@Test(expected = RuntimeException.class)
	public void getCityForecastByZIP() throws IOException {
		String zip = ZIP_CODE;
		GetCityForecastByZIP getCityForecastByZIP = new GetCityForecastByZIP();
		getCityForecastByZIP.setZIP(zip);
		weatherSoapSpringClientAdapter2.getCityForecastByZIP(zip);
	}

}
