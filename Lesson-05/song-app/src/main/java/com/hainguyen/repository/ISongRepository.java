package com.hainguyen.repository;

import com.hainguyen.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();

    void save(Song song);

    Song findById(int id);

    void remove(int id);
}
