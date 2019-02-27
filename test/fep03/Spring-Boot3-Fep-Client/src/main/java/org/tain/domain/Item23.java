package org.tain.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Item23 {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;

	@Column
	private String  fld083;   // 아이템 헤더 ID
	@Column
	private Integer fld084;   // 아이템 길이
	@Column
	private String  fld085;   // 승인 VAN사
	@Column
	private Integer fld086;   // 전문일련번호
	@Column
	private String  fld087;   // 카드번호
	@Column
	private String  fld088;   // 유효기간
	@Column
	private String  fld089;   // 비밀번호
	@Column
	private Integer fld090;   // 할부개월

	@Column
	private Integer fld091;   // 매출액
	@Column
	private Integer fld092;   // 부가세
	@Column
	private String  fld093;   // 승인번호
	@Column
	private String  fld094;   // WCC
	@Column
	private String  fld095;   // 카드데이터
	@Column
	private String  fld096;   // 승인일자
	@Column
	private String  fld097;   // 승인시간
	@Column
	private String  fld098;   // 발급사코드
	@Column
	private String  fld099;   // 발급사명
	@Column
	private String  fld100;   // 매입사코드

	@Column
	private String  fld101;   // 매입사명
	@Column
	private String  fld102;   // 가맹점 코드
	@Column
	private Integer fld103;   // 카드잔액
	@Column
	private String  fld104;   // 카드종류
	@Column
	private String  fld105;   // 포스유니크키
	@Column
	private String  fld106;   // 벤사유니크키
	@Column
	private String  fld107;   // filler

	@Builder
	public Item23(
			String  fld083,
			Integer fld084,
			String  fld085,
			Integer fld086,
			String  fld087,
			String  fld088,
			String  fld089,
			Integer fld090,

			Integer fld091,
			Integer fld092,
			String  fld093,
			String  fld094,
			String  fld095,
			String  fld096,
			String  fld097,
			String  fld098,
			String  fld099,
			String  fld100,

			String  fld101,
			String  fld102,
			Integer fld103,
			String  fld104,
			String  fld105,
			String  fld106,
			String  fld107) {
		this.fld083 = fld083;
		this.fld084 = fld084;
		this.fld085 = fld085;
		this.fld086 = fld086;
		this.fld087 = fld087;
		this.fld088 = fld088;
		this.fld089 = fld089;
		this.fld090 = fld090;

		this.fld091 = fld091;
		this.fld092 = fld092;
		this.fld093 = fld093;
		this.fld094 = fld094;
		this.fld095 = fld095;
		this.fld096 = fld096;
		this.fld097 = fld097;
		this.fld098 = fld098;
		this.fld099 = fld099;
		this.fld100 = fld100;

		this.fld101 = fld101;
		this.fld102 = fld102;
		this.fld103 = fld103;
		this.fld104 = fld104;
		this.fld105 = fld105;
		this.fld106 = fld106;
		this.fld107 = fld107;
	}
}
