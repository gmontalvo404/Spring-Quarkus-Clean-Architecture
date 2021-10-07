package org.example.springserver.api;

import org.example.songs.create.SongCreateRequest;
import org.example.songs.create.SongCreateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class SongCreateApi implements SongApi {

    private final SongCreateService songCreateService;

    public SongCreateApi(SongCreateService songCreateService) {
        this.songCreateService = songCreateService;
    }

    @Transactional
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createSong(@RequestBody SongCreateRequest songCreateRequest) {
        songCreateService.createSong(songCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Song has been created.");
    }
}
