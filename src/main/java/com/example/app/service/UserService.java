package com.example.app.service;

public interface UserService {
	
	boolean isCorrectIdAndPassword(String loginId,
									String loginPass
									)throws Exception;

}
