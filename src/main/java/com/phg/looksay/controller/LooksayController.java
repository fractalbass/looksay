package com.phg.looksay.controller;

import com.phg.looksay.service.LooksayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by milesporter on 5/13/16.
 */
@RestController
public class LooksayController {

    @Autowired
    LooksayService looksayService;

    @RequestMapping(value="/looksay/{startnum}/{rows}", method= RequestMethod.GET)
    public ArrayList<String> generateRows(@PathVariable int startnum, @PathVariable int rows) {
        if(rows<31) {
            return looksayService.generateLines(startnum, rows);
        }
        else {
                ArrayList<String> result = new ArrayList<String>();
                result.add("Please try and keep it to 30 or less on the rows.  This is a free Heroku dyno, after all!");
                return result;
            }
    }

    @RequestMapping(value="/message", method= RequestMethod.GET)
    public String getMessage() {
        return looksayService.getMessage();
    }
}
