package org.example.songs.create;

import org.example.songs.Song;
import org.example.songs.SongService;

import java.time.LocalDate;

public class SongCreateServiceImpl implements SongCreateService {
    private final SongService songService;

    public SongCreateServiceImpl(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void createSong(SongCreateRequest songCreateRequest) {
        String name = songCreateRequest.getName();
        Long duration = getDuration(songCreateRequest.getMinutes(), songCreateRequest.getSeconds());
        Boolean available = songCreateRequest.getAvailable();
        LocalDate publicationDate = songCreateRequest.getPublicationDate();
        Song song = new Song(name, duration, available, publicationDate);

        songService.saveSong(song);
    }

    private Long getDuration(Long minutes, Long seconds) {
        return seconds + (minutes*60);
    }
}
