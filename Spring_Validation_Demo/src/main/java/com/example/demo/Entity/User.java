package com.example.demo.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
     
   // @NotEmpty(message = "First name is required")
    @Size(min = 3 , max=10 , message = "Enter atleast 3 characters and not more than 10 characters")
    private String firstName;
      
   // @NotEmpty(message = "Last name is required")
    @Size(min = 3 , max=10 , message = "Enter atleast 3 characters and not more than 10 characters")
    private String lastName;
      
    @NotEmpty(message = "Email is required")
    @Email(message = "Email is invalid")
    private String email;
     
    @NotEmpty(message = "Mobile number is required")
    @Pattern(regexp="^[6-9]\\d{9}$",  message="Mobile number is invalid")
    private String mobileNumber;
     
    @NotNull(message = "date of birth is required")
    @Past
    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "dd-mm-yyyy")
    private Date birthYear;
     
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Date birthYear) {
		this.birthYear = birthYear;
	}

}
