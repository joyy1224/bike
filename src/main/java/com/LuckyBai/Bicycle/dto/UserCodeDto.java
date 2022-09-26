package com.LuckyBai.Bicycle.dto;

import com.LuckyBai.Bicycle.Entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCodeDto extends Users {
    private String Code;
}
