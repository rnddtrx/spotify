package be.ipam.spotify.api.model;

import java.util.Objects;
import be.ipam.spotify.api.model.Playlist;
import be.ipam.spotify.api.model.Song;
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
 * A playlistsong Class
 */
@ApiModel(description = "A playlistsong Class")
@JacksonXmlRootElement(localName = "PlaylistSong")
@XmlRootElement(name = "PlaylistSong")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaylistSong extends RepresentationModel<PlaylistSong>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("playlistSongId")
  @JacksonXmlProperty(localName = "playlistSongId")
  private Long playlistSongId;

  @JsonProperty("position")
  @JacksonXmlProperty(localName = "position")
  private Integer position;

  @JsonProperty("playlist")
  @JacksonXmlProperty(localName = "playlist")
  private Playlist playlist;

  @JsonProperty("song")
  @JacksonXmlProperty(localName = "song")
  private Song song;

  public PlaylistSong playlistSongId(Long playlistSongId) {
    this.playlistSongId = playlistSongId;
    return this;
  }

  /**
   * id
   * @return playlistSongId
  */
  @ApiModelProperty(value = "id")


  public Long getPlaylistSongId() {
    return playlistSongId;
  }

  public void setPlaylistSongId(Long playlistSongId) {
    this.playlistSongId = playlistSongId;
  }

  public PlaylistSong position(Integer position) {
    this.position = position;
    return this;
  }

  /**
   * possition in the PL
   * @return position
  */
  @ApiModelProperty(value = "possition in the PL")


  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public PlaylistSong playlist(Playlist playlist) {
    this.playlist = playlist;
    return this;
  }

  /**
   * Get playlist
   * @return playlist
  */
  @ApiModelProperty(value = "")

  @Valid

  public Playlist getPlaylist() {
    return playlist;
  }

  public void setPlaylist(Playlist playlist) {
    this.playlist = playlist;
  }

  public PlaylistSong song(Song song) {
    this.song = song;
    return this;
  }

  /**
   * Get song
   * @return song
  */
  @ApiModelProperty(value = "")

  @Valid

  public Song getSong() {
    return song;
  }

  public void setSong(Song song) {
    this.song = song;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlaylistSong playlistSong = (PlaylistSong) o;
    return Objects.equals(this.playlistSongId, playlistSong.playlistSongId) &&
        Objects.equals(this.position, playlistSong.position) &&
        Objects.equals(this.playlist, playlistSong.playlist) &&
        Objects.equals(this.song, playlistSong.song);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playlistSongId, position, playlist, song);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlaylistSong {\n");
    
    sb.append("    playlistSongId: ").append(toIndentedString(playlistSongId)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    playlist: ").append(toIndentedString(playlist)).append("\n");
    sb.append("    song: ").append(toIndentedString(song)).append("\n");
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

