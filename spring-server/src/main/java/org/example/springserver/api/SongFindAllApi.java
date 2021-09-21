package org.example.springserver.api;

import org.example.songs.Song;
import org.example.songs.searchall.SongFindAllRequest;
import org.example.songs.searchall.SongFindAllService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongFindAllApi implements SongApi {

    private final SongFindAllService songFindAllService;

    public SongFindAllApi(SongFindAllService songFindAllService) {
        this.songFindAllService = songFindAllService;
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity songFindAll(@RequestParam(defaultValue = "0") Integer page,
                                     @RequestParam(defaultValue = "5") Integer size) {
        SongFindAllRequest songFindAllRequest = new SongFindAllRequest(page, size);
        List<Song> songs = songFindAllService.findAllSongs(songFindAllRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(songs);
    }
}