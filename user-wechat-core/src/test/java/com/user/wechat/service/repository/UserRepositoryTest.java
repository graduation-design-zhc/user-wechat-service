package com.user.wechat.service.repository;

import com.user.wechat.service.MainApplication;
import com.user.wechat.service.model.MemberDO;
import com.user.wechat.service.model.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhanghuachang
 * @date 2019-04-20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Resource
    private MemberRepository memberRepository;

    @Test
    public void findUserDOByUserNameAndPassword() {
        UserDO userDO = userRepository.findUserDOByUserNameAndPassword("admin", "admin");
        assert userDO != null;
    }

    @Test
    public void findMember() {
        List<MemberDO> list = memberRepository.findAll();
        assert list.size() > 0;
    }

    @Test
    public void deleteMember() {
        int i = memberRepository.deleteByMemberId("254201fc27cd4a04b6bbae18643c027d");
        System.out.println(i);
    }

    @Test
    public void findAllMemberCreateTime() {
        List<MemberDO> list = memberRepository.findAllByOrderByCreateTimeDesc();
        assert  list.size() > 0;
    }

    @Test
    public void findByOpenId() {
        MemberDO memberDO = memberRepository.findByOpenId("adfniuebfKJFHDFB");
        assert memberDO != null;
    }

}