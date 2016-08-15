package br.edu.ifpb.collegialis.type;

public enum TipoDecisao {
	DEFERIDO("Deferido"),
	INDEFERIDO("Indeferido");
	
	private String texto;
	
	private TipoDecisao(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

}
