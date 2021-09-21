package org.example.springserver.api;

import org.example.songs.delete.SongDeleteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongDeleteApi implements SongApi {

    private final SongDeleteService songDeleteService;

    public SongDeleteApi(SongDeleteService songDeleteService) {
        this.songDeleteService = songDeleteService;
    }

    @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteSong(@PathVariable(name = "id") Long id) {
        songDeleteService.deleteSong(id);
        return ResponseEntity.noContent().build();
    }
}
