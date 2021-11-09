package cars;


import cars.Car;
import cars.Engine;
import cars.services.DAO;

import cars.services.ServiceForDiesel;
import cars.services.ServiceForPetrol;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Controller

public class Controller {

    private ServiceForDiesel serviceForDiesel;
    private ServiceForPetrol serviceForPetrol;
    private DAO dao;

    @Autowired
    public Controller(ServiceForDiesel serviceForDiesel, ServiceForPetrol serviceForPetrol, DAO dao  )
    {
        this.serviceForDiesel = serviceForDiesel;
        this.serviceForPetrol = serviceForPetrol;
        this.dao = dao;
    }



    @RequestMapping(value = {"/create"} , method = RequestMethod.GET)
    public String createOpen(@ModelAttribute Car car)  {


        return "create";

    }

    @PostMapping ("/")
    public String create(@ModelAttribute Car car)  {
        System.out.println(car.toString());
         DAO.newCar(car);
        return "create";

    }
    @RequestMapping(value = { "/index" , "/"}, method = RequestMethod.GET)
    public String index(Model model){
        ArrayList<Car> cars = new ArrayList<>(DAO.loadAllData(cars.Car.class));
        cars.stream().forEach(e -> System.out.println(e.toString()));
        model.addAttribute("cars", cars);
      return "index";
    }

   // @GetMapping(value = "/fuel/check/")
   // public ResponseEntity<List<Car>> checkFuel(@RequestParam String type) throws Exception {
       // try {
      //      if (Engine.powerUp(type) == false) { throw new Exception(); }
      //  } catch (Exception ex) {
      //      throw new Exception("This type of engine is incorrect");
     //   }
  //  }
    }

