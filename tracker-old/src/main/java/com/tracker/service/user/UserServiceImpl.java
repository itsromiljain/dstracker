package com.tracker.service.user;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.model.user.UserDetails;
import com.tracker.repository.user.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public List<UserDetails> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public Optional<UserDetails> getUser(long id) {
		return userRepository.findById(id);
	}

	@Override
	public UserDetails addUser(UserDetails s) {
		return userRepository.save(s);
		
	}

	@Override
	public void UpdateUser(UserDetails s) {
		userRepository.save(s);
		
	}

	@Override
	public void deleteUser(long id) {
		 userRepository.deleteById(id);
		
	}

}
