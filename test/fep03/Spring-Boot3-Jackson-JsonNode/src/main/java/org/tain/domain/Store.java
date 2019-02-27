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
public class Store {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	
	@Column
	private Integer fld011;   // 전문길이
	@Column
	private String  fld012;   // 점포코드
	@Column
	private String  fld013;   // 포스번호
	@Column
	private Integer fld014;   // 거래번호
	@Column
	private String  fld015;   // 영업일자
	@Column
	private String  fld016;   // 시스템일자
	@Column
	private String  fld017;   // 시스템시각
	@Column
	private String  fld018;   // 거래구분
	@Column
	private String  fld019;   // 거래종별
	@Column
	private String  fld020;   // 책임자번호
	
	@Column
	private String  fld021;   // 원거래일자
	@Column
	private String  fld022;   // 원포스번호
	@Column
	private String  fld023;   // 원거래번호
	@Column
	private String  fld024;   // 원책임자번호
	@Column
	private String  fld025;   // 원시스템일자
	@Column
	private Integer fld026;   // 총매출
	@Column
	private Integer fld027;   // 순매출
	@Column
	private Integer fld028;   // 과세대상물품가액
	@Column
	private Integer fld029;   // 총POS할인금액
	@Column
	private Integer fld030;   // 총M&M할인금액
	
	@Column
	private Integer fld031;   // 총쿠폰할인금액
	@Column
	private String  fld032;   // 객층코드
	@Column
	private Integer fld033;   // 책임자정산차수
	@Column
	private String  fld034;   // 현금구분
	@Column
	private String  fld035;   // 쿠폰구분
	@Column
	private String  fld036;   // 상품권구분
	@Column
	private String  fld037;   // 신용카드구분
	@Column
	private String  fld038;   // 맴버쉽카드구분
	@Column
	private String  fld039;   // 맴버쉽카드번호
	@Column
	private String  fld040;   // 핸드폰결제구분
	
	@Column
	private String  fld041;   // 기타결제구분
	@Column
	private String  fld042;   // 택배서비스구분
	@Column
	private String  fld043;   // 연습모드구분

	@Builder
	public Store(
			Integer fld011,
			String  fld012,
			String  fld013,
			Integer fld014,
			String  fld015,
			String  fld016,
			String  fld017,
			String  fld018,
			String  fld019,
			String  fld020,

			String  fld021,
			String  fld022,
			String  fld023,
			String  fld024,
			String  fld025,
			Integer fld026,
			Integer fld027,
			Integer fld028,
			Integer fld029,
			Integer fld030,

			Integer fld031,
			String  fld032,
			Integer fld033,
			String  fld034,
			String  fld035,
			String  fld036,
			String  fld037,
			String  fld038,
			String  fld039,
			String  fld040,
			
			String  fld041,
			String  fld042,
			String  fld043) {
		this.fld011 = fld011;
		this.fld012 = fld012;
		this.fld013 = fld013;
		this.fld014 = fld014;
		this.fld015 = fld015;
		this.fld016 = fld016;
		this.fld017 = fld017;
		this.fld018 = fld018;
		this.fld019 = fld019;
		this.fld020 = fld020;
		
		this.fld021 = fld021;
		this.fld022 = fld022;
		this.fld023 = fld023;
		this.fld024 = fld024;
		this.fld025 = fld025;
		this.fld026 = fld026;
		this.fld027 = fld027;
		this.fld028 = fld028;
		this.fld029 = fld029;
		this.fld030 = fld030;
		
		this.fld031 = fld031;
		this.fld032 = fld032;
		this.fld033 = fld033;
		this.fld034 = fld034;
		this.fld035 = fld035;
		this.fld036 = fld036;
		this.fld037 = fld037;
		this.fld038 = fld038;
		this.fld039 = fld039;
		this.fld040 = fld040;
		
		this.fld041 = fld041;
		this.fld042 = fld042;
		this.fld043 = fld043;
	}
}
