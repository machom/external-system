package com.hexagonal.external.system.ws.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.hexagonal.external.system.ws.adapter.SoapClientService;
import com.hexagonal.external.system.ws.adapter.WeatherSoapSpringClientAdapter;
import com.hexagonal.external.system.ws.adapter.WeatherSoapSpringClientAdapter2;

@Configuration
public class SoapRepositoryConfiguration {

	private static final String CONTEXT_PATH = "com.cdyne.ws.weatherws";

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		final Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath(CONTEXT_PATH);
		return jaxb2Marshaller;
	}

	@Bean
	public SoapClientService soapClientService(Jaxb2Marshaller marshaller) {
		SoapClientService client = new SoapClientService();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller jaxb2Marshaller) {
		final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		webServiceTemplate.setMarshaller(jaxb2Marshaller);
		webServiceTemplate.setUnmarshaller(jaxb2Marshaller);
		webServiceTemplate.setDefaultUri("http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL");
		return webServiceTemplate;
	}

	@Bean
	public WeatherSoapSpringClientAdapter weatherSoapSpringClientAdapter(WebServiceTemplate webServiceTemplate) {
		return new WeatherSoapSpringClientAdapter(webServiceTemplate);
	}

	@Bean
	public WeatherSoapSpringClientAdapter2 weatherSoapSpringClientAdapter2(Jaxb2Marshaller jaxb2Marshaller) {
		WeatherSoapSpringClientAdapter2 weatherSoapSpringClientAdapter2 = new WeatherSoapSpringClientAdapter2();
		weatherSoapSpringClientAdapter2.setMarshaller(jaxb2Marshaller);
		weatherSoapSpringClientAdapter2.setUnmarshaller(jaxb2Marshaller);
		weatherSoapSpringClientAdapter2.setDefaultUri("http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL");
		return weatherSoapSpringClientAdapter2;
	}
}
