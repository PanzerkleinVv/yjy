package com.dem.yjy.web.model;

public class Column {
	private String id;

	private String columnName;

	private String columnInfo;

	private String columnTitle;

	private String columnKeyword;

	private Integer columnSort;

	private Integer columnStatus;

	private String msg0;
	
	private String msg;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName == null ? null : columnName.trim();
	}

	public String getColumnInfo() {
		return columnInfo;
	}

	public void setColumnInfo(String columnInfo) {
		this.columnInfo = columnInfo == null ? null : columnInfo.trim();
	}

	public String getColumnTitle() {
		return columnTitle;
	}

	public void setColumnTitle(String columnTitle) {
		this.columnTitle = columnTitle == null ? null : columnTitle.trim();
	}

	public String getColumnKeyword() {
		return columnKeyword;
	}

	public void setColumnKeyword(String columnKeyword) {
		this.columnKeyword = columnKeyword == null ? null : columnKeyword.trim();
	}

	public Integer getColumnSort() {
		return columnSort;
	}

	public void setColumnSort(Integer columnSort) {
		this.columnSort = columnSort;
	}

	public Integer getColumnStatus() {
		return columnStatus;
	}

	public void setColumnStatus(Integer columnStatus) {
		this.columnStatus = columnStatus;
	}

	public String getMsg0() {
		return msg0;
	}

	public void setMsg0(String msg0) {
		this.msg0 = msg0;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}