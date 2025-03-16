package mhj.com.parser.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ParseService {
	
	String dir = "C:\\extratos\\";
	
	public void parseInter(String arquivo) throws IOException {
		
		File file = new File(dir + arquivo);
		
		File retorno = new File(dir + "saida-" + arquivo);
		
		retorno.createNewFile();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(retorno));
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		try {

			boolean encontrouHeader = false;
			
			while(reader.ready()) {
				String currentLine = reader.readLine();

				if (currentLine.contains("Data Lançamento")) {
					
					encontrouHeader = true;
					writer.append("\"Data\";\"Descrição\";\"Valor\";\"Conta\"");
					//Data;Descrição;Valor
					//01/11/2017;Salario;100,5
				} else if(encontrouHeader) {
					if (currentLine.isBlank()) {
						break;
					}
					currentLine = currentLine.replaceAll("\\.", "");
					currentLine = currentLine.replaceAll(",", ".");
					String[] split = currentLine.split(";");
					BigDecimal valor = new BigDecimal(split[3]);
					writer.newLine();
					writer.append("\"");
					writer.append(split[0]);
					writer.append("\"");
					writer.append(";");
					writer.append("\"");
					writer.append(split[2]);
					writer.append("\"");
					writer.append(";");
					writer.append("\"");
					writer.append(valor.toString());
					writer.append("\"");
					writer.append(";");
					writer.append("\"");
					writer.append("Inter");
					writer.append("\"");
				}
				
			}
			writer.flush();
		} catch (Exception e) {
			log.error("Erro: {}", e.getMessage());
			throw e;
		} finally {
			reader.close();
			writer.close();
		}
		
		
	}

}
