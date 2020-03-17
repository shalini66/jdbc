package com.cap.hibernate.manytomany;

import java.io.Serializable;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cap.hibernateapp.dto.EmployeePrimaryInfo;

import lombok.Data;
import lombok.ToString.Exclude;
import net.bytebuddy.agent.builder.AgentBuilder.RawMatcher.Inversion;
@Data
@Entity
@Table(name = "ProjectInfo")
public class ProjectInfo implements Serializable{
	@Id
	@Column
	private int pid;
	@Column
	private String pname;
	@Column
	private Date startdate;
	@Column
	private Date enddate;
	@Column
	private String technology;
	
	
	@Exclude
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name= "pid"),
	inverseJoinColumns = @JoinColumn(name = "empid"))
	private List<EmployeePrimaryInfo> primary;
	
}
