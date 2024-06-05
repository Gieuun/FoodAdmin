package com.sds.foodadmin.model.food;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sds.foodadmin.domain.FoodDB;
import com.sds.foodadmin.exception.ApiLoadException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FoodDBApiService implements FoodDBService {

	@Value("${food.key}")
	private String key;

	@Autowired
	private FoodDBDAO foodDBDAO;

	private final String urlFrame;

	public FoodDBApiService() {
		this.urlFrame = "https://openapi.foodsafetykorea.go.kr/api/" + key + "/I2790/json/";
	}

	@Override
	public void insertFoodDB() {
		int startIndex = 1;
		int endIndex = 5;

		boolean exploreDB = true;
		while (exploreDB) {
			String callUrl = urlFrame + startIndex + "/" + endIndex;

			try {
				Document doc = Jsoup.connect(callUrl).get();
				Elements dataElements = doc.select("data");

				for (Element dataElement : dataElements) {
					FoodDB food = new FoodDB();

					// Json 데이터를 FoodDB의 양식으로 세팅해주기
					food.setFoodname(dataElement.select("DESC_KOR").text()); // 음식명
					food.setKcal(Float.parseFloat(dataElement.select("NUTR_CONT1").text())); // 열량
					food.setCarbohydrate(Float.parseFloat(dataElement.select("NUTR_CONT2").text())); // 탄수화물
					food.setProtein(Float.parseFloat(dataElement.select("NUTR_CONT3").text())); // 단백질
					food.setFat(Float.parseFloat(dataElement.select("NUTR_CONT4").text())); // 지방
					food.setSugar(Float.parseFloat(dataElement.select("NUTR_CONT5").text())); // 당류
					food.setSodium(Float.parseFloat(dataElement.select("NUTR_CONT6").text())); // 나트륨
					// FoodDB를 DB에 삽입
					foodDBDAO.insertFoodDB(food);
				}
				exploreDB = false; // 데이터가 없으면 더 이상 요청하지 않음
			} catch (IOException e) {
				exploreDB = false;
				throw new ApiLoadException("API 데이터 읽어오기 실패 ;" + e);
			}
		}
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return foodDBDAO.selectCount();
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
 * restTemplate방식(백업용) private final RestTemplate restTemplate; private final
 * ObjectMapper objectMapper;
 * 
 * public FoodDBApiService(RestTemplate restTemplate, ObjectMapper objectMapper)
 * { // 맵핑에 쓸 템플릿과 맵퍼, 직접 의존성 주입. url 초기화 시점을 맵초기화와 같이 한다. this.restTemplate =
 * restTemplate; this.objectMapper = objectMapper; }
 * 
 * String responseJson = restTemplate.getForObject(callUrl, String.class);
 * 
 * for문 부분 JsonNode dataNode = root.get("data"); if (dataNode != null &&
 * dataNode.isArray()) { for (JsonNode item : dataNode) {
 * food.setFoodname(item.get("DESC_KOR").asText()); // 음식명
 * food.setKcal(item.get("NUTR_CONT1").asInt()); // 열량
 * food.setCarbohydrate(item.get("NUTR_CONT2").asInt()); // 탄수화물
 * food.setProtein(item.get("NUTR_CONT3").asInt()); // 단백질
 * food.setFat(item.get("NUTR_CONT4").asInt()); // 지방
 * food.setSugar(item.get("NUTR_CONT5").asInt()); // 지방
 * food.setSodium(item.get("NUTR_CONT6").asInt()); // 나트륨
 */