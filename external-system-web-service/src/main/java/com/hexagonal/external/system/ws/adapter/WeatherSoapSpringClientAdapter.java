package com.hexagonal.external.system.ws.adapter;

import org.springframework.ws.client.core.WebServiceTemplate;

import com.cdyne.ws.weatherws.GetCityForecastByZIP;
import com.cdyne.ws.weatherws.GetCityForecastByZIPResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WeatherSoapSpringClientAdapter {

	private final WebServiceTemplate webServiceTemplate;

	public GetCityForecastByZIPResponse getCityForecastByZIP(String zip) {

		GetCityForecastByZIP getCityForecastByZIP = new GetCityForecastByZIP();
		getCityForecastByZIP.setZIP(zip);
		GetCityForecastByZIPResponse getCityForecastByZIPResponse = (GetCityForecastByZIPResponse) webServiceTemplate
				.marshalSendAndReceive(getCityForecastByZIP);
		return getCityForecastByZIPResponse;
	}

}
