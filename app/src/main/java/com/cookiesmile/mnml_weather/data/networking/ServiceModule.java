package com.cookiesmile.mnml_weather.data.networking;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module(includes = NetworkModule.class)
public abstract class ServiceModule {

  @Provides
  @Singleton
  static Retrofit provideRetrofit(Call.Factory callFactory,
      @Named("base_url") String baseUrl) {
    return new Retrofit.Builder()
        .callFactory(callFactory)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(baseUrl)
        .build();
  }
}
