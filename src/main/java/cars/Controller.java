package cars;


import cars.Car;
import cars.Engine;
import cars.services.DAO;
import cars.services.ServiceForDiesel;
import cars.services.ServiceForPetrol;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RestController

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

    @PostMapping(value = "/")
    public RedirectView create8(@ModelAttribute Car car)  {
        System.out.println(car.toString());
        DAO.newCar(car);
        return new RedirectView("/index.html");

    }

    @GetMapping(value = "/")
    public RedirectView hello(){
        return new RedirectView("/index.html");
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

