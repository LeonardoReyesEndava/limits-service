package com.spike.endava.limitsservice.refresh;

import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RefreshJob {

  @Autowired
  private Environment environment;

  @Scheduled(cron = "0 */1 * * * *")
  public void refreshProperties() throws URISyntaxException, UnknownHostException {
    System.out.println("executing refresh job");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    String host = InetAddress.getLocalHost().getHostAddress();
    String port = environment.getProperty("local.server.port");
    URI url = new URI("http://" + host + ":" + port + "/actuator/refresh");
    new HttpEntity<>(headers);
    ResponseEntity<String> responseEntity = new RestTemplate().postForEntity
        (url, new HttpEntity<>(headers), String.class);

    System.out.println("Properties refresh complete");
    System.out.println(responseEntity.getBody());
  }

}
