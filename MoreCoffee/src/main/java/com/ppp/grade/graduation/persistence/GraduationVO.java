package com.ppp.grade.graduation.persistence;

public class GraduationVO {
	String 학과코드;
	String 입학년도;
	String 전공심화;
	String 전공학점;
	String 학과기초;
	String 일반교양;
	String 필수교양;
	String 복수전공학점;
	String 봉사시간;
	String 봉사교육;
	public String get학과코드() {
		return 학과코드;
	}

	public void set학과코드(String 학과코드) {
		this.학과코드 = 학과코드;
	}

	public String get입학년도() {
		return 입학년도;
	}

	public void set입학년도(String 입학년도) {
		this.입학년도 = 입학년도;
	}

	public String get전공심화() {
		return 전공심화;
	}

	public void set전공심화(String 전공심화) {
		this.전공심화 = 전공심화;
	}
	
	public String get전공학점() {
		return 전공학점;
	}

	public void set전공학점(String 전공학점) {
		this.전공학점 = 전공학점;
	}

	public String get학과기초() {
		return 학과기초;
	}

	public void set학과기초(String 학과기초) {
		this.학과기초 = 학과기초;
	}

	public String get일반교양() {
		return 일반교양;
	}

	public void set일반교양(String 일반교양) {
		this.일반교양 = 일반교양;
	}

	public String get필수교양() {
		return 필수교양;
	}

	public void set필수교양(String 필수교양) {
		this.필수교양 = 필수교양;
	}

	public String get복수전공학점() {
		return 복수전공학점;
	}

	public void set복수전공학점(String 복수전공학점) {
		this.복수전공학점 = 복수전공학점;
	}

	public String get봉사시간() {
		return 봉사시간;
	}

	public void set봉사시간(String 봉사시간) {
		this.봉사시간 = 봉사시간;
	}

	public String get봉사교육() {
		return 봉사교육;
	}

	public void set봉사교육(String 봉사교육) {
		this.봉사교육 = 봉사교육;
	}

	public String get심폐교육() {
		return 심폐교육;
	}

	public void set심폐교육(String 심폐교육) {
		this.심폐교육 = 심폐교육;
	}

	String 심폐교육;

	@Override
	public String toString() {
		return "SubjectVO [ 학과코드:" + 학과코드 + ",입학년도:" + 입학년도 + ",전공심화:" + 전공심화+ 
				",학과기초:" + 학과기초 + ",일반교양:" + 일반교양 + ",필수교양:" + 필수교양 + ",복수전공학점:" + 복수전공학점 + 
				",봉사시간:" + 봉사시간 + ",봉사교육:" + 봉사교육 + ",심폐교육:" + 심폐교육  + "]";
		
	}

}