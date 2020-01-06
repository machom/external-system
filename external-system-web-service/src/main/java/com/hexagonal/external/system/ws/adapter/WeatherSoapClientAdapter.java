package com.hexagonal.external.system.ws.adapter;

import com.cdyne.ws.weatherws.ForecastReturn;
import com.cdyne.ws.weatherws.WeatherReturn;
import com.cdyne.ws.weatherws.WeatherSoap;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WeatherSoapClientAdapter {

	private final WeatherSoap weatherSoap;

	public ForecastReturn getCityForecastByZIP(String zip) {
		ForecastReturn forecastReturn = weatherSoap.getCityForecastByZIP(zip);
		return forecastReturn;
	}

	public WeatherReturn getCityWeatherByZIP(String zip) {
		WeatherReturn weatherReturn = weatherSoap.getCityWeatherByZIP(zip);
		return weatherReturn;
	}

}
