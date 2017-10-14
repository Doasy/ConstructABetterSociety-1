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
        loadComments();

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
                41.620135D, 0.618347D);

        Place gym = new Place(cityRepository.findByNameEquals("Barcelona"),
                "CrossfitUpc",
                "Enormous gym of upc",
                41.384921, 2.115955);

        Place upcNord = new Place(cityRepository.findByNameEquals("Barcelona"),
                "Tagliatella",
                "Italian Restaurant",
                41.3894599,2.1112294);

        Place mareNostrum = new Place(cityRepository.findByNameEquals("Barcelona"),
                "MareNostrum",
                "Big hardware",
                41.3893812,2.1160464);

        Place park = new Place(cityRepository.findByNameEquals("Barcelona"),
                "Car-park-MNAC",
                "Car park",
                41.368086, 2.151714);

        Place zoo = new Place(cityRepository.findByNameEquals("Barcelona"),
                "BCN-Zoo",
                "Have fun with animals.",
                41.386333, 2.189858);

        Place po = new Place(cityRepository.findByNameEquals("Barcelona"),
                "Port-Olimpic",
                "Olimpic port.",
                41.386333, 2.189858);

        Place cp = new Place(cityRepository.findByNameEquals("Barcelona"),
                "Parlament-de-Catalunya",
                "Where Puigdemont talks about Catalonia.",
                41.388130, 2.188983);


        Place sf = new Place(cityRepository.findByNameEquals("Barcelona"),
                "Sagrada-Familia",
                "Amazing.",
                41.403630, 2.174356);

        Place hp = new Place(cityRepository.findByNameEquals("Barcelona"),
                "Hospital-Plato",
                "Where nurses and a doctor have fun.",
                41.401326, 2.141991);

        Place tw = new Place(cityRepository.findByNameEquals("Barcelona"),
                "ThoughtWorks-Barcelona",
                "Best company.",
                41.402521,2.1921443);




        placeRepository.save(university);
        placeRepository.save(bar);
        placeRepository.save(gym);
        placeRepository.save(tw);
        placeRepository.save(sf);
        placeRepository.save(hp);
        placeRepository.save(cp);
        placeRepository.save(po);
        placeRepository.save(zoo);
        placeRepository.save(park);
        placeRepository.save(mareNostrum);
        placeRepository.save(mareNostrum);
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
                0, 0, 100);

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

    private void loadComments() {
        Comment comment = new Comment(placeRepository.findByNameEquals("UdL"),
                userRepository.findByEmail("joel@gmail.com"), "review", "Potatoman is here");

        Comment comment1 = new Comment(placeRepository.findByNameEquals("ThoughtWorks-Barcelona"),
                userRepository.findByEmail("joel@gmail.com"), "review", "Potatoman is here");

        commentRepository.save(comment);
        commentRepository.save(comment1);

    }
}
