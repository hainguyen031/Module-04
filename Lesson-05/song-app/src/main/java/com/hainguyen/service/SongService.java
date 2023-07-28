package com.hainguyen.service;

import com.hainguyen.model.Song;
import com.hainguyen.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> findAll() {
        return this.iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        this.iSongRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return this.iSongRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        this.iSongRepository.remove(id);
    }

}