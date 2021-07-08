package com.assetsmanagement.assets_management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ASSET")
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;

	@NotBlank(message = "Book Title is required !!")
	@Size(min = 2, max = 20, message = "Book Title should be between 2 - 20 characters !!")
	private String assetsTitle;

	@NotBlank(message = "Book Name is required !!")
	@Size(min = 2, max = 20, message = "Book Name should be between 2 - 20 characters !!")
	private String assetsName;

	@Column(length = 1600)
	private String description;

	@ManyToOne
	@JsonIgnore
	private User user;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAssetsTitle() {
		return assetsTitle;
	}

	public void setAssetsTitle(String assetsTitle) {
		this.assetsTitle = assetsTitle;
	}

	public String getAssetsName() {
		return assetsName;
	}

	public void setAssetsName(String assetsName) {
		this.assetsName = assetsName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return this.aid == ((Asset) obj).getAid();
	}

	@Override
	public String toString() {
		return "Asset [aid=" + aid + ", assetsTitle=" + assetsTitle + ", assetsName=" + assetsName + ", description="
				+ description + ", user=" + user + "]";
	}

}