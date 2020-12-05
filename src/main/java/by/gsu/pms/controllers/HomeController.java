package by.gsu.pms.controllers;

import by.gsu.pms.beans.Registration;
import by.gsu.pms.beans.FlightClass;
import by.gsu.pms.beans.User;
import by.gsu.pms.builders.ReportBuilder;
import by.gsu.pms.repos.RegistrationRepo;
import by.gsu.pms.repos.UserRepo;
import org.apache.commons.io.input.CharSequenceInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Map;

@Controller
@RequestMapping("/Home")
public class HomeController {
    private static User user;
    @Autowired
    private RegistrationRepo registrationRepo;
    @Autowired
    private UserRepo userRepo;
    @GetMapping
    public String home(Map<String, Object> model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
         user = userRepo.getFirstByUsername(userDetails.getUsername());
        Iterable<Registration> toDos = registrationRepo.getAllByUser(user);
        model.put("tickets", toDos);
        return "home";
    }

    @PostMapping
    public String add(@AuthenticationPrincipal User user,
                      Registration registration,
                      Map<String, Object> model){
        registration.setUser(user);
        registrationRepo.save(registration);
        return "redirect:/Home";
    }

    @PostMapping("/delete")
    public String delete(long id){
        registrationRepo.delete(registrationRepo.getFirstById(id));
        return "redirect:/Home";
    }

    @GetMapping("/Date")
    public String dateFilter(Date date, Map<String, Object> model){
        model.put("toDos", registrationRepo.getAllByUserAndDate(user,date));
        return "home";
    }

    @GetMapping("/Urgency")
    public String dateFilter(FlightClass flightClass, Map<String, Object> model){
        model.put("toDos", registrationRepo.getAllByUserAndFlightClass(user,flightClass));
        return "home";
    }

    @GetMapping(value = "/file")
    public void getFile(
            @RequestParam(name = "withClass") boolean withClass,
            @RequestParam(name = "withDates") boolean withDates,
            @RequestParam(name = "withNames") boolean withNames,
            @RequestParam(name = "withPassport") boolean withPassport,
            HttpServletResponse response) {
        ReportBuilder rb = new ReportBuilder(registrationRepo);

        Thread[] threads = new Thread[4];
        threads[0] = new Thread(() -> {
            if(withClass) rb.withClass();
        });
        threads[1] = new Thread(() -> {
            if(withDates) rb.withDates();
        });
        threads[2] = new Thread(() -> {
            if(withNames) rb.withNames();
        });
        threads[3] = new Thread(() -> {
            if(withPassport) rb.withPassport();
        });

        for (Thread t: threads) { // parallel execution of files processing
            t.start(); // method "start" executes method "run" (which was override before) in the other thread
        }

        for (Thread t: threads) {
            try {
                t.join(); // waiting for every Thread finishes
            } catch (InterruptedException e) {
                System.out.println("Threads failed :(");
            }
        }

        try {
            // get your file as InputStream
            InputStream is = new CharSequenceInputStream(rb.buildReportString(), "UTF-8");
            // copy it to response's OutputStream
            org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
            response.setContentType("text/csv;charset=utf-8");
            response.flushBuffer();
        } catch (IOException ex) {
            throw new RuntimeException("IOError writing file to output stream");
        }

    }
}
