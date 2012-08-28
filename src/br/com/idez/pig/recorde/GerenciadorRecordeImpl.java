package br.com.idez.pig.recorde;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class GerenciadorRecordeImpl implements IGerenciadorRecorde {

	private static File arquivoProperties = new File( "recorde.properties" ); 
	private Properties props;

	public GerenciadorRecordeImpl() {
		props = new Properties();          
        try {  
            props.load( new FileInputStream(arquivoProperties));  
        } catch (FileNotFoundException ex) {  
            ex.printStackTrace();  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        } 
	}
	
	@Override
	public boolean verificaRecorde(String quantidadeJogadas) {
		boolean isRecorde = false;
		String recordeAtual = props.get("recorde").toString();
		int recordeAtualInt = Integer.parseInt(recordeAtual);
		
		int quantidadeJogadasInt = Integer.parseInt(quantidadeJogadas);
		if (quantidadeJogadasInt < recordeAtualInt) {
			gravarRecord(quantidadeJogadas);
			isRecorde = true;
		}
		return isRecorde;
	}

	private void gravarRecord(String recorde) {
		props.setProperty("recorde", recorde);
		try {
			props.store(new FileOutputStream("recorde.properties"), null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getRecorde() {
		String recordeAtual = props.get("recorde").toString();
		int recordeAtualInt = Integer.parseInt(recordeAtual);
		return recordeAtualInt;
	}
}
