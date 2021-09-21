package org.example.springserver.config;

import org.example.songs.create.SongCreateServiceImpl;
import org.example.songs.delete.SongDeleteServiceImpl;
import org.example.songs.searchall.SongFindAllServiceImpl;
import org.example.songs.searchbysongid.SongFindByIdServiceImpl;
import org.example.springserver.persistence.converters.SongRepositoryConverter;
import org.example.springserver.persistence.repositories.SongRepository;
import org.example.springserver.persistence.services.SongServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SongConfiguration {

    private final SongRepository songRepository;

    public SongConfiguration(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Bean
    public SongRepositoryConverter songRepositoryConverter() {
        return new SongRepositoryConverter();
    }

    @Bean
    public SongServiceImpl songService() {
        return new SongServiceImpl(songRepository, songRepositoryConverter());
    }

    @Bean
    public SongCreateServiceImpl songCreateService() {
        return new SongCreateServiceImpl(songService());
    }

    @Bean
    public SongDeleteServiceImpl songDeleteService() {
        return new SongDeleteServiceImpl(songService());
    }

    @Bean
    public SongFindAllServiceImpl songFindAllService() {
        return new SongFindAllServiceImpl(songService());
    }

    @Bean
    public SongFindByIdServiceImpl songFindByIdService() {
        return new SongFindByIdServiceImpl(songService());
    }
}
