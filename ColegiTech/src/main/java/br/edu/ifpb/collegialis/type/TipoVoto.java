package br.edu.ifpb.collegialis.type;

public enum TipoVoto {
	COM_RELATOR("Com o relator"),
	DIVERGENTE("Divergente");
	
	private String texto;
	
	private TipoVoto(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

}
