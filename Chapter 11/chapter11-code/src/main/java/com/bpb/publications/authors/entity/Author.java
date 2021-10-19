package com.bpb.publications.authors.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bpb_author", uniqueConstraints = @UniqueConstraint(columnNames = { "name", "url" }))
@Getter
@Setter
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String url;
	private String name;
	private String bio;
}
