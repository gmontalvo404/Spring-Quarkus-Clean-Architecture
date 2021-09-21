package org.example.songs.searchbysongid;

import org.example.songs.Song;

public interface SongFindByIdService {

    Song findByIdSong(Long id) throws SongNotFoundException;
}
