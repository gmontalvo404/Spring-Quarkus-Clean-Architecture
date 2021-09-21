package org.example.api;

import org.example.songs.Song;
import org.example.songs.searchall.SongFindAllRequest;
import org.example.songs.searchall.SongFindAllService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/songs")
public class SongFindAllApi {

    private final SongFindAllService songFindAllService;

    public SongFindAllApi(SongFindAllService songFindAllService) {
        this.songFindAllService = songFindAllService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response songFindAll(@QueryParam("page") @DefaultValue("0") int page,
                                @QueryParam("size") @DefaultValue("20") int size) {
        SongFindAllRequest songFindAllRequest = new SongFindAllRequest(page, size);
        List<Song> songs = songFindAllService.findAllSongs(songFindAllRequest);
        return Response.status(Response.Status.OK)
                .entity(songs)
                .build();
    }
}