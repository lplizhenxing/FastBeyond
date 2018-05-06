package com.beyond.pojo;

/**
 * BeyondTask entity. @author MyEclipse Persistence Tools
 */

public class BeyondTask implements java.io.Serializable {

	// Fields

	private Integer taskId;
	private String taskName;
	private Integer status;

	// Constructors

	/** default constructor */
	public BeyondTask() {
	}

	/** full constructor */
	public BeyondTask(String taskName, Integer status) {
		this.taskName = taskName;
		this.status = status;
	}

	// Property accessors

	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}