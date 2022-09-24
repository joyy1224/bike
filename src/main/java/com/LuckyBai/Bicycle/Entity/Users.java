package com.LuckyBai.Bicycle.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import reactor.util.annotation.Nullable;

import java.io.Serializable;

/**
 * 
 * @TableName users
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users implements Serializable {
    /**
     * 
     */
    private Integer userid;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String salt;
}