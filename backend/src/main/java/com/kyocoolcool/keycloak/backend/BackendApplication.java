package com.kyocoolcool.keycloak.backend;

import com.kyocoolcool.keycloak.backend.bill.BillRepository;
import com.kyocoolcool.keycloak.backend.member.Member;
import com.kyocoolcool.keycloak.backend.member.MemberRepository;
import com.kyocoolcool.keycloak.backend.util.Data;
import com.kyocoolcool.keycloak.backend.util.DataTransfer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@Log4j2
@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	@Autowired
	DataTransfer dataTransfer;

	@Autowired
	BillRepository billRepository;

//	@Autowired
//	MemberData memberData;

	@Autowired
	Data data;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) {
//		log.info(memberRepository.findAll());
		log.info(data);
//		log.info(billRepository.findBillsByProductId(1));
//		for (int i = 0; i < args.length; ++i) {
//			log.info("args[{}]: {}", i, args[i]);
//		}
//		log.info(memberData.getMemberMap());
	}

}
