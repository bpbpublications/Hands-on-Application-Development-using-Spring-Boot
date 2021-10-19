package com.bpb.publications.authors.entity;  
  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;  
  
@Entity  
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "name"}))   
public class Role {  
    @Id  
    @GeneratedValue  
    private Long id;  
    private String name;  
}  
