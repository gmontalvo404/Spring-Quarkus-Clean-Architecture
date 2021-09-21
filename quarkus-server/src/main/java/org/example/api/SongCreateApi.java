package org.example.api;

import org.example.songs.create.SongCreateRequest;
import org.example.songs.create.SongCreateService;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/songs")
public class SongCreateApi {

    private final SongCreateService songCreateService;

    public SongCreateApi(SongCreateService songCreateService) {
        this.songCreateService = songCreateService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createSong(SongCreateRequest songCreateRequest) {
        songCreateService.createSong(songCreateRequest);
        return Response.status(Response.Status.CREATED)
                .entity("Song has been created.")
                .build();
    }
}
