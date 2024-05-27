package com.qx.traffic.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

   private Integer uid;
   private String name;
   private String password="123456";
   private Integer sex=1;

   public User(String name, String password, Integer sex) {
      this.name = name;
      this.password = password;
      this.sex = sex;
   }
}
