package com.example.customerriskconsumer.models;

import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="customerRisk")
public class CustomerRiskDto {

	@Id
	private int id;
	private boolean crypto;
	private boolean gambling;
	private boolean atRisk;
	
	public CustomerRiskDto() {
		// TODO Auto-generated constructor stub
	}

	public CustomerRiskDto(int id, boolean crypto, boolean gambling, boolean atRisk) {
		this.id = id;
		this.crypto = crypto;
		this.gambling = gambling;
		this.atRisk = atRisk;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCrypto() {
		return crypto;
	}

	public void setCrypto(boolean crypto) {
		this.crypto = crypto;
	}

	public boolean isGambling() {
		return gambling;
	}

	public void setGambling(boolean gambling) {
		this.gambling = gambling;
	}

	public boolean isAtRisk() {
		return atRisk;
	}

	public void setAtRisk(boolean atRisk) {
		this.atRisk = atRisk;
	}

	@Override
	public int hashCode() {
		return Objects.hash(atRisk, gambling, id, crypto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerRiskDto other = (CustomerRiskDto) obj;
		return atRisk == other.atRisk && crypto == other.crypto && id == other.id
				&& gambling == other.gambling;
	}

	@Override
	public String toString() {
		return "CustomerRiskDto [id=" + id + ", crypto=" + crypto + ", gambling=" + gambling + ", atRisk=" + atRisk
				+ "]";
	}
}