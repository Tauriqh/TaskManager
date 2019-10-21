package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.ac.cput.exception.RecordNotFoundException;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class homeController {


    @RequestMapping
    public String showHome(Model model){
        return "homeView";
    }
}

