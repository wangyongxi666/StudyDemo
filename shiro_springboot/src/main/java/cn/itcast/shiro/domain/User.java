package cn.itcast.shiro.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.crazycake.shiro.AuthCachePrincipal;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体类
 */
@Entity
@Table(name = "pe_user")
@Getter
@Setter
@ToString
// 实现 AuthCachePrincipal  将值存放到redis
public class User implements Serializable {
    private static final long serialVersionUID = 4297464181093070302L;
    /**
     * ID
     */
    @Id
    private String id;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="pe_user_role",joinColumns={@JoinColumn(name="user_id",referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="role_id",referencedColumnName="id")}
    )
    private Set<Role> roles = new HashSet<Role>();//用户与角色   多对多

    //指定存放到redis中的
//    @Override
//    public String getAuthCacheKey() {
//        return null;
//    }
}
