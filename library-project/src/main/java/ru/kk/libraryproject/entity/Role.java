package ru.kk.libraryproject.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "user_roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "role_name")
    private String name;
    public enum Values {
        ADMIN(1L),
        USER(2L),
        MANAGER(3L);
        long roleId;
        Values(long roleId) {
            this.roleId = roleId;
        }
    }
}
