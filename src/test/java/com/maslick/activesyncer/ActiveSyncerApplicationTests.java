package com.maslick.activesyncer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveSyncerApplicationTests {

	@Test
	public void contextLoads() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://localhost:8080")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		DbRetrofitUploader uploader = retrofit.create(DbRetrofitUploader.class);

		List<RawData> datas = new ArrayList<>();
		RawData data = RawData.builder()
				.alpha(1)
				.beta(1)
				.gamma(1)
				.ax(1)
				.ay(1)
				.az(1)
				.hr(1)
				.timestamp(1)
				.build();

		datas.add(data);
		datas.add(data);
		datas.add(data);


		Call<Message> call = uploader.syncNow(datas);
		try {
			Message mes = call.execute().body();
			System.out.println(mes.status + ": " + mes.message);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
