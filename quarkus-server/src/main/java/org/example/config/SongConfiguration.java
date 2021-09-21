package org.example.config;

import org.example.persistence.converters.SongRepositoryConverter;
import org.example.persistence.repositories.SongRepository;
import org.example.persistence.services.SongServiceImpl;
import org.example.songs.create.SongCreateServiceImpl;
import org.example.songs.delete.SongDeleteServiceImpl;
import org.example.songs.searchall.SongFindAllServiceImpl;
import org.example.songs.searchbysongid.SongFindByIdServiceImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class SongConfiguration {

    @Inject
    SongRepository songRepository;

    @Produces
    @ApplicationScoped
    public SongRepositoryConverter songRepositoryConverter() {
        return new SongRepositoryConverter();
    }

    @Produces
    @ApplicationScoped
    public SongServiceImpl songService() {
        return new SongServiceImpl(songRepository, songRepositoryConverter());
    }

    @Produces
    @ApplicationScoped
    public SongCreateServiceImpl songCreateService() {
        return new SongCreateServiceImpl(songService());
    }

    @Produces
    @ApplicationScoped
    public SongDeleteServiceImpl songDeleteService() {
        return new SongDeleteServiceImpl(songService());
    }

    @Produces
    @ApplicationScoped
    public SongFindAllServiceImpl songFindAllService() {
        return new SongFindAllServiceImpl(songService());
    }

    @Produces
    @ApplicationScoped
    public SongFindByIdServiceImpl songFindByIdService() {
        return new SongFindByIdServiceImpl(songService());
    }
}
