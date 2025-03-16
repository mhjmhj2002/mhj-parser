package mhj.com.parser.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EscritaExtrato {
	
	private Date dataLancamento;
	private String tipoLancamento;
	private String lancamento;
	private String categoria;
	private String valor;
	private String saldo;
	private String conta;

}
