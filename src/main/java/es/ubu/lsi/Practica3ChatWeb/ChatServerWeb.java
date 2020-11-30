package es.ubu.lsi.Practica3ChatWeb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Calse del servidor
 * 
 * @author Miguel Arroyo
 *
 */
public class ChatServerWeb {

	private static int clientId = 0;
	/**
	 * Formato de fecha para registra la hora de conexxion
	 */
	private static SimpleDateFormat sdf;
	/**
	 * Almacena los mensajes de un cliente
	 */
	private static ArrayList<String> messages;

	/**
	 * Registro de los clientes y sus mensajes
	 */
	private Map<ChatClientWeb, ArrayList<String>> clients = new HashMap<>();

	private ChatClientWeb ccw;
	public ChatServerWeb() {
		ccw = new ChatClientWeb("Servidor", 0);
	}
	

	/**
	 * Añade un nuevo usuario al mapa
	 * 
	 * @param client
	 * @return id del cliente
	 */
	public int checkIn(ChatClientWeb client) {
		// Por cada cliente nuevo crea una lista donde almacena sus mensajes
		messages = new ArrayList<String>();
		clientId++;
		client.setId(clientId);
		clients.put(client, messages);

		return client.getId();
	}

	/**
	 * Se implementará siguiendo un modelo pull: son los clientes los que
	 * periódicamente solicitan al servidor la nueva lista de mensajes.
	 * 
	 * Envia los mensajes de un cliente al resto de los clientes conectados
	 * 
	 */
	public void sendMessge(ChatClientWeb cc, String message) {
		
		messages = new ArrayList<String>();
		
		for (Map.Entry<ChatClientWeb, ArrayList<String>> entry : clients.entrySet()) {
			// Se envia a todos menos a quien lo envia
			if (cc != entry.getKey()) {
				messages.add(message);
				entry.setValue(messages);
				
			}
		}
	}

	/**
	 * Elimina del map a un usuario y sus mensajes cuando el usuario se desconecta
	 * 
	 * @param cc cliente
	 */
	public void logout(ChatClientWeb cc) {
		clients.remove(cc);
	}

	/**
	 * Devuelve la hora que se envia un mensaje
	 * 
	 * @return hora
	 */
	private String getTime() {
		// creamos una nueva fecha
		Date date = new Date();
		sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * Devuelve una arraylist con todos los mensajes
	 * 
	 * @param cc cliente
	 * @return lista de mensajes
	 */
	public ArrayList<String> getMessages(ChatClientWeb cc) {
		return clients.get(cc);
	}

}
