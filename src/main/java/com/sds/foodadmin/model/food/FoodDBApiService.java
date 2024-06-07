package com.sds.foodadmin.model.food;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sds.foodadmin.domain.FoodDB;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Service
public class FoodDBApiService implements FoodDBService {

	@Autowired
	private String key; // 안 불러와짐, 나중에 해결

	@Autowired
	private FoodDBDAO foodDBDAO;

	String jsonString;

	private final ObjectMapper objectMapper = new ObjectMapper();
	
	

	public String getData() {
		jsonString = "";

		log.debug("key 날라옴?=========" + key);
		String urlFrame = "https://openapi.foodsafetykorea.go.kr/api/";

		try {
			StringBuilder stringBuilder = new StringBuilder(urlFrame); // URL헤드
			stringBuilder.append(key); // 키값 : key 못불러와서 수동맵핑. 나중에 수정
			stringBuilder.append("/I2790/json/1"); // 서비스코드 + 객체형테 + 1번째 콘텐츠 호출
			stringBuilder.append("/10"); // 1번 호출 시 999개 호출할 수 있음 (변수)
			URL url = new URL(stringBuilder.toString());
			log.debug("조립한 url은" + url);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			log.debug("Response code: " + conn.getResponseCode());

			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			jsonString = sb.toString();

			log.debug("추출했음?=========" + jsonString); // 들어왔는지 확인

			// 앞에 헤드 값과 result 때문에 파싱 시 오류남. row의 값만 가져오도록 설정
			JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
			JsonArray rowArray = jsonObject.getAsJsonObject("I2790").getAsJsonArray("row");
			jsonString = rowArray.toString(); // 이 시점에서 jsonString은 row 안의 값만 가져옴

			rd.close();
			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonString;
	}
	
	

	@Override
	public List<FoodDB> createFoodList(String jsonString) {

		log.debug("create 메서드에 string 넘어옴?===" + jsonString);

		// String 을 FoodDB 행렬로 담을 객체 미리 만듦
		List<FoodDB> foodDBList = new ArrayList<>();

		try {
			//
			JsonNode jsonArray = objectMapper.readTree(jsonString);

			if (jsonArray.isArray()) {

				for (JsonNode jsonObject : jsonArray) {

					// 각 필드에 대한 데이터 확인 후 파싱
					if (jsonObject.has("DESC_KOR") && jsonObject.has("NUTR_CONT1") && jsonObject.has("NUTR_CONT2")
							&& jsonObject.has("NUTR_CONT3") && jsonObject.has("NUTR_CONT4")
							&& jsonObject.has("NUTR_CONT5") && jsonObject.has("NUTR_CONT6")) {

						String foodname = jsonObject.get("DESC_KOR").asText(); // 음식명
						float kcal = jsonObject.has("NUTR_CONT1") ? (float) jsonObject.get("NUTR_CONT1").asDouble()
								: 0.0f; // 열량
						float carbohydrate = jsonObject.has("NUTR_CONT2")
								? (float) jsonObject.get("NUTR_CONT2").asDouble()
								: 0.0f; // 탄수화물
						float protein = jsonObject.has("NUTR_CONT3") ? (float) jsonObject.get("NUTR_CONT3").asDouble()
								: 0.0f; // 단백질
						float fat = jsonObject.has("NUTR_CONT4") ? (float) jsonObject.get("NUTR_CONT4").asDouble()
								: 0.0f; // 지방
						float sugar = jsonObject.has("NUTR_CONT5") ? (float) jsonObject.get("NUTR_CONT5").asDouble()
								: 0.0f; // 당류
						float sodium = jsonObject.has("NUTR_CONT6") ? (float) jsonObject.get("NUTR_CONT6").asDouble()
								: 0.0f; // 나트륨

						// FoodDB 객체 생성
						FoodDB foodDB = new FoodDB();
						foodDB.setFoodname(foodname);
						foodDB.setKcal(kcal);
						foodDB.setCarbohydrate(carbohydrate);
						foodDB.setProtein(protein);
						foodDB.setFat(fat);
						foodDB.setSugar(sugar);
						foodDB.setSodium(sodium);

						foodDBList.add(foodDB);

					} else {
						// 필요한 필드가 존재하지 않을 경우 로그 남기거나 예외 처리 등을 수행
						log.debug("필수 필드가 존재하지 않습니다.");
					}
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return foodDBList;
	}

	@Override
	public void insertFoodDB(List<FoodDB> foodDBList) {
		// FoodDB 객체를 데이터베이스에 삽입
		foodDBDAO.insertFoodDB(foodDBList);

	}

	@Override
	public FoodDB select(FoodDB foodDB) {
		return foodDBDAO.select(foodDB);
	}

	@Override
	public List selectAll() {
		return foodDBDAO.selectAll();
	}

	@Override
	public void deleteFoodDB() {
		foodDBDAO.deleteFoodDB();

	}

}

/*
 * restTemplate방식(백업용)
 * 
 */