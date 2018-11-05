package csdn.model;

import java.io.Serializable;

public class article_type {
	private int a_type_id;
	private String type;
	private int count;//文章类型数目

	public article_type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public article_type(int a_type_id, String type,int count) {
		super();
		this.a_type_id = a_type_id;
		this.type = type;
		this.count = count;
	}

	public int getA_type_id() {
		return a_type_id;
	}

	public void setA_type_id(int a_type_id) {
		this.a_type_id = a_type_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
