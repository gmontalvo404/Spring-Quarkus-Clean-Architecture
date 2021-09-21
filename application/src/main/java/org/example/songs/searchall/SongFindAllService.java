package org.example.songs.searchall;

import org.example.songs.Song;

import java.util.List;

public interface SongFindAllService {

    List<Song> findAllSongs(SongFindAllRequest songFindAllRequest);
}
