package org.example.api;

import org.example.songs.delete.SongDeleteService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/songs")
public class SongDeleteApi {

    private final SongDeleteService songDeleteService;

    public SongDeleteApi(SongDeleteService songDeleteService) {
        this.songDeleteService = songDeleteService;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteSong(@PathParam(value = "id") Long id) {
        songDeleteService.deleteSong(id);
        return Response.noContent().build();
    }
}
