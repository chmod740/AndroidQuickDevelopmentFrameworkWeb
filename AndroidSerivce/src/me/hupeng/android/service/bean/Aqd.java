package me.hupeng.android.service.bean;

import java.sql.Timestamp;

/**
 * Aqd entity. @author MyEclipse Persistence Tools
 */

public class Aqd implements java.io.Serializable {

	// Fields

	private Integer id;
	private String sid;
	private String table;
	private String key;
	private String value;
	private Timestamp createTime;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public Aqd() {
	}

	/** full constructor */
	public Aqd(String sid, String table, String key, String value,
			Timestamp createTime, Timestamp updateTime) {
		this.sid = sid;
		this.table = table;
		this.key = key;
		this.value = value;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getTable() {
		return this.table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}