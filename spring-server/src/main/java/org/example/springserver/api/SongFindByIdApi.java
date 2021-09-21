package org.example.springserver.api;

import org.example.songs.Song;
import org.example.songs.searchbysongid.SongFindByIdService;
import org.example.songs.searchbysongid.SongNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongFindByIdApi implements SongApi {

    private final SongFindByIdService songFindByIdService;

    public SongFindByIdApi(SongFindByIdService songFindByIdService) {
        this.songFindByIdService = songFindByIdService;
    }

    @GetMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteSong(@PathVariable(name = "id") Long id) {
        try {
            Song song = songFindByIdService.findByIdSong(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(song);
        } catch (SongNotFoundException songNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(songNotFoundException.getMessage());
        }
    }
}
