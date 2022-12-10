package com.user.service.app.service.Impl;

import com.user.service.app.dto.DepartmentDto;
import com.user.service.app.dto.ResponseDto;
import com.user.service.app.dto.UserDto;
import com.user.service.app.model.User;
import com.user.service.app.repository.UserRepository;
import com.user.service.app.service.APIClient;
import com.user.service.app.service.UserServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author danfe
 */

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInter {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private APIClient apiClient;

    @Override
    public User saveUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public ResponseDto getUser(Long userId) {
        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();
        UserDto userDto = mapToUser(user);

        DepartmentDto departmentDto = apiClient.getDepartmentById(user.getDepartmentId());
        
        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }
    
    private UserDto mapToUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
