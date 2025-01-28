package userservice.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username; // 用户名

    @Column(nullable = false, length = 255)
    private String password; // 加密后的密码

    @Column(unique = true, length = 100)
    private String email; // 邮箱

    @Column(unique = true, length = 20)
    private String phone; // 手机号

    @Column(length = 50, columnDefinition = "varchar(50) default '用户'")
    private String nickname; // 用户昵称，默认值 '用户'

    @Column(length = 255)
    private String avatar; // 头像URL

    @Column(nullable = false, columnDefinition = "tinyint default 1")
    private Integer role; // 用户角色，1为普通用户，2为管理员

    @Column(nullable = false, columnDefinition = "tinyint default 1")
    private Integer status; // 账号状态，1为正常，0为禁用

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt; // 上次登录时间

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt; // 注册时间

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt; // 更新时间
}
