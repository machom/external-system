package com.hexagonal.external.system.ws.client;

import com.cdyne.ws.weatherws.ForecastReturn;
import com.cdyne.ws.weatherws.WeatherReturn;
import com.cdyne.ws.weatherws.WeatherSoap;

public class WeatherSoapClient {

	private final WeatherSoap weatherSoap;

	public WeatherSoapClient(final WeatherSoap weatherSoap) {
		super();
		this.weatherSoap = weatherSoap;
	}

	public ForecastReturn getCityForecastByZIP(final String zip) {
		ForecastReturn forecastReturn = weatherSoap.getCityForecastByZIP(zip);
		return forecastReturn;
	}

	public WeatherReturn getCityWeatherByZIP(final String zip) {
		WeatherReturn weatherReturn = weatherSoap.getCityWeatherByZIP(zip);
		return weatherReturn;
	}
}
