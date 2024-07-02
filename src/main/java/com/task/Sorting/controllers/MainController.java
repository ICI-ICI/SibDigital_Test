package com.task.Sorting.controllers;

import com.task.Sorting.BubbleSort;
import com.task.Sorting.models.Tabl;
import com.task.Sorting.repository.TablRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@Controller
public class MainController {

    @Autowired
    private TablRepository tablRepository;
    long current_sort_number = 0;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "sorter");
        return "home";
    }
    @GetMapping("/{num}")
    public String getPastSort(@PathVariable(value = "num") long num, Model model) {
        ArrayList<Tabl> past_data_output = tablRepository.findSort(num);
        model.addAttribute("past_data_output", past_data_output);
        return "past";
    }

    @PostMapping("/")
    public String startSort(@RequestParam String data, @ModelAttribute("des_sort") String des_sort, Model model) {

        BubbleSort bubble = new BubbleSort(data);
        ArrayList<Float> sorted_data_input = bubble.sort(Objects.equals(des_sort, "on"));

        ArrayList X = tablRepository.findLastSort();
        if (X.size() >= 1)
            current_sort_number = (long) X.get(0);
        ++current_sort_number;

        //Saving to the db
        for (Float aFloat : sorted_data_input) {
            Tabl tabl = new Tabl(aFloat, current_sort_number);
            tablRepository.save(tabl);
        }

        //output current sorted data
        ArrayList<Tabl> sorted_data_output = tablRepository.findSort(current_sort_number);
        model.addAttribute("sorted_data_output", sorted_data_output);

        sorted_data_input.clear();

        return "home";
    }
}
