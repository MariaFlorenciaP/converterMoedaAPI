package br.edu.ifsc.convertermoeda;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CotacaoMoedaController {

	@RequestMapping(value = "/converter_moeda/{valor}/{tipoMoeda}/{tipoOperacao}", method = RequestMethod.GET)
	public CotacaoMoedaDTO converterMoeda(
			@PathVariable(name = "valor") double valor, 
			@PathVariable(name = "tipoMoeda") String tipoMoeda, 
			@PathVariable(name = "tipoOperacao") String tipoOperacao) {
		
		 CotacaoMoedaDTO dto = new CotacaoMoedaDTO();
	        dto.setValor(valor);
	        dto.setOperacao(tipoOperacao);
		
		Moeda moeda = MoedaDataSource.get(tipoMoeda);
		
	                                                                                          	//double cotacao = 0.0;
		
		if (moeda != null) {
			if (tipoOperacao.equalsIgnoreCase("venda")) {
				if (!tipoMoeda.equalsIgnoreCase("OU")) {
					 dto.setValorVenda(valor / moeda.getValorVenda());
				} else {
					 dto.setValorVenda(valor / calcularPrecoVendaOuro(moeda));
				}
			} else {
				 dto.setValorCompra(valor * moeda.getValorCompra());
			}
		}
		
		return dto;
	}
	
	private double calcularPrecoVendaOuro(Moeda moeda) {
		double precoVendaOuro = moeda.getValorCompra() + 
				(moeda.getValorCompra() * moeda.getValorVenda() / 100);
		return precoVendaOuro;
	}
	
}

