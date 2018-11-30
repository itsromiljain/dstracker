package com.tracker.service.user;

import java.util.List;
import java.util.Optional;

import com.tracker.model.user.UserDetails;

public interface UserService {
	public List<UserDetails> getAllUser();
	public Optional<UserDetails> getUser(long id);
	public UserDetails addUser(UserDetails s);
	public void UpdateUser(UserDetails s);
	public void deleteUser(long id);

}
