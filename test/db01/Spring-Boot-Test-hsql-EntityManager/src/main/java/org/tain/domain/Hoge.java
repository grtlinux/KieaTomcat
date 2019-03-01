package org.tain.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hoge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int number;
	private String string;
	@Embedded
	private Fuga fuga;
	
	public Hoge() {}
	public Hoge(int number, String string, Fuga fuga) {
		this.number = number;
		this.string = string;
		this.fuga = fuga;
	}
	
	@Override
	public String toString() {
		return "Hoge [id=" + this.id + ", number=" + this.number + ", string=" + this.string + ", fuga=" + this.fuga + "]";
	}
}
