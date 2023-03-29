package com.customer.DTO;

public class OperatorDTO {
	private Integer Id;
	private Integer dept_id;
	public OperatorDTO()
	{
		
	}
	public OperatorDTO(Integer id, Integer dept_id) {
		super();
		Id = id;
		this.dept_id = dept_id;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}
	@Override
	public String toString() {
		return "OperatorDTO [Id=" + Id + ", dept_id=" + dept_id + "]";
	}
	
}
