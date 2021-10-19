package com.bpb.publications.authors.vo;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorVO {
	@NotEmpty
	private String url;
	@NotEmpty
	private String name;
	@NotEmpty
	private String bio;
}
