package com.bpb.publications.authors.model;  
  
import java.io.Serializable;  
  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
  
@Entity  
public class ZipCode implements Serializable {  
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private long id;  
    private String code;  
  
    public ZipCode() {  
        super();  
        // TODO Auto-generated constructor stub  
    }  
  
    public String getCode() {  
        return code;  
    }  
  
    public void setCode(String code) {  
        this.code = code;  
    }  
  
    @Override  
    public String toString() {  
        return "ZipCode [id=" + id + ", code=" + code + "]";  
    }  
  
}
