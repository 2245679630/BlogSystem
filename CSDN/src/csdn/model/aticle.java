package csdn.model;

import java.io.Serializable;
import java.util.Date;

public class aticle {

	private int art_id;
	private String title;
	private String content;
	private Date pub_date;
	private int u_id;
	private int a_type_id;
    private String username;
    private String type;
	public aticle() {
		// super();

	}

	

	public aticle(int art_id, String title, String content, Date pub_date, int u_id, int a_type_id, String username,
			String type) {
		super();
		this.art_id = art_id;
		this.title = title;
		this.content = content;
		this.pub_date = pub_date;
		this.u_id = u_id;
		this.a_type_id = a_type_id;
		this.username = username;
		this.type = type;
	}



	public int getArt_id() {
		return art_id;
	}

	public void setArt_id(int art_id) {
		this.art_id = art_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPub_date() {
		return pub_date;
	}

	public void setPub_date(Date pub_date) {
		this.pub_date = pub_date;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getA_type_id() {
		return a_type_id;
	}

	public void setA_type_id(int a_type_id) {
		this.a_type_id = a_type_id;
	}
   
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "aticle [art_id=" + art_id + ", title=" + title + ", content=" + content + ", pub_date=" + pub_date
				+ ", u_id=" + u_id + ", a_type_id=" + a_type_id + ", username=" + username + ", type=" + type + "]";
	}

}
