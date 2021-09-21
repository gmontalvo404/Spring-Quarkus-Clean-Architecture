package org.example.songs.searchbysongid;

import org.example.songs.Song;
import org.example.songs.SongService;

import java.util.Objects;

public class SongFindByIdServiceImpl implements SongFindByIdService {
    private final SongService songService;

    public SongFindByIdServiceImpl(SongService songService) {
        this.songService = songService;
    }

    @Override
    public Song findByIdSong(Long id) throws SongNotFoundException {
        Song song = songService.findBySongId(id);
        if(Objects.isNull(song)) {
            throw new SongNotFoundException(id);
        }

        return song;
    }
}
