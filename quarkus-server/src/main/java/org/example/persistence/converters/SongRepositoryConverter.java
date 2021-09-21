package org.example.persistence.converters;

import org.example.RepositoryConverter;
import org.example.persistence.entities.SongEntity;
import org.example.songs.Song;

import java.util.Objects;

public class SongRepositoryConverter implements RepositoryConverter<SongEntity, Song> {

    @Override
    public SongEntity mapToTable(Song persistenceObject) {
        if(Objects.isNull(persistenceObject)) {
            return null;
        }

        return new SongEntity(persistenceObject.getId(), persistenceObject.getName(), persistenceObject.getDuration(),
                persistenceObject.getAvailable(), persistenceObject.getPublicationDate());
    }

    @Override
    public Song mapToEntity(SongEntity tableObject) {
        if(Objects.isNull(tableObject)) {
            return null;
        }

        return new Song(tableObject.getId(), tableObject.getName(), tableObject.getDuration(),
                tableObject.getAvailable(), tableObject.getPublicationDate());
    }
}
