package org.example.persistence.services;

import io.quarkus.panache.common.Page;
import lombok.extern.slf4j.Slf4j;
import org.example.persistence.converters.SongRepositoryConverter;
import org.example.persistence.entities.SongEntity;
import org.example.persistence.repositories.SongRepository;
import org.example.songs.Song;
import org.example.songs.SongService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    private final SongRepositoryConverter songRepositoryConverter;

    public SongServiceImpl(SongRepository songRepository, SongRepositoryConverter songRepositoryConverter) {
        this.songRepository = songRepository;
        this.songRepositoryConverter = songRepositoryConverter;
    }

    @Override
    public void saveSong(Song song) {
        songRepository.persist(songRepositoryConverter.mapToTable(song));
    }

    @Override
    public List<Song> findAllSongs(int page, int size) {
        Page pageable = Page.of(page, size);
        return songRepository.findAll()
                .page(pageable)
                .stream()
                .map(songRepositoryConverter::mapToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Song findBySongId(Long id) {
        Optional<SongEntity> song = songRepository.findByIdOptional(id);
        SongEntity entity = song.orElse(null);
        return songRepositoryConverter.mapToEntity(entity);
    }

    @Override
    public void deleteSong(Long id) {
        try {
            songRepository.deleteById(id);
        } catch (Exception exception) {
            log.info(exception.getMessage());
        }
    }
}
