package mhj.com.parser.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import mhj.com.parser.dto.EscritaExtrato;
import mhj.com.parser.dto.EscritaFatura;

@Slf4j
public class EscritorService {

	public void escreverExtrato(List<EscritaExtrato> list, File file) throws IOException  {

		BufferedWriter writer =  null;
		
		try {
			
			writer = new BufferedWriter(new FileWriter(file));
			writer.append("\"Data\";\"Descrição\";\"Valor\";\"Conta\"");
			
			for (EscritaExtrato escritaExtrato : list) {
				writer.newLine();
				writer.append(escritaExtrato.getDataLancamento());
				writer.append(";");
				writer.append(escritaExtrato.getTipoLancamento());
				writer.append(";");
				writer.append(escritaExtrato.getLancamento());
				writer.append(";");
				writer.append(escritaExtrato.getValor());
				writer.append(";");
				writer.append(escritaExtrato.getConta());
			}
			
			writer.flush();
			
		} catch (IOException e) {
			log.error("Erro: ", e);
		} finally {
			if (!Objects.isNull(writer)) {
				writer.close();
			}
		}

	}

	public void escreverFatura(List<EscritaFatura> list, File file) throws IOException {

		BufferedWriter writer =  null;
		
		try {
			
			writer = new BufferedWriter(new FileWriter(file));
			writer.append("\"Data\";\"Descrição\";\"Valor\";\"Conta\"");
			
			for (EscritaFatura escritaFatura : list) {
				writer.newLine();
				writer.append(escritaFatura.getDataLancamento());
				writer.append(";");
				writer.append(escritaFatura.getTipoLancamento());
				writer.append(";");
				writer.append(escritaFatura.getLancamento());
				writer.append(";");
				writer.append(escritaFatura.getValor());
				writer.append(";");
				writer.append(escritaFatura.getConta());
			}
			
			writer.flush();
			
		} catch (IOException e) {
			log.error("Erro: ", e);
		} finally {
			if (!Objects.isNull(writer)) {
				writer.close();
			}
		}

	}

}
