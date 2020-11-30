package es.ubu.lsi.Practica3ChatWeb;


/**
 * Clase para el cliente
 * 
 * @author Miguel Arroyo
 *
 */
public class ChatClientWeb {
	
	private String nickname;
	
	private int id;

	public ChatClientWeb(String nickname, int id) {
		this.nickname = nickname;
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
