package org.example.api;

import org.example.songs.Song;
import org.example.songs.searchbysongid.SongFindByIdService;
import org.example.songs.searchbysongid.SongNotFoundException;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status;
import static javax.ws.rs.core.Response.status;

@Path("/songs")
public class SongFindByIdApi {

    private final SongFindByIdService songFindByIdService;

    public SongFindByIdApi(SongFindByIdService songFindByIdService) {
        this.songFindByIdService = songFindByIdService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteSong(@PathParam(value = "id") Long id) {
        try {
            Song song = songFindByIdService.findByIdSong(id);
            return status(Status.OK)
                    .entity(song)
                    .build();
        } catch (SongNotFoundException songNotFoundException) {
            return status(Status.NOT_FOUND)
                    .entity(songNotFoundException.getMessage())
                    .build();
        }
    }
}
