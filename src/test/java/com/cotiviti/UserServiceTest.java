package com.cotiviti;

import com.cotiviti.model.User;
import com.cotiviti.repository.UserRepository;
import com.cotiviti.repository.UserRepositoryImpl;
import com.cotiviti.service.UserService;
import com.cotiviti.service.UserServiceImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepositoryImpl userRepository;
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatedPassword;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
        firstName= "Nirajan";
        lastName = "Karki";
        email = "nirajan@gamil.com";
        password = "apple";
        repeatedPassword = "apple";
    }

    @DisplayName("User Created Test")
    @Test
    void testUserCreated_whenUserDetailsProvided_returnCreatedUser(){

        // arrange
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(true);
        // act
        User user =  userService.createUser(firstName, lastName, email, password, repeatedPassword);

        // assert
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(email, user.getEmail());
        assertNotNull(user);
        assertNotNull(user.getUserId(), "User is not missing");
        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));
    }

    @DisplayName("Throw Illegal Test Exception")
    @Test
    void testUserCreated_WhenFirstNameIsEmpty_ThrowIllegalException(){
        // arrange

        String firstName= "";
        String expectedException = "firstname is empty";

        // act
        IllegalArgumentException il = assertThrows(IllegalArgumentException.class, () -> userService.createUser(firstName,lastName, email,password, repeatedPassword),
                "First name should not empty");

        //assert
        assertEquals(expectedException, il.getMessage());
    }
}
