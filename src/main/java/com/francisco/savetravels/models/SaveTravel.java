package com.francisco.savetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="saveTravels")
public class SaveTravel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 5, max = 200, message="Expense name needs to be at least 5 characters long")
    private String expenseName;
    
    @NotNull
    @Size(min = 5, max = 200, message="Vendor needs to be at least 5 characters long")
    private String Vendor;
    
    
    @NotNull
    @Min(value=0, message="Amount needs to be more than $0.00")
    @NotNull
    private String amount;
    
    @NotNull
    @Size(min = 5, max = 200, message="Description needs to be at least 5 characters long")
    private String description;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    

	public SaveTravel() {}

	public SaveTravel(
			@NotNull @Size(min = 5, max = 200, message = "Expense name needs to be at least 5 characters long") String expenseName,
			@NotNull @Size(min = 5, max = 200, message = "Vendor needs to be at least 5 characters long") String vendor,
			@NotNull @Min(value = 0, message = "Amount needs to be more than $0.00") @NotNull String amount,
			@NotNull @Size(min = 5, max = 200, message = "Description needs to be at least 5 characters long") String description) {
		super();
		this.expenseName = expenseName;
		Vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	public SaveTravel(Long id,
			@NotNull @Size(min = 5, max = 200, message = "Expense name needs to be at least 5 characters long") String expenseName,
			@NotNull @Size(min = 5, max = 200, message = "Vendor needs to be at least 5 characters long") String vendor,
			@NotNull @Min(value = 0, message = "Amount needs to be more than $0.00") @NotNull String amount,
			@NotNull @Size(min = 5, max = 200, message = "Description needs to be at least 5 characters long") String description) {
		super();
		this.id = id;
		this.expenseName = expenseName;
		Vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public String getVendor() {
		return Vendor;
	}

	public void setVendor(String vendor) {
		Vendor = vendor;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}