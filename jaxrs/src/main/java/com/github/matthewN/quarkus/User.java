package com.github.matthewN.quarkus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "user", schema = "public")
public class User extends PanacheEntityBase {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String firstname;

    public Integer age;

    public BigDecimal salary;

    public Long points;

	public Boolean verified;
	
	@CreationTimestamp
	public LocalDateTime creation;
}
