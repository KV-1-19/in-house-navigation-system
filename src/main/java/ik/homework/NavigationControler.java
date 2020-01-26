package ik.homework;

import ik.homework.domain.BaseStation;
import ik.homework.repos.BaseStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Controller
public class NavigationControler {
    @Autowired
    private BaseStationRepo baseStationRepo;

    @GetMapping("/homework")
    public String homework(
            @RequestParam(name = "name", required = false, defaultValue = "IN house navigation system") String name,
            Map<String, Object> model)
    {
        model.put("name", name);
        return "homework";
    }

    @GetMapping
    public String main(Map<String, Object> model){

        Iterable<BaseStation> baseStations =baseStationRepo.findAll();
        model.put("baseStations", baseStations);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name,
                      @RequestParam float x,
                      @RequestParam float y,
                      @RequestParam float detectionRadiusInMeters,Map<String, Object> model){

        BaseStation baseStation = new BaseStation(name, x, y, detectionRadiusInMeters);
        baseStationRepo.save(baseStation);

        Iterable<BaseStation> baseStations =baseStationRepo.findAll();
        model.put("baseStations", baseStations);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<BaseStation> baseStations;

        if (filter != null && !filter.isEmpty()){
            baseStations = baseStationRepo.findByName(filter);
        } else {
            baseStations = baseStationRepo.findAll();
        }

        model.put("baseStations", baseStations);

        return "main";
    }
}
