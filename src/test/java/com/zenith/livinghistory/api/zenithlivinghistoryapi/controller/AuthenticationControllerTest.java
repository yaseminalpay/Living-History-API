package com.zenith.livinghistory.api.zenithlivinghistoryapi.controller;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.dto.User;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.dto.request.SignUpRequest;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AuthenticationControllerTest {

    @InjectMocks
    private AuthenticationController sut = new AuthenticationController();

    @Mock
    private UserService userService;

    @Mock
    private SignUpRequest signUpRequest;

    @Mock
    private User userMock;

    @Before
    public void beforeMethod() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void initialState_userIsNotExistingWithEmail_SignUp() {
        User nullUser = null;
        Mockito.when(userService.findByEmail(Mockito.anyString())).thenReturn(nullUser);
        sut.signup(signUpRequest);
        Mockito.verify(userService, Mockito.times(1)).createUser(signUpRequest);
    }

    @Test
    public void initialState_userIsNotExistingWithUserName_SignUp() {
        User nullUser = null;
        Mockito.when(userService.findByUsername(Mockito.anyString())).thenReturn(nullUser);
        sut.signup(signUpRequest);
        Mockito.verify(userService, Mockito.times(1)).createUser(signUpRequest);
    }

    @Test
    public void initialState_userIsNotExistingByEmail_SignUp() {

        User user = Mockito.mock(User.class);
        Mockito.when(userService.findByEmail(Mockito.anyString())).thenReturn(user);

        sut.signup(signUpRequest);
        Mockito.verify(userService, Mockito.times(0)).createUser(signUpRequest);
    }

    @Test
    public void initialState_userIsNotExistingByUserName_SignUp() {

        User user = Mockito.mock(User.class);
        Mockito.when(userService.findByUsername(Mockito.anyString())).thenReturn(user);

        sut.signup(signUpRequest);
        Mockito.verify(userService, Mockito.times(0)).createUser(signUpRequest);
    }

 }
