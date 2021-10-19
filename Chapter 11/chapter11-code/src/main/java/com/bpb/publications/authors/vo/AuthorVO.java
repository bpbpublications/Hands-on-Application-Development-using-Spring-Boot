package com.bpb.publications.authors.vo;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AuthorVO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-06T22:31:44.022+05:30")

public class AuthorVO   {
  @JsonProperty("bio")
  private String bio = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("url")
  private String url = null;

  public AuthorVO bio(String bio) {
    this.bio = bio;
    return this;
  }

  /**
   * This is the bio of the author
   * @return bio
  **/
  @ApiModelProperty(value = "This is the bio of the author")

@Size(min=0,max=500) 
  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public AuthorVO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * This is the name of the author
   * @return name
  **/
  @ApiModelProperty(example = "Shagun", required = true, value = "This is the name of the author")
  @NotNull

@Size(min=0,max=20) 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AuthorVO url(String url) {
    this.url = url;
    return this;
  }

  /**
   * This is the url of the author
   * @return url
  **/
  @ApiModelProperty(example = "www.example.com", value = "This is the url of the author")

@Size(min=0,max=50) 
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthorVO authorVO = (AuthorVO) o;
    return Objects.equals(this.bio, authorVO.bio) &&
        Objects.equals(this.name, authorVO.name) &&
        Objects.equals(this.url, authorVO.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bio, name, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthorVO {\n");
    
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

