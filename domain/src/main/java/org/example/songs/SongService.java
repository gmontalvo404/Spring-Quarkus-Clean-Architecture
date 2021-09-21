package org.example.songs;

import java.util.List;

public interface SongService {
    void saveSong(Song song);
    List<Song> findAllSongs(int page, int size);
    Song findBySongId(Long id);
    void deleteSong(Long id);
}
