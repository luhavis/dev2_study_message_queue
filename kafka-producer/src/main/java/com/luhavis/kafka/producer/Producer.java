package com.luhavis.kafka.producer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer {
    private static String TOPIC_NAME = "test";

    /** Broker의 호스트 IP 정보
     *  여러 Broker의 호스트 IP 정보 설정 시 콤마(,)로 구분
     *  예) 192.168.0.1:9092,192.168.0.2:9092
     *  */
    private static String BOOTSTRAP_SERVERS = "172.22.84.198:29092";

    public static void main () {
        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(configs);


        for (int i=0; i<10; i++) {
            String data = "data " + i;
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, Integer.toString(i), data);
            try {
                producer.send(record);
                System.out.println("Send to " + TOPIC_NAME + " | data : " + data);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
