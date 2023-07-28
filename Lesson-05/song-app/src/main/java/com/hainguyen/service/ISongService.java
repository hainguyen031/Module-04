package com.hainguyen.service;

import com.hainguyen.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(int id);

    void remove(int id);
}
