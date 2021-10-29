package be.ipam.spotify.api.model;

import java.util.Objects;
import be.ipam.spotify.api.model.Song;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * A album Class
 */
@ApiModel(description = "A album Class")
@JacksonXmlRootElement(localName = "Album")
@XmlRootElement(name = "Album")
@XmlAccessorType(XmlAccessType.FIELD)
public class Album extends RepresentationModel<Album>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("albumId")
  @JacksonXmlProperty(localName = "albumId")
  private Long albumId;

  @JsonProperty("name")
  @JacksonXmlProperty(localName = "name")
  private String name;

  @JsonProperty("songs")
  @JacksonXmlProperty(localName = "songs")
  @Valid
  private List<Song> songs = null;

  public Album albumId(Long albumId) {
    this.albumId = albumId;
    return this;
  }

  /**
   * id
   * @return albumId
  */
  @ApiModelProperty(value = "id")


  public Long getAlbumId() {
    return albumId;
  }

  public void setAlbumId(Long albumId) {
    this.albumId = albumId;
  }

  public Album name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name.
   * @return name
  */
  @ApiModelProperty(value = "name.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Album songs(List<Song> songs) {
    this.songs = songs;
    return this;
  }

  public Album addSongsItem(Song songsItem) {
    if (this.songs == null) {
      this.songs = new ArrayList<>();
    }
    this.songs.add(songsItem);
    return this;
  }

  /**
   * Collection of Song.
   * @return songs
  */
  @ApiModelProperty(value = "Collection of Song.")

  @Valid

  public List<Song> getSongs() {
    return songs;
  }

  public void setSongs(List<Song> songs) {
    this.songs = songs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Album album = (Album) o;
    return Objects.equals(this.albumId, album.albumId) &&
        Objects.equals(this.name, album.name) &&
        Objects.equals(this.songs, album.songs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(albumId, name, songs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Album {\n");
    
    sb.append("    albumId: ").append(toIndentedString(albumId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    songs: ").append(toIndentedString(songs)).append("\n");
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

