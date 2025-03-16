package mhj.com.parser.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mhj.com.parser.dto.EscritaExtrato;
import mhj.com.parser.dto.EscritaFatura;

@Service
@Slf4j
public class ParseInterService {
	
	String dir = "C:\\extratos\\";
	
	private final EscritorService escritorService; 

	public ParseInterService(EscritorService escritorService) {
		this.escritorService = escritorService;
	}

	public void parseExtratoInter(String arquivo) throws IOException {
		
		File file = new File(dir + arquivo);
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		List<EscritaExtrato> list = new ArrayList<>();
		
		EscritaExtrato escritaExtrato;
		
		try {

			boolean encontrouHeader = false;
			
			while(reader.ready()) {
				String currentLine = reader.readLine();

				if (currentLine.contains("Data Lançamento")) {
					
					encontrouHeader = true;
				} else if(encontrouHeader) {
					if (currentLine.isBlank()) {
						break;
					}
					currentLine = currentLine.replaceAll("\\.", "");
					currentLine = currentLine.replaceAll(",", ".");
					String[] split = currentLine.split(";");
					BigDecimal valor = new BigDecimal(split[3]);
					
					escritaExtrato = new EscritaExtrato();
					escritaExtrato.setDataLancamento(split[0]);
					escritaExtrato.setTipoLancamento(split[2]);
					escritaExtrato.setValor(valor.toString());
					escritaExtrato.setConta("Inter");
					
					list.add(escritaExtrato);
				}
				
			}
			
			File retorno = new File(dir + "saida-" + arquivo);
			
			retorno.createNewFile();
			
			escritorService.escreverExtrato(list, retorno);
			
		} catch (Exception e) {
			log.error("Erro: {}", e.getMessage());
			throw e;
		} finally {
			reader.close();
		}
		
		
	}

	public void parseFaturaInter(String arquivo) throws IOException {
		
		File file = new File(dir + arquivo);
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		List<EscritaFatura> list = new ArrayList<>();
		
		EscritaFatura escritaExtrato;
		
		try {

			boolean encontrouHeader = false;
			
			while(reader.ready()) {
				String currentLine = reader.readLine();

				if (currentLine.contains("Data Lançamento")) {
					
					encontrouHeader = true;
				} else if(encontrouHeader) {
					if (currentLine.isBlank()) {
						break;
					}
					currentLine = currentLine.replaceAll("\\.", "");
					currentLine = currentLine.replaceAll(",", ".");
					String[] split = currentLine.split(";");
					BigDecimal valor = new BigDecimal(split[3]);
					
					escritaExtrato = new EscritaFatura();
					escritaExtrato.setDataLancamento(split[0]);
					escritaExtrato.setTipoLancamento(split[2]);
					escritaExtrato.setValor(valor.toString());
					escritaExtrato.setConta("Inter");
					
					list.add(escritaExtrato);
				}
				
			}
			
			File retorno = new File(dir + "saida-" + arquivo);
			
			retorno.createNewFile();
			
			escritorService.escreverFatura(list, retorno);
			
		} catch (Exception e) {
			log.error("Erro: {}", e.getMessage());
			throw e;
		} finally {
			reader.close();
		}
		
		
	}

}


