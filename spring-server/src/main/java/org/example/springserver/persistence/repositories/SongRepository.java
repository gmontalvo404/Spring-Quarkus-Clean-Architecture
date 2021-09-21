package org.example.springserver.persistence.repositories;

import org.example.springserver.persistence.entities.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<SongEntity, Long> {

}
