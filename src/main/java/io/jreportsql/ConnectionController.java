package io.jreportsql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class ConnectionController {


    private final ConnectionService connectionService;

    @Autowired
    public ConnectionController(final ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @GetMapping
    public String sayHello() {
        return connectionService.getStr();
    }
}
