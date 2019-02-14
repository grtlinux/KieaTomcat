package org.tain.example.json03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.tain.example.info.CardInfo;
import org.tain.example.info.DocInfo;
import org.tain.example.info.FieldInfo;
import org.tain.example.info.ItemInfo;
import org.tain.example.info.StoreInfo;
import org.tain.utils.ClassUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value = "example.json03.StreamJsonExample")
public class StreamJsonExample {

	private static final boolean flag = true;
	
	@Autowired
	private StreamJsonProperty streamJsonProperty;
	
	@Bean(value = "example.svr01.ServerExample.test01")
	public void test01() throws Exception {
		if (flag) {
			System.out.println(">>>>> " + ClassUtil.getClassInfo());
			System.out.println(">>>>> " + streamJsonProperty);
		}
		
		ObjectMapper mapper = new ObjectMapper();  // create once, reuse

		if (flag) {
			// json to object
			// DocInfo docInfo = mapper.readValue(new File("/Users/kangmac/STS_GIT/_DocInfo.json"), DocInfo.class);  // OK
			DocInfo docInfo = mapper.readValue(ResourceUtils.getFile("classpath:templates/_DocInfo.json"), DocInfo.class);
			System.out.println(">>>>> " + docInfo);
		}
		
		if (flag) {
			// 
			String strReqPacket = "000990SH0000000851501201901296001790000000095051501600179020190129201901291335000000900001.................................0000002250000002250000002250000000000000000000000000000070100010................000001218001000000880027980700120......0000001300001000001300000000000000001300000110073240..........000001300......000000000......000000000000000000000000000000000000000000000000000000000000000000000000000000000800000000001218002088011151344350701420......0000000950001000000950000000000000000950000110073240..........000000950......000000000......00000000000000000000000000000000000000000000000000000000000000000000000000000000080000000002334760000000533872..........KRKW................0000000225000000020552063467....A533872...............................2019012913350009..롯데마스터카드......09..롯데카드............9966089516.....000000000005150100000201901296001790.....0000000000000000000000000.....................................................................................";
			strReqPacket = strReqPacket.replace('.', ' ');
			byte[] byteReqPacket = strReqPacket.getBytes("EUC-KR");
			int offset = 0;

			// DocInfo docInfo = mapper.readValue(new File("/Users/kangmac/STS_GIT/_DocInfo.json"), DocInfo.class);  // OK
			DocInfo docInfo = mapper.readValue(ResourceUtils.getFile("classpath:templates/_DocInfo.json"), DocInfo.class); // OK
			System.out.println(">>>>> " + docInfo);

			for (FieldInfo info : docInfo.getFields()) {
				String strField = new String(byteReqPacket, offset, info.getLength());
				offset += info.getLength();
				
				// 필드 원본값 저장
				info.setFromValue(strField);
				// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
				info.setToValue(getToValue(info));
				
				String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(info);  // 이쁜 출력
				System.out.println(">>>>> " + jsonString);
			}

			StoreInfo storeInfo = mapper.readValue(ResourceUtils.getFile("classpath:templates/_StoreInfo.json"), StoreInfo.class);
			System.out.println(">>>>> " + storeInfo);
			
			for (FieldInfo info : storeInfo.getFields()) {
				String strField = new String(byteReqPacket, offset, info.getLength());
				offset += info.getLength();
				
				// 필드 원본값 저장
				info.setFromValue(strField);
				// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
				info.setToValue(getToValue(info));

				String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(info);  // 이쁜 출력
				System.out.println(">>>>> " + jsonString);
			}
			
			for (; offset < byteReqPacket.length;) {
				String id = new String(byteReqPacket, offset, 2);  // 구분자 ID
				if ("01".equals(id)) {
					// Item data
					ItemInfo itemInfo = mapper.readValue(ResourceUtils.getFile("classpath:templates/_ItemInfo.json"), ItemInfo.class);
					System.out.println(">>>>> " + itemInfo);
					
					for (FieldInfo info : itemInfo.getFields()) {
						String strField = new String(byteReqPacket, offset, info.getLength());
						offset += info.getLength();
						
						// 필드 원본값 저장
						info.setFromValue(strField);
						// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
						info.setToValue(getToValue(info));

						String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(info);  // 이쁜 출력
						System.out.println(">>>>> " + jsonString);
					}
				} else if ("23".equals(id)) {
					// card data
					CardInfo cardInfo = mapper.readValue(ResourceUtils.getFile("classpath:templates/_CardInfo.json"), CardInfo.class);
					System.out.println(">>>>> " + cardInfo);
					
					for (FieldInfo info : cardInfo.getFields()) {
						String strField = new String(byteReqPacket, offset, info.getLength(), "EUC-KR");
						offset += info.getLength();
						
						// 필드 원본값 저장
						info.setFromValue(strField);
						// 필드타입에 따른 변경(string/integer/date/time) 값을 저장
						info.setToValue(getToValue(info));

						String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(info);  // 이쁜 출력
						System.out.println(">>>>> " + jsonString);
					}
				}
			}
		}
	}
	
	private String getToValue(FieldInfo info) throws Exception {
		
		String ret = null;
		
		String fromValue = info.getFromValue();
		String fieldType = info.getFieldType();
		
		if (!fieldType.equals("STRING") && fromValue.trim().length() > 0) {
			if (fieldType.equals("LONG")) {
				ret = String.format("%d", Long.parseLong(fromValue));
			} else if (fieldType.equals("INTEGER")) {
				ret = String.format("%d", Integer.parseInt(fromValue));
			} else if (fieldType.equals("DATE")) {
				ret = fromValue.substring(0, 4) + "/" + fromValue.substring(4, 6) + "/" + fromValue.substring(6, 8);
			} else if (fieldType.equals("TIME")) {
				ret = fromValue.substring(0, 2) + ":" + fromValue.substring(2, 4) + ":" + fromValue.substring(4, 6);
			} else {
				throw new Exception(String.format("ERROR: wrong FieldType '%s'..... in DocInfo.", fieldType));
			}
		} else {
			ret = fromValue.trim();  // string은 공백 삭제ㅠ
		}

		return ret;
	}
}
