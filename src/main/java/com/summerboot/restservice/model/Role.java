package com.summerboot.restservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_role")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Role {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @Column(name = "roleName", length = 32)
    private String roleName;

    @Column(name = "roleDesc", columnDefinition = "varchar(256) default null comment '角色描述'")
    private String roleDesc;
}
