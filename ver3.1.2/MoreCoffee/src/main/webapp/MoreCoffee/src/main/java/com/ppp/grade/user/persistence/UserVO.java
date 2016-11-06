package com.ppp.grade.user.persistence;

public class UserVO {
   private String 학번;
   private String 이름;
   private String 패스워드;
   private String 주전공;
   private String 복수전공;
    
   public String get학번() {
      return 학번;
   }

   public void set학번(String 학번) {
      this.학번 = 학번;
   }

   public String get이름() {
      return 이름;
   }

   public void set이름(String 이름) {
      this.이름 = 이름;
   }

   public String get패스워드() {
      return 패스워드;
   }

   public void set패스워드(String 패스워드) {
      this.패스워드 = 패스워드;
   }

   public String get주전공() {
      return 주전공;
   }

   public void set주전공(String 주전공) {
      this.주전공 = 주전공;
   }

   public String get복수전공() {
      return 복수전공;
   }

   public void set복수전공(String 복수전공) {
      this.복수전공 = 복수전공;
   }

   @Override
   public String toString(){
      return "UserVO [학번은 " + 학번 + ", 이름 = " + 이름 + ", 패스워드 = " + 패스워드 + ", 주전공 = " + 주전공 + ", 복수전공 = " + 복수전공 + "]";
   }
   
}
