package com.example.app.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.User;
import com.example.app.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class UserServicImpl implements UserService {
	
	private final UserMapper usermapper;
	
	@Override
	public boolean isCorrectIdAndPassword(String loginId, String loginPass) throws Exception {
		
		User user = usermapper.selectByLoginId(loginId);
		
		if(user == null) {
			return false;
		}
		
		if(!BCrypt.checkpw(loginPass, user.getLoginPass())) {
			return false;
		}
		
		return true;
	}

}
