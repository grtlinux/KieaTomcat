package org.tain.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.tain.domain.Item01;
import org.tain.domain.Item23;
import org.tain.domain.Mast;
import org.tain.domain.Store;
import org.tain.repository.Item01Repository;
import org.tain.repository.Item23Repository;
import org.tain.repository.MastRepository;
import org.tain.repository.StoreRepository;
import org.tain.utils.ClassUtil;

@Component(value = "data.CreateMastStoreItem01Item23Data")
public class CreateMastStoreItem01Item23Data {

	private static final boolean flag = true;

	@Autowired
	private MastRepository mastRepository;

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private Item01Repository item01Repository;

	@Autowired
	private Item23Repository item23Repository;

	public CreateMastStoreItem01Item23Data() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());
	}
	
	@Bean(value = "data.CreateMastStoreItem01Item23Data.create")
	@SuppressWarnings("unused")
	public void create() {
		if (flag) System.out.println(">>>>> " + ClassUtil.getClassInfo());

		Mast mast = this.mastRepository.save(
				Mast.builder()
					.fld001(990)
					.fld002("SH")
					.fld003("Q")
					.fld004(2)
					.fld005(9)
					.fld006(50)
					.fld007("2019/02/22")
					.fld008(123)
					.fld009(3333)
					.fld010("0000")
					.build()
		);

		Store store = this.storeRepository.save(
				Store.builder()
					.fld011(940)
					.fld012("05")
					.fld013("123")
					.fld014(1234)
					.fld015("2019/02/22")
					.fld016("2019/02/22")
					.fld017("12:12:12")
					.fld018("5")
					.fld019("11")
					.fld020("005")

					.fld021("2019/02/22")
					.fld022("005")
					.fld023("345")
					.fld024("0051")
					.fld025("2019/02/22")
					.fld026(99000)
					.fld027(99000)
					.fld028(9000)
					.fld029(0)
					.fld030(0)

					.fld031(0)
					.fld032("5")
					.fld033(4)
					.fld034("0")
					.fld035("0")
					.fld036("0")
					.fld037("0")
					.fld038("0")
					.fld039("1234567")
					.fld040("0")

					.fld041("0")
					.fld042("0")
					.fld043("0")
					.build()
		);

		Item01 item01 = this.item01Repository.save(
				Item01.builder()
					.fld044("01")
					.fld045(123)
					.fld046(1)
					.fld047("0")
					.fld048(10203040L)
					.fld049("GOODCODE")
					.fld050("BOTTLE")

					.fld051("BUN-CODE")
					.fld052(123000)
					.fld053(3)
					.fld054(12300)
					.fld055(20300)
					.fld056(123400)
					.fld057("TEX")
					.fld058(11)
					.fld059(23)
					.fld060("COM-CODE")

					.fld061("HANG-GUBUN")
					.fld062("HANG-CODE")
					.fld063(123000)
					.fld064("12345")
					.fld065(23400)
					.fld066("G3637")
					.fld067(320)
					.fld068("DC")
					.fld069(0)
					.fld070(0)

					.fld071("0")
					.fld072(0)
					.fld073(0)
					.fld074("1")
					.fld075(10)
					.fld076(120)
					.fld077(3200)
					.fld078("0")
					.fld079(12)
					.fld080(132400)

					.fld081(12300)
					.fld082("")
					.build()
		);

		Item23 item23 = this.item23Repository.save(
				Item23.builder()
					.fld083("23")
					.fld084(123)
					.fld085("VAN")
					.fld086(998760)
					.fld087("123-345")
					.fld088("12/23")
					.fld089("password")
					.fld090(12)

					.fld091(1230000)
					.fld092(23000)
					.fld093("12300")
					.fld094("WCC")
					.fld095("DONT NO")
					.fld096("2019/02/22")
					.fld097("12:12:12")
					.fld098("1234")
					.fld099("롯데마트")
					.fld100("05")

					.fld101("롯데마트2")
					.fld102("123")
					.fld103(0)
					.fld104("00")
					.fld105("KEY1")
					.fld106("KEY2")
					.fld107("")
					.build()
		);
	}
}
