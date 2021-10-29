package be.ipam.spotify.api.model;

import java.util.Objects;
import be.ipam.spotify.api.model.Album;
import be.ipam.spotify.api.model.Artist;
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
 * A Song Class
 */
@ApiModel(description = "A Song Class")
@JacksonXmlRootElement(localName = "Song")
@XmlRootElement(name = "Song")
@XmlAccessorType(XmlAccessType.FIELD)
public class Song extends RepresentationModel<Song>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("songId")
  @JacksonXmlProperty(localName = "songId")
  private Long songId;

  @JsonProperty("name")
  @JacksonXmlProperty(localName = "name")
  private String name;

  @JsonProperty("artists")
  @JacksonXmlProperty(localName = "artists")
  @Valid
  private List<Artist> artists = null;

  @JsonProperty("album")
  @JacksonXmlProperty(localName = "album")
  private Album album;

  @JsonProperty("playlistSongs")
  @JacksonXmlProperty(localName = "playlistSongs")
  @Valid
  private List<PlaylistSong> playlistSongs = null;

  public Song songId(Long songId) {
    this.songId = songId;
    return this;
  }

  /**
   * id
   * @return songId
  */
  @ApiModelProperty(value = "id")


  public Long getSongId() {
    return songId;
  }

  public void setSongId(Long songId) {
    this.songId = songId;
  }

  public Song name(String name) {
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

  public Song artists(List<Artist> artists) {
    this.artists = artists;
    return this;
  }

  public Song addArtistsItem(Artist artistsItem) {
    if (this.artists == null) {
      this.artists = new ArrayList<>();
    }
    this.artists.add(artistsItem);
    return this;
  }

  /**
   * Collection of Song.
   * @return artists
  */
  @ApiModelProperty(value = "Collection of Song.")

  @Valid

  public List<Artist> getArtists() {
    return artists;
  }

  public void setArtists(List<Artist> artists) {
    this.artists = artists;
  }

  public Song album(Album album) {
    this.album = album;
    return this;
  }

  /**
   * Get album
   * @return album
  */
  @ApiModelProperty(value = "")

  @Valid

  public Album getAlbum() {
    return album;
  }

  public void setAlbum(Album album) {
    this.album = album;
  }

  public Song playlistSongs(List<PlaylistSong> playlistSongs) {
    this.playlistSongs = playlistSongs;
    return this;
  }

  public Song addPlaylistSongsItem(PlaylistSong playlistSongsItem) {
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
    Song song = (Song) o;
    return Objects.equals(this.songId, song.songId) &&
        Objects.equals(this.name, song.name) &&
        Objects.equals(this.artists, song.artists) &&
        Objects.equals(this.album, song.album) &&
        Objects.equals(this.playlistSongs, song.playlistSongs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(songId, name, artists, album, playlistSongs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Song {\n");
    
    sb.append("    songId: ").append(toIndentedString(songId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    artists: ").append(toIndentedString(artists)).append("\n");
    sb.append("    album: ").append(toIndentedString(album)).append("\n");
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

