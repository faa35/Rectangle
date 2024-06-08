package com.example.demorectangles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demorectangles.RectangleService;
import com.example.demorectangles.models.Rectangle;

import java.util.List;

@Controller
public class RectangleController {

    @Autowired
    private RectangleService service;

    @GetMapping("/")
    public String index(Model model) {
        List<Rectangle> rectangles = service.findAll();
        model.addAttribute("rectangles", rectangles);
        return "index";
    }

    @GetMapping("/rectangle/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Rectangle rectangle = service.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rectangle Id:" + id));
        model.addAttribute("rectangle", rectangle);
        return "detail";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("rectangle", new Rectangle());
        return "add";
    }

    @PostMapping("/add")
    public String addRectangle(@ModelAttribute Rectangle rectangle) {
        service.save(rectangle);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Rectangle rectangle = service.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rectangle Id:" + id));
        model.addAttribute("rectangle", rectangle);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editRectangle(@PathVariable Long id, @ModelAttribute Rectangle rectangle) {
        rectangle.setId(id);
        service.save(rectangle);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteRectangle(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/";
    }
}
