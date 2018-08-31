package com.iot;

import com.iot.officalsite.repository.MemberRepository;
import com.iot.sign.model.login.SignMember;
import com.iot.sign.repository.SignMemberRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IotApplicationTests {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private SignMemberRepo signMemberRepo;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 26; i++) {
            signMemberRepo.save(new SignMember("lp",2,0));
        }
    }
}
