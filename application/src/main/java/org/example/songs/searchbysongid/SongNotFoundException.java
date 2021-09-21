package org.example.songs.searchbysongid;

public class SongNotFoundException extends Exception {

    private static final String message = "The song with %d has not been found";

    public SongNotFoundException(Long id) {
        super(String.format(message, id));
    }
}
