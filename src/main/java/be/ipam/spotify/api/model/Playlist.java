package be.ipam.spotify.api.model;

import java.util.Objects;
import be.ipam.spotify.api.model.PlaylistSong;
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
 * A playlist Class
 */
@ApiModel(description = "A playlist Class")
@JacksonXmlRootElement(localName = "Playlist")
@XmlRootElement(name = "Playlist")
@XmlAccessorType(XmlAccessType.FIELD)
public class Playlist extends RepresentationModel<Playlist>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("playlistId")
  @JacksonXmlProperty(localName = "playlistId")
  private Long playlistId;

  @JsonProperty("name")
  @JacksonXmlProperty(localName = "name")
  private String name;

  @JsonProperty("playlistSongs")
  @JacksonXmlProperty(localName = "playlistSongs")
  @Valid
  private List<PlaylistSong> playlistSongs = null;

  public Playlist playlistId(Long playlistId) {
    this.playlistId = playlistId;
    return this;
  }

  /**
   * id
   * @return playlistId
  */
  @ApiModelProperty(value = "id")


  public Long getPlaylistId() {
    return playlistId;
  }

  public void setPlaylistId(Long playlistId) {
    this.playlistId = playlistId;
  }

  public Playlist name(String name) {
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

  public Playlist playlistSongs(List<PlaylistSong> playlistSongs) {
    this.playlistSongs = playlistSongs;
    return this;
  }

  public Playlist addPlaylistSongsItem(PlaylistSong playlistSongsItem) {
    if (this.playlistSongs == null) {
      this.playlistSongs = new ArrayList<>();
    }
    this.playlistSongs.add(playlistSongsItem);
    return this;
  }

  /**
   * Collection of PlaylistSong.
   * @return playlistSongs
  */
  @ApiModelProperty(value = "Collection of PlaylistSong.")

  @Valid

  public List<PlaylistSong> getPlaylistSongs() {
    return playlistSongs;
  }

  public void setPlaylistSongs(List<PlaylistSong> playlistSongs) {
    this.playlistSongs = playlistSongs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Playlist playlist = (Playlist) o;
    return Objects.equals(this.playlistId, playlist.playlistId) &&
        Objects.equals(this.name, playlist.name) &&
        Objects.equals(this.playlistSongs, playlist.playlistSongs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playlistId, name, playlistSongs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Playlist {\n");
    
    sb.append("    playlistId: ").append(toIndentedString(playlistId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    playlistSongs: ").append(toIndentedString(playlistSongs)).append("\n");
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

