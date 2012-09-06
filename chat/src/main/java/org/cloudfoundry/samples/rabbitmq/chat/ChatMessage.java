/**
 * 
 */
package org.cloudfoundry.samples.rabbitmq.chat;

/**
 * @author cri
 * 
 */
public class ChatMessage {
	private String id;
	private String exchange;
	private String routingKey;
	private String text;
	private String time;
	private String username;
	/**
	 * @param id
	 * @param exchange
	 * @param routingKey
	 * @param text
	 * @param time
	 * @param username
	 */
	public ChatMessage(String id, String exchange, String routingKey,
			String text, String time, String username) {
		this.id = id;
		this.exchange = exchange;
		this.routingKey = routingKey;
		this.text = text;
		this.time = time;
		this.username = username;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the exchange
	 */
	public String getExchange() {
		return exchange;
	}
	/**
	 * @param exchange the exchange to set
	 */
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	/**
	 * @return the routingKey
	 */
	public String getRoutingKey() {
		return routingKey;
	}
	/**
	 * @param routingKey the routingKey to set
	 */
	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChatMessage [id=" + id + ", exchange=" + exchange
				+ ", routingKey=" + routingKey + ", text=" + text + ", time="
				+ time + ", username=" + username + "]";
	}
	
}
