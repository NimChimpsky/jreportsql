package io.jreportsql.connections;

public class ConnectionDTO {
    private final String username;
    private final String password;
    private final String url;

    public ConnectionDTO(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
