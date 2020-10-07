package agenda;

/**
 * Representação de um Contato.
 * 
 * @author Paulo Hernane Fontes e Silva
 */
public class Contato {
	/**
	 * Nome do contato.
	 */
	private String nome;
	
	/**
	 * Sobrenome do contato.
	 */
	private String sobrenome;

	/**
	 * Array que armazena os números de telefone.
	 */
	private String[] numerosTelefone;
	
	/**
	 * Identificador do número de telefone prioritário.
	 */
	private int telefonePrioritario;
	
	/**
	 * Identificador do número de telefone do contato do WhatsApp.
	 */
	private int contatoWhatsApp;
	
	/**
	 * Contrói um Contato.
	 * @param nome Primeiro nome do Contato.
	 * @param sobrenome Sobrenome do Contato.
	 * @param numerosTelefone Array com os números de telefone.
	 * @param telefonePrioritario Identificador do número de telefone prioritário.
	 * @param contatoWhatsApp Identificador do número de telefone do contato do WhatsApp.
	 */
	public Contato(String nome, String sobrenome, String[] numerosTelefone, int telefonePrioritario, int contatoWhatsApp) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numerosTelefone = numerosTelefone;
		this.telefonePrioritario = telefonePrioritario;
		this.contatoWhatsApp = contatoWhatsApp;
	}
	
	/**
	 * Retorna o Nome Completo do Contato.
	 * @return nome O nome completo em String.
	 */
	public String nomeCompleto() {
		String nomeCompleto = this.nome + " " + this.sobrenome;
		return nomeCompleto;
	}
	
	/**
	 * Verifica se os objetos são iguais.
	 * @param o Objeto a ser verificado igualdade.
	 * @return true se esse objeto possui mesmo {@link #nome} e {@link #sobrenome} que outro objeto.
	 * @see java.lang.Object#equals(Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (!(o instanceof Contato)) {
			return false;
		}
		
		Contato other = (Contato) o;
		
		return this.nome == other.nome && this.sobrenome == other.sobrenome;	
	}
	
	/**
	 * Gera o HashCode do Contato com base no HashCode de {@link #nome} e {@link #sobrenome}.
	 * @return hashCode do Contato.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hashCode = this.nome.hashCode() + this.sobrenome.hashCode();
		return hashCode;	
	}
	
	/**
	 * Retorna a representação em String do Contato.
	 * @return representação em String do Contato.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String contatoString = this.nome + " " + this.sobrenome + "\n";
		for (int i = 0; i < this.numerosTelefone.length; i++) {
			if (i == this.telefonePrioritario-1) {				
				contatoString += this.numerosTelefone[i] + " (prioritário)\n";
			} else if (i == this.contatoWhatsApp-1) {
				contatoString += this.numerosTelefone[i] + " (zap)\n";
			} else {
				contatoString += this.numerosTelefone[i] + "\n";
			}
		}
		
		return contatoString;
	}
}
