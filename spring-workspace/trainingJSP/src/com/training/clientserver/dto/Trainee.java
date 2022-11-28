/**
 * 
 */
package com.training.clientserver.dto;

/**
 * @author Amrutha
 *
 */
public class Trainee {
	private String traineeId;
	private String deptId;
	private String traineePersonId;
	private String trainerPersonId;
	private Person person;
	
	public String getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(String traineeId) {
		this.traineeId = traineeId;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getTraineePersonId() {
		return traineePersonId;
	}
	public void setTraineePersonId(String traineePersonId) {
		this.traineePersonId = traineePersonId;
	}
	public String getTrainerPersonId() {
		return trainerPersonId;
	}
	public void setTrainerPersonId(String trainerPersonId) {
		this.trainerPersonId = trainerPersonId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
