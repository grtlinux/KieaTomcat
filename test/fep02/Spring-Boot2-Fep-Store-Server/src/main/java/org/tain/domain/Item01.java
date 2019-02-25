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
public class Item01 {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;

	@Column
	private String  fld044;   // 아이템 헤더 ID
	@Column
	private Integer fld045;   // 아이템 길이
	@Column
	private Integer fld046;   // 아이템 순번
	@Column
	private String  fld047;   // 취소 구분
	@Column
	private Long    fld048;   // 단품 코드
	@Column
	private String  fld049;   // 상품 코드
	@Column
	private String  fld050;   // BOTTLE 구분

	@Column
	private String  fld051;   // 분류 코드
	@Column
	private Integer fld052;   // 원가
	@Column
	private Integer fld053;   // 수량
	@Column
	private Integer fld054;   // 단가
	@Column
	private Integer fld055;   // 비과세단가
	@Column
	private Integer fld056;   // 금액
	@Column
	private String  fld057;   // 세금 구분
	@Column
	private Integer fld058;   // 입수
	@Column
	private Integer fld059;   // 편수
	@Column
	private String  fld060;   // 협력업체 코드

	@Column
	private String  fld061;   // 행사 구분
	@Column
	private String  fld062;   // 행사 코드
	@Column
	private Integer fld063;   // 정상 단가
	@Column
	private String  fld064;   // 공병상품코드
	@Column
	private Integer fld065;   // 공병가
	@Column
	private String  fld066;   // 공박스상품코드
	@Column
	private Integer fld067;   // 공박스가
	@Column
	private String  fld068;   // 할인 구분
	@Column
	private Integer fld069;   // 할인 율
	@Column
	private Integer fld070;   // 할인 금액

	@Column
	private String  fld071;   // 맴버쉽카드 적용구분
	@Column
	private Integer fld072;   // 맴버쉽카드 적용률
	@Column
	private Integer fld073;   // 맴버쉽카드 적용금액
	@Column
	private String  fld074;   // 쿠폰 할인 구분
	@Column
	private Integer fld075;   // 쿠폰 할인 수량
	@Column
	private Integer fld076;   // 쿠폰 할인 금액
	@Column
	private Integer fld077;   // 쿠폰 점포 부담금
	@Column
	private String  fld078;   // M&M 할인 구분
	@Column
	private Integer fld079;   // M&M 할인 수량
	@Column
	private Integer fld080;   // M&M 할인 금액

	@Column
	private Integer fld081;   // M&M 점포 부담금
	@Column
	private String  fld082;   // filler

	@Builder
	public Item01(
			String  fld044,
			Integer fld045,
			Integer fld046,
			String  fld047,
			Long    fld048,
			String  fld049,
			String  fld050,

			String  fld051,
			Integer fld052,
			Integer fld053,
			Integer fld054,
			Integer fld055,
			Integer fld056,
			String  fld057,
			Integer fld058,
			Integer fld059,
			String  fld060,

			String  fld061,
			String  fld062,
			Integer fld063,
			String  fld064,
			Integer fld065,
			String  fld066,
			Integer fld067,
			String  fld068,
			Integer fld069,
			Integer fld070,

			String  fld071,
			Integer fld072,
			Integer fld073,
			String  fld074,
			Integer fld075,
			Integer fld076,
			Integer fld077,
			String  fld078,
			Integer fld079,
			Integer fld080,

			Integer fld081,
			String  fld082) {
		this.fld044 = fld044;
		this.fld045 = fld045;
		this.fld046 = fld046;
		this.fld047 = fld047;
		this.fld048 = fld048;
		this.fld049 = fld049;
		this.fld050 = fld050;

		this.fld051 = fld051;
		this.fld052 = fld052;
		this.fld053 = fld053;
		this.fld054 = fld054;
		this.fld055 = fld055;
		this.fld056 = fld056;
		this.fld057 = fld057;
		this.fld058 = fld058;
		this.fld059 = fld059;
		this.fld060 = fld060;

		this.fld061 = fld061;
		this.fld062 = fld062;
		this.fld063 = fld063;
		this.fld064 = fld064;
		this.fld065 = fld065;
		this.fld066 = fld066;
		this.fld067 = fld067;
		this.fld068 = fld068;
		this.fld069 = fld069;
		this.fld070 = fld070;

		this.fld071 = fld071;
		this.fld072 = fld072;
		this.fld073 = fld073;
		this.fld074 = fld074;
		this.fld075 = fld075;
		this.fld076 = fld076;
		this.fld077 = fld077;
		this.fld078 = fld078;
		this.fld079 = fld079;
		this.fld080 = fld080;

		this.fld081 = fld081;
		this.fld082 = fld082;
	}
}
