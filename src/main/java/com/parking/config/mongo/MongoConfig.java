package com.parking.config.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {
    @Bean
  public MongoDatabaseFactory configDatabase(){
   return  new SimpleMongoClientDatabaseFactory("mongodb+srv://hebertsantos0704:EDuHbC1Rfi6z1CSS@parking-cluster.t5nuxkd.mongodb.net/Parking-database?retryWrites=true&w=majority&appName=parking-cluster");
  };
  @Bean
    public MongoTemplate mongoTemplate(){
     return  new MongoTemplate(configDatabase());
  }
}
