package com.ppp.grade.subject.persistence;

public class SubjectVO {
   private String 과목코드;
   private String 과목명;
   private String 구분;
   private String 학점;
   private String 학년;
   private String 학기;
   private String 학과코드;
   

   public String get과목코드() {
	return 과목코드;
}


public void set과목코드(String 과목코드) {
	this.과목코드 = 과목코드;
}


public String get과목명() {
	return 과목명;
}


public void set과목명(String 과목명) {
	this.과목명 = 과목명;
}


public String get구분() {
	return 구분;
}


public void set구분(String 구분) {
	this.구분 = 구분;
}


public String get학점() {
	return 학점;
}


public void set학점(String 학점) {
	this.학점 = 학점;
}


public String get학년() {
	return 학년;
}


public void set학년(String 학년) {
	this.학년 = 학년;
}


public String get학기() {
	return 학기;
}


public void set학기(String 학기) {
	this.학기 = 학기;
}


public String get학과코드() {
	return 학과코드;
}


public void set학과코드(String 학과코드) {
	this.학과코드 = 학과코드;
}


@Override
   public String toString(){
      return "SubjectVO [ 과목코드는+" + 과목코드 + ", 과목명 = " + 과목명 + ", 구분= " + 구분+ ", 학점= " + 학점+ ", 학년= " + 학년+ ", 학기= " + 학기+ ", 학과코드= " + 학과코드+ "]";
   }
   
}