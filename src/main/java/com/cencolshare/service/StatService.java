package com.cencolshare.service;

import com.cencolshare.model.User;
import com.cencolshare.model.response.StatResponse;

public interface StatService {
	
	StatResponse getStatistics(User user);

}
