package com.example.demorectangles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demorectangles.models.Rectangle;
import com.example.demorectangles.models.RectangleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RectangleService {

    @Autowired
    private RectangleRepository repository;

    public List<Rectangle> findAll() {
        return repository.findAll();
    }

    public Optional<Rectangle> findById(Long id) {
        return repository.findById(id);
    }

    public Rectangle save(Rectangle rectangle) {
        return repository.save(rectangle);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
