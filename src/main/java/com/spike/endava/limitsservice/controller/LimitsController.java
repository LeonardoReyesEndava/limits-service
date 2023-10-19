package com.spike.endava.limitsservice.controller;

import com.spike.endava.limitsservice.bean.Limits;
import com.spike.endava.limitsservice.configuration.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class LimitsController {

  @Autowired
  private Configuration configuration;

  @GetMapping("/limits")
  public Limits retrieveLimits() {
    return new Limits(configuration.getMinimum(),
        configuration.getMaximum());
//		return new Limits(1,1000);
  }

}
