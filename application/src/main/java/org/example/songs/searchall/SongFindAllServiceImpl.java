package org.example.songs.searchall;

import org.example.songs.Song;
import org.example.songs.SongService;

import java.util.List;

public class SongFindAllServiceImpl implements SongFindAllService {
    private final SongService songService;

    public SongFindAllServiceImpl(SongService songService) {
        this.songService = songService;
    }

    @Override
    public List<Song> findAllSongs(SongFindAllRequest songFindAllRequest) {
        int page = songFindAllRequest.getPage();
        int size = songFindAllRequest.getSize();
        return songService.findAllSongs(page, size);
    }
}
