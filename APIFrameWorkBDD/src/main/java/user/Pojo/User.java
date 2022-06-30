package user.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;


public class User {

	@JsonProperty("Name")
	private String name;
	@JsonProperty("Job")
	private String job;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	
}
