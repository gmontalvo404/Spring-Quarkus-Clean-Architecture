package org.example.persistence.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.example.persistence.entities.SongEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SongRepository implements PanacheRepositoryBase<SongEntity, Long> {

}