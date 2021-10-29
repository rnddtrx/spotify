package be.ipam.spotify.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * A userapp Class
 */
@ApiModel(description = "A userapp Class")
@JacksonXmlRootElement(localName = "Userapp")
@XmlRootElement(name = "Userapp")
@XmlAccessorType(XmlAccessType.FIELD)
public class Userapp extends RepresentationModel<Userapp>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("userappId")
  @JacksonXmlProperty(localName = "userappId")
  private Long userappId;

  @JsonProperty("login")
  @JacksonXmlProperty(localName = "login")
  private String login;

  @JsonProperty("password")
  @JacksonXmlProperty(localName = "password")
  private String password;

  public Userapp userappId(Long userappId) {
    this.userappId = userappId;
    return this;
  }

  /**
   * id
   * @return userappId
  */
  @ApiModelProperty(value = "id")


  public Long getUserappId() {
    return userappId;
  }

  public void setUserappId(Long userappId) {
    this.userappId = userappId;
  }

  public Userapp login(String login) {
    this.login = login;
    return this;
  }

  /**
   * login.
   * @return login
  */
  @ApiModelProperty(value = "login.")


  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public Userapp password(String password) {
    this.password = password;
    return this;
  }

  /**
   * password.
   * @return password
  */
  @ApiModelProperty(value = "password.")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Userapp userapp = (Userapp) o;
    return Objects.equals(this.userappId, userapp.userappId) &&
        Objects.equals(this.login, userapp.login) &&
        Objects.equals(this.password, userapp.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userappId, login, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Userapp {\n");
    
    sb.append("    userappId: ").append(toIndentedString(userappId)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

