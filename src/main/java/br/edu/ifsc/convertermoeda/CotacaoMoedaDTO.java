package br.edu.ifsc.convertermoeda;

public class CotacaoMoedaDTO {
		private Double valor;
		private String operacao;
		private Double valorCompra;
		private Double valorVenda;

		public Double getValor() {
			return valor;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}

		public String getOperacao() {
			return operacao;
		}

		public void setOperacao(String operacao) {
			this.operacao = operacao;
		}

		public Double getValorCompra() {
			return valorCompra;
		}

		public void setValorCompra(Double valorCompra) {
			this.valorCompra = valorCompra;
		}

		public Double getValorVenda() {
			return valorVenda;
		}

		public void setValorVenda(Double valorVenda) {
			this.valorVenda = valorVenda;
		}
	}


