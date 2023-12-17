package br.com.dreamtravel.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.dreamtravel.model.Role;
import br.com.dreamtravel.model.User;
import br.com.dreamtravel.model.form.UserDto;
import br.com.dreamtravel.repository.RoleRepository;
import br.com.dreamtravel.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public User findByUsername(String username) {
		
		User user = repo.findByUsername(username);
		
		return user;
	}
	
	public void save(UserDto userDto, String roleName) {
		
		User user = new User();
		
		user.setUsername(userDto.getUsername());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		Role role = roleRepo.findByName(roleName);
		if (role == null) {
			role = checkRoleExist(roleName);
		}
		
		user.setRoles(Arrays.asList(role));
		repo.save(user);		
	}
	
    private Role checkRoleExist(String roleName){
        Role role = new Role();
        role.setName(roleName);
        return roleRepo.save(role);
    }
}
