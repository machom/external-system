package com.hexagonal.external.system.ws.adapter;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.cdyne.ws.weatherws.GetCityForecastByZIP;
import com.cdyne.ws.weatherws.GetCityForecastByZIPResponse;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WeatherSoapSpringClientAdapter2 extends WebServiceGatewaySupport {

	public GetCityForecastByZIPResponse getCityForecastByZIP(String zip) {
		final GetCityForecastByZIP getCityForecastByZIP = new GetCityForecastByZIP();
		getCityForecastByZIP.setZIP(zip);
		GetCityForecastByZIPResponse getCityForecastByZIPResponse = (GetCityForecastByZIPResponse) getWebServiceTemplate()
				.marshalSendAndReceive(getCityForecastByZIP);
		return getCityForecastByZIPResponse;

	}

}
