package com.chinasofti;

import java.io.Serializable;

public class EasyUITreeNode implements Serializable {

	private long id; // 类目id
	private String text; //类目的名字
	private String state; //类目的状态
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
