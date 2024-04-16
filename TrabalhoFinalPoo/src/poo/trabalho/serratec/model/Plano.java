package poo.trabalho.serratec.model;

public class Plano {
	private int planoID;
	private String nomePlano;
	private int duracao;
	private double valor;
	private String descricao;
	
	public Plano(String nomePlano, int duracao, double valor, String descricao) {
		this.nomePlano = nomePlano;
		this.duracao = duracao;
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public int getPlanoID() {
		return planoID;
	}
	public String getNomePlano() {
		return nomePlano;
	}
	public int getDuracao() {
		return duracao;
	}
	public double getValor() {
		return valor;
	}
	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return "Plano [planoID=" + planoID + ", nomePlano=" + nomePlano + ", duracao=" + duracao + ", valor=" + valor
				+ ", descricao=" + descricao + "]";
	}
}