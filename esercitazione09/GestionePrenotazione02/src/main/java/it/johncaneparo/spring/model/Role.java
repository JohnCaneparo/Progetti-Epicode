package it.johncaneparo.spring.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.Data;

@Data
@Entity
@Table(name="utente")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	@Enumerated(EnumType.STRING)
	private RoleType roletype;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public RoleType getRoletype() {
		return roletype;
	}
	public void setRoletype(RoleType roletype) {
		this.roletype = roletype;
	}

	public Role() {}
	public Role(RoleType roletype) {
		this.roletype = roletype;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roletype=" + roletype + "]";
	}
}
