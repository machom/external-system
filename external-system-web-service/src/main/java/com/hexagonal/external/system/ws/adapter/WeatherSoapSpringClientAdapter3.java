package com.hexagonal.external.system.ws.adapter;

import com.cdyne.ws.weatherws.GetCityForecastByZIP;
import com.cdyne.ws.weatherws.GetCityForecastByZIPResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WeatherSoapSpringClientAdapter3 {

	private final SoapClientService soapClientService;

	public GetCityForecastByZIPResponse getCityForecastByZIP(String zip) {
		final GetCityForecastByZIP getCityForecastByZIP = new GetCityForecastByZIP();
		getCityForecastByZIP.setZIP(zip);
		GetCityForecastByZIPResponse getCityForecastByZIPResponse = soapClientService.callSpringSoapService("", zip);
		return getCityForecastByZIPResponse;

	}

}
