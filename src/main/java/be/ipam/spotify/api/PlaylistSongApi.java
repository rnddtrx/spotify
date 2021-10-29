/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package be.ipam.spotify.api;

import java.math.BigDecimal;
import be.ipam.spotify.api.model.PlaylistSong;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Validated
@Api(value = "PlaylistSong", description = "the PlaylistSong API")
public interface PlaylistSongApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /api/v1/playlistSongs : Create the playlistsong
     * Create the playlistsong
     *
     * @param playlistSong song object (optional)
     * @return created (status code 201)
     */
    @ApiOperation(value = "Create the playlistsong", nickname = "createPlaylistSong", notes = "Create the playlistsong", tags={ "playlistSong", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "created") })
    @RequestMapping(value = "/api/v1/playlistSongs",
        consumes = { "application/xml", "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> createPlaylistSong(@ApiParam(value = "song object"  )  @Valid @RequestBody(required = false) PlaylistSong playlistSong) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /api/v1/playlistSongs/{playlistSongId} : Delete the playlistSong
     * Deletes the playlistsong
     *
     * @param playlistSongId album id (required)
     * @return successful operation (status code 204)
     *         or Given album ID doesn&#39;t exist (status code 404)
     */
    @ApiOperation(value = "Delete the playlistSong", nickname = "deletePlaylistSong", notes = "Deletes the playlistsong", tags={ "playlistSong", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "successful operation"),
        @ApiResponse(code = 404, message = "Given album ID doesn't exist") })
    @RequestMapping(value = "/api/v1/playlistSongs/{playlistSongId}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deletePlaylistSong(@ApiParam(value = "album id",required=true) @PathVariable("playlistSongId") BigDecimal playlistSongId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /api/v1/playlistSongs/{playlistSongId} : Returns the playlistsongs
     * Returns the playlistsong
     *
     * @param playlistSongId Playlistsong Identifier (required)
     * @return successful operation (status code 200)
     *         or Given playlist ID doesn&#39;t exist (status code 404)
     */
    @ApiOperation(value = "Returns the playlistsongs", nickname = "getPlaylistSongById", notes = "Returns the playlistsong", tags={ "playlistSong", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 404, message = "Given playlist ID doesn't exist") })
    @RequestMapping(value = "/api/v1/playlistSongs/{playlistSongId}",
        method = RequestMethod.GET)
    default ResponseEntity<Void> getPlaylistSongById(@ApiParam(value = "Playlistsong Identifier",required=true) @PathVariable("playlistSongId") Integer playlistSongId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /api/v1/playlistSongs/{playlistSongId} : Update the playlistSong
     * Update the playlistSong
     *
     * @param playlistSongId playlistSong id (required)
     * @param playlistSong playlistsong object (optional)
     * @return updated (status code 200)
     */
    @ApiOperation(value = "Update the playlistSong", nickname = "updatePlaylistSong", notes = "Update the playlistSong", tags={ "playlistSong", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "updated") })
    @RequestMapping(value = "/api/v1/playlistSongs/{playlistSongId}",
        consumes = { "application/xml", "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<Void> updatePlaylistSong(@ApiParam(value = "playlistSong id",required=true) @PathVariable("playlistSongId") BigDecimal playlistSongId,@ApiParam(value = "playlistsong object"  )  @Valid @RequestBody(required = false) PlaylistSong playlistSong) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
