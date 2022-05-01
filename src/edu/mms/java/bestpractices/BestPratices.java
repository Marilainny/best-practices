package edu.mms.java.bestpractices;

import java.util.List;

import edu.mms.java.bestpractices.teste.Produto;

public class BestPratices {
	
/*
 * Renomeando variáveis
 */
	public void produtosResumido(){ 
		
	    List<Produto> produtos = lista();
	    
	    for (Produto produto : produtos) { 
	        String descricaoSemEspaco = produto.getDescricao().trim();
	        StringBuilder sb = new StringBuilder(); 
	        for (int i = 0; i < descricaoSemEspaco.length(); i++) { 
	            if(i > 15) { sb.append("..."); 
	            break; 
	        } 
	    sb.append(descricaoSemEspaco.charAt(i));
	    } 
	String descricaoAjustada = sb.toString(); 
	String valorFormatado = produto.getValor().toString().replace(".", ","); 
	String descricaoFinal = produto.getId() + " - " + descricaoAjustada + " - R$ " + valorFormatado; System.out.println(descricaoFinal); 
	} 
}
	List<Produto> produtos = lista();
	for (Produto produto : produto) {
		String descricaoSemEspaco = produto.getDescricao().trim();
		/*........*/				
	}
	private List<Produto> lista() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
