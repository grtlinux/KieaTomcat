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
public class Mast {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	
	@Column
	private Integer fld001;   // 전문길이
	@Column
	private String  fld002;   // 전문경로
	@Column
	private String  fld003;   // 전문구분
	@Column
	private Integer fld004;   // 전문종별
	@Column
	private Integer fld005;   // 전문순번
	@Column
	private Integer fld006;   // 점포번호
	@Column
	private String  fld007;   // 영업일자
	@Column
	private Integer fld008;   // 포스번호
	@Column
	private Integer fld009;   // 거래번호
	@Column
	private String  fld010;   // 에러코드
	
	@Builder
	public Mast(
			Integer fld001,
			String  fld002,
			String  fld003,
			Integer fld004,
			Integer fld005,
			Integer fld006,
			String  fld007,
			Integer fld008,
			Integer fld009,
			String  fld010) {
		this.fld001 = fld001;
		this.fld002 = fld002;
		this.fld003 = fld003;
		this.fld004 = fld004;
		this.fld005 = fld005;
		this.fld006 = fld006;
		this.fld007 = fld007;
		this.fld008 = fld008;
		this.fld009 = fld009;
		this.fld010 = fld010;
	}
}
