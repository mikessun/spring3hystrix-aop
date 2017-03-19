package demo.spring.hystrix.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import demo.spring.hystrix.SpringExistingClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class HystrixController {

    @Autowired
    private SpringExistingClient client;

    @RequestMapping(value = "/withHystrix", method = RequestMethod.GET)
    public ResponseEntity withHystrix() throws InterruptedException {
        String resutl = client.invokeRemoteServiceWithHystrix();
        JsonNode jsonNode = new TextNode(resutl);
        ResponseEntity rs = new ResponseEntity(jsonNode, HttpStatus.OK);

        log.info("response: {}", rs);
        return rs;
    }

    @RequestMapping("/withOutHystrix")
    public String withOutHystrix() throws InterruptedException {
        return client.invokeRemoteServiceWithOutHystrix();
    }
}
