package ConstructABetterSociety.controller;

import ConstructABetterSociety.domain.*;
import ConstructABetterSociety.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InitController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PlaceRepository placeRepository;


    @CrossOrigin
    @RequestMapping("/load-data")
    public @ResponseBody
    String loadData(Model model) {
        if(countryRepository.findOne((long)1) != null){
           return "";
        }
        loadUsers();
        loadCountries();
        loadStates();
        loadCities();
        loadPlaces();
        
        return "";
    }

    private void loadCountries() {
        Country c = new Country("Spain");
        countryRepository.save(c);
    }

    private void loadStates() {
        State l = new State(countryRepository.findByNameEquals("Spain"), "Lleida");
        State b = new State(countryRepository.findByNameEquals("Spain"), "Barcelona");
        stateRepository.save(l);
        stateRepository.save(b);
    }

    private void loadCities() {
        City l = new City(stateRepository.findByNameEquals("Lleida"), "Lleida");
        City b = new City(stateRepository.findByNameEquals("Barcelona"), "Barcelona");
        cityRepository.save(l);
        cityRepository.save(b);
    }

    private void loadPlaces() {
        Place university = new Place(cityRepository.findByNameEquals("Lleida"),
                "UdL",
                "University of Lleida",
                41.608694, 0.624263);

        Place bar = new Place(cityRepository.findByNameEquals("Lleida"),
                "Tagliatella",
                "Italian Restaurant",
                41.620135, 0.618347);

        placeRepository.save(university);
        placeRepository.save(bar);
    }

    private void loadUsers() {
        User g = new User("Guillem96",
                "1234",
                "guillem.orellana@gmail.com",
                "Guillem", "Surname",
                0, 0, 10);

        User j = new User("Isomorfisme",
                "1234",
                "joel@gmail.com",
                "Joel", "Surname",
                0, 0, 10);

        User a = new User("AlbaUser",
                "1234",
                "alba@gmail.com",
                "Alba", "Surname",
                0, 0, 10);

        User m = new User("mrg20",
                "1234",
                "marc@gmail.com",
                "Marc", "Surname",
                0, 0, 10);

        userRepository.save(g);
        userRepository.save(m);
        userRepository.save(j);
        userRepository.save(a);
    }
}
