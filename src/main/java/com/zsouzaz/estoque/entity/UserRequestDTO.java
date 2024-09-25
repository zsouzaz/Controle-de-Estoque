package com.zsouzaz.estoque.entity;

import java.util.List;

// Para receber o usuário E as permissões no POST é necessário fazer uma classe que os emcapsulem pois não é possível criar 2 POSTs no mesmo método HTTP.
public class UserRequestDTO {
    private User user;
    private List<Long> permissions;

    public UserRequestDTO(User user, List<Long> permissions) {
        this.user = user;
        this.permissions = permissions;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<Long> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<Long> permissions) {
        this.permissions = permissions;
    }
}
