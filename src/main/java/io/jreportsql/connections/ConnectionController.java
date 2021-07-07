package io.jreportsql.connections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public void createConnection(final ConnectionDTO connectionDTO) {
        if (connectionService.isValid(connectionDTO)) {
            connectionService.persist(connectionDTO);
        } else {
            throw new IllegalArgumentException("Can't open connection");
        }
    }

    @GetMapping
    public ConnectionDTO sayHello() {
        return new ConnectionDTO("chees", "pwd", "url");
    }
}
