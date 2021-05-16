package br.edu.ifsc.convertermoeda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConverterMoeda2Application {

	public static void main(String[] args) {
		MoedaDataSource.criarLista();
		SpringApplication.run(ConverterMoeda2Application.class, args);
	}

}
