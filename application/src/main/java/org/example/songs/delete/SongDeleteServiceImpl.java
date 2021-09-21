package org.example.songs.delete;

import org.example.songs.SongService;

public class SongDeleteServiceImpl implements SongDeleteService {
    private final SongService songService;

    public SongDeleteServiceImpl(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void deleteSong(Long id) {
        songService.deleteSong(id);
    }
}
