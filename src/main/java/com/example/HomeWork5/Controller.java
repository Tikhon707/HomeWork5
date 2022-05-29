package com.example.HomeWork5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
public class Controller {

    @Autowired
    private ListRepository businessListRepository;

    @GetMapping("/GetAll")
    private ArrayList<BusinessListJson> getAllLists(){
        ArrayList<BusinessList> busLists = (ArrayList<BusinessList>) businessListRepository.findAll();
        var lists = new ArrayList<BusinessListJson>();
        busLists.stream().forEach( l -> {
            lists.add(new BusinessListJson(l.getName(), l.getTasks().stream()
                    .map(t -> t.getTask())
                    .collect(Collectors.toList())));
        });
        return lists;
    }

    @PostMapping("/insert")
    private void insert(@RequestBody BusinessListJson busList)
    {
        BusinessList list = new BusinessList();
        ArrayList<Task> tasks = new ArrayList<>();
        busList.events.forEach( t -> {
            Task task = new Task();
            task.setTask(t);
            task.setBList(list);
            tasks.add(task);
        });
        list.setTasks(tasks);
        list.setName(busList.getName());
        businessListRepository.save(list);
    }
}
