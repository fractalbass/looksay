package com.phg.looksay.controller;

import com.phg.looksay.service.LooksayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return looksayService.generateLines(startnum, rows);
    }

}